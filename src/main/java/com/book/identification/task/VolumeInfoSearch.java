package com.book.identification.task;

import java.util.concurrent.BlockingQueue;

import com.book.identification.FileISBN;
import com.book.identification.model.Volume;
import com.book.identification.task.base.ProducerConsumer;
import com.book.identification.task.base.ProducerConsumerManager;
import com.book.identification.task.base.ProducerThread;

public class VolumeInfoSearch extends ProducerConsumerManager<ProducerThread<Volume>, Volume, FileISBN> {


	public VolumeInfoSearch(String name, BlockingQueue<FileISBN> input,
			BlockingQueue<Volume> output, ProducerConsumer nextProducerConsumer) {
		super(name, input, output, nextProducerConsumer);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected ProducerThread<Volume> createConsumerWork(FileISBN take,
			BlockingQueue<Volume> output) {
		return new ISBNRequest(take,output);
	}

}
