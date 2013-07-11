package com.book.identification.rest;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.book.identification.BookFile;
import com.book.identification.FileType;
import com.book.identification.model.Volume;
import com.book.identification.volumes.CheckNoRepitAndSaveVolume;
import com.book.identification.work.GoogleBooksRetrieveVolumeInfo;
import com.book.identification.work.ISBNExtract;
import com.book.identification.work.ISBNExtractorFactory;
import com.book.identification.work.exceptions.CantOpenFileException;
import com.book.identification.work.exceptions.ISBNNotFoundExecption;
import com.book.identification.work.exceptions.NotPersistExeption;
import com.book.identification.work.exceptions.VolumeExistExeption;
import com.book.identification.work.exceptions.VolumeNotFoundExecption;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

/**
 * @author zeta
 *
 */
public class IdentificateBooks {

	Logger logger = LogManager.getLogger(IdentificateBooks.class);
	
	private List<Path> paths;
	
	private NetHttpTransport netHttpTransport = new NetHttpTransport();
	private JacksonFactory jacksonFactory = new JacksonFactory();

	public IdentificateBooks(List<java.nio.file.Path> paths) {
		this.paths = paths;
	}

	public IdentificationResult startIdentification() {
		GoogleBooksRetrieveVolumeInfo googleBooksRetrieveVolumeInfo = new GoogleBooksRetrieveVolumeInfo(netHttpTransport, jacksonFactory);

		IdentificationResult result = new IdentificationResult();
		for (Path path : paths) {
			FileType fileType = FileType.PDF;
			//TODO: Obtain fileType
//			FileType fileType = FileType.valueOf(path.toFile());
			String sha256Hex = null;
			try {
				sha256Hex = DigestUtils.shaHex(FileUtils.openInputStream(path.toFile()));
			} catch (IOException e1) {
				result.addErrorTo(path,new CantOpenFileException(e1));
			}
			ISBNExtract isbnExtractor = ISBNExtractorFactory.getIsbnExtractor(fileType);
			BookFile bookFile = new BookFile(path.toFile(), sha256Hex , fileType);
			
			try {
				String isbn = isbnExtractor.foundISBN(path.toFile());
				bookFile.setIsbn(isbn);
				
				Volume volume = googleBooksRetrieveVolumeInfo.retriveVolumeInfo(bookFile);
				
				new CheckNoRepitAndSaveVolume().checNoRepeatAndSave(volume);
				result.addResultVolume(path, volume);
			} catch (CantOpenFileException | ISBNNotFoundExecption | VolumeNotFoundExecption | NotPersistExeption | VolumeExistExeption e) {
				result.addErrorTo(path,e);
			} catch (IOException e) {
				result.addErrorTo(path,new VolumeNotFoundExecption("0"));
			}
		}
		return result;
	}
}
