package com.book.identification.task;

import java.io.File;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.book.identification.FilePDF;


public class FoundFileAndQueueTask extends Thread {
	Logger logger = LogManager.getLogger(FoundFileAndQueueTask.class);
	/**
	 * 
	 */
	private final BookSearch bookSearch;
	private final File file;

	public FoundFileAndQueueTask(BookSearch bookSearch, File file) {
		this.bookSearch = bookSearch;
		this.file = file;
	}

	public void run() {
		if (Thread.currentThread().isInterrupted())
			return;

		File[] entries = file.listFiles(this.bookSearch.fileFilter);

		if (entries != null) {
			for (File entry : entries)
				if (entry.isDirectory()) {
					FoundFileAndQueueTask foundFileAndQueueTask = new FoundFileAndQueueTask(bookSearch, entry);
					foundFileAndQueueTask.start();
					try {
						foundFileAndQueueTask.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else if (entry != null && !this.bookSearch.indexedFiles.contains(entry)) {
					this.bookSearch.indexedFiles.add(entry);
					try {
						logger.debug("Accepted file -> " + entry.getName());
						this.bookSearch.fileQueue.put(new FilePDF(entry));
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					} catch (Throwable e) {
						Thread.currentThread().interrupt();
					}
				}
		}
	}
}