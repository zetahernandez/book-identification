package com.book.identification.task;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.book.identification.ClientCredentials;
import com.book.identification.FileISBN;
import com.book.identification.task.base.ProducerThread;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.BooksRequestInitializer;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ISBNRequest extends
		ProducerThread<com.book.identification.model.Volume> {
	final static Logger logger = LogManager.getLogger(ISBNRequest.class);
	/**
	 * 
	 */
	private FileISBN fileIsbn;

	private BlockingQueue<com.book.identification.model.Volume> volumesQueue;

	public ISBNRequest(FileISBN isbn,
			BlockingQueue<com.book.identification.model.Volume> volumesQueue) {
		super("ISBNRequest-" + isbn);
		this.volumesQueue = volumesQueue;
		this.fileIsbn = isbn;
	}

	@Override
	public void run() {
		Books books = new Books.Builder(new NetHttpTransport(),
				new JacksonFactory(), null)
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
					com.book.identification.model.Volume volume2 = null;
					try {
						volume2 = gson.fromJson(execute.toString(),com.book.identification.model.Volume.class);
						volume2.setPath(fileIsbn.getFile().getAbsolutePath());
						volume2.setFileName(fileIsbn.getFile().getName());
					} catch (Exception e) {
						logger.error(e);
					}
					if (volume2 != null) {
						logger.debug("found Volume: ----- >\n" + volume2.toString());
						volumesQueue.put(volume2);
					}

			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
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