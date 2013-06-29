package com.book.identification.volumes;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.book.identification.BookFile;
import com.book.identification.ClientCredentials;
import com.book.identification.model.VolumeInfo;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.BooksRequestInitializer;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GoogleBooksRetrieveVolumeInfo implements RetrieveVolumeInfo {
	final static Logger logger = LogManager.getLogger(GoogleBooksRetrieveVolumeInfo.class);

	private NetHttpTransport netHttpTransport;
	private JacksonFactory jacksonFactory;

	public GoogleBooksRetrieveVolumeInfo(NetHttpTransport netHttpTransport,JacksonFactory jacksonFactory) {
		this.netHttpTransport = netHttpTransport;
		this.jacksonFactory = jacksonFactory;
	}

	@Override
	public com.book.identification.model.Volume retriveVolumeInfo(BookFile fileIsbn) {
		com.book.identification.model.Volume foundVolume = null;
		Books books = new Books.Builder(netHttpTransport,
				jacksonFactory, null)
				.setApplicationName("Books-ID")
				.setGoogleClientRequestInitializer(
						new BooksRequestInitializer(ClientCredentials.API_KEY))
				.build();

		Volumes volumes = null;
		try {
			volumes = books.volumes().list("isbn:" + isbnNumber(fileIsbn.getIsbn())).setFields("totalItems,items/id")
					.execute();

			if (volumes != null && volumes.getTotalItems() != null && volumes.getTotalItems() > 0) {
					Volume volume = volumes.getItems().get(0);
					logger.info("Search on goolge api book with isbn:" + fileIsbn.getIsbn());
					Volume execute = books.volumes().get(volume.getId()).setProjection("full").execute();
					Gson gson = new GsonBuilder().create();
					try {
						foundVolume = gson.fromJson(execute.toString(),com.book.identification.model.Volume.class);
						foundVolume.setPath(fileIsbn.getFile().getAbsolutePath());
						foundVolume.setFileName(fileIsbn.getFile().getName());
						foundVolume.setHashSH1(fileIsbn.getHash());
						foundVolume.setFileType(fileIsbn.getFileType());
					} catch (Exception e) {
						logger.error(e);
					}

			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return foundVolume;
	}
	private String isbnNumber(String isbn2) {
		StringBuilder stringBuilder = new StringBuilder();
		String replace = StringUtils
				.replace(isbn2.toUpperCase(), "ISBN-10", "");
		replace = StringUtils.replace(isbn2.toUpperCase(), "ISBN-13", "");
		replace = StringUtils.replace(isbn2.toUpperCase(), "ISBN", "");
		char[] charArray = replace.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if (Character.isDigit(c) || Character.valueOf(c).equals('X')) {
				stringBuilder.append(Character.toString(c));
			}

		}
		return stringBuilder.toString();
	}

}