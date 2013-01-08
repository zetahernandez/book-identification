package com.book.identification.task;

import java.util.concurrent.BlockingQueue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.book.identification.FileISBN;
import com.book.identification.FilePDF;
import com.book.identification.task.base.ProducerConsumer;
import com.book.identification.task.base.ProducerConsumerManager;
import com.book.identification.task.base.ProducerThread;


public class BookReader extends ProducerConsumerManager<ProducerThread<FileISBN>,FileISBN, FilePDF> {
	
	Logger logger = LogManager.getLogger(BookReader.class);

	public BookReader(String name, BlockingQueue<FilePDF> input,
			BlockingQueue<FileISBN> output,
			ProducerConsumer nextProducerConsumer) {
		super(name, input, output, nextProducerConsumer);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected ProducerThread<FileISBN> createConsumerWork(FilePDF take,
			BlockingQueue<FileISBN> output) {
		return new SearchISBN(take.getFile(), output);
	}
	
}
