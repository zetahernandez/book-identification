package com.book.identification.task;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;

import com.book.identification.FileFilter;
import com.book.identification.FilePDF;
import com.book.identification.task.base.ProducerConsumer;

public class BookSearch extends Thread {

	public final BlockingQueue<FilePDF> fileQueue;
	public ConcurrentSkipListSet<File> indexedFiles = new ConcurrentSkipListSet<File>();
	public final FileFilter fileFilter;
	private final File root;
	private ProducerConsumer producerConsumer;

	public BookSearch(BlockingQueue<FilePDF> fileQueue,
			final FileFilter fileFilter, File root,ProducerConsumer producerConsumer) {
		super("BookSearch");
		this.fileQueue = fileQueue;
		this.root = root;
		this.fileFilter = fileFilter;
		this.producerConsumer = producerConsumer;
	}

	@Override
	public void run() {

		FoundFileAndQueueTask foundFilesTask = new FoundFileAndQueueTask(this, root);
		foundFilesTask.start();
		try {
			foundFilesTask.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		producerConsumer.notifyEndProducers();
	}

	
}
