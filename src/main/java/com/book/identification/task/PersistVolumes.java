package com.book.identification.task;

import java.util.concurrent.BlockingQueue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.book.identification.model.Volume;
import com.book.identification.task.base.ProducerConsumer;
import com.book.identification.task.base.ProducerConsumerManager;
import com.book.identification.task.base.ProducerThread;

public class PersistVolumes  extends ProducerConsumerManager<ProducerThread<Volume>, Volume, Volume> {

	public PersistVolumes(String name, BlockingQueue<Volume> input,
			BlockingQueue<Volume> output, ProducerConsumer nextProducerConsumer) {
		super(name, input, output, nextProducerConsumer);
		// TODO Auto-generated constructor stub
	}

	final Logger logger = LogManager.getLogger(PersistVolumes.class);
//	private BlockingQueue<Volume> volumesQueue;
//	private final ExecutorService exec = Executors.newFixedThreadPool(10);

	@Override
	protected ProducerThread<Volume> createConsumerWork(Volume take,
			BlockingQueue<Volume> output) {
		return new SaveVolume(take);
	}


//	public PersistVolumes(BlockingQueue<Volume> volumesQueue) {
//		super("PersistVolumes");
//		this.volumesQueue = volumesQueue;
//	}

//	@Override
//	public void run() {
//		while (true) {
//			try {
//				Volume volume = volumesQueue.take();
//				exec.submit(new SaveVolume(volume));
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	
}
