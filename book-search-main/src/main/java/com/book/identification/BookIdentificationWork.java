package com.book.identification;

import java.io.File;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.book.identification.model.Volume;
import com.book.identification.task.BookReader;
import com.book.identification.task.BookSearch;
import com.book.identification.task.PersistVolumes;
import com.book.identification.task.VolumeInfoSearch;

public class BookIdentificationWork extends Thread {
	private static Logger logger = LogManager.getLogger(BookIdentificationWork.class);
	private String[] folders;
	BlockingQueue<FilePDF> fileBlockingQueue = new ArrayBlockingQueue<FilePDF>(
			10);
	BlockingQueue<FileISBN> fileISBNs = new ArrayBlockingQueue<FileISBN>(10);
	BlockingQueue<Volume> volumesQueue = new ArrayBlockingQueue<Volume>(10);

	PersistVolumes persistVolumes = new PersistVolumes("PersistVolumesThread",
			volumesQueue, volumesQueue, null);
	VolumeInfoSearch volumeInfoSearch = new VolumeInfoSearch(
			"VolumeInfoSearchThread", fileISBNs, volumesQueue, persistVolumes);
	BookReader bookReader = new BookReader("BookReaderThread",
			fileBlockingQueue, fileISBNs, volumeInfoSearch);

	public BookIdentificationWork(String name, String[] folders) {
		this.folders = folders;
	}

	@Override
	public void run() {

		logger.debug("BookIdentificationWork start at " + new Date());

		bookReader.start();
		volumeInfoSearch.start();
		persistVolumes.start();
		// initial Producers
		for (int i = 0; i < folders.length; i++) {
			File root = new File(folders[i]);
			if (root.isDirectory()) {

				BookSearch bookSearch = new BookSearch(fileBlockingQueue,
						new FileFilter(FileType.PDF), root, bookReader);
				bookSearch.start();
			}
		}
	}

}
