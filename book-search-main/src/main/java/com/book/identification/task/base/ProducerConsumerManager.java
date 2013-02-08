// Copyright 2013 fernando.hernandez

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

//   http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.book.identification.task.base;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public abstract class ProducerConsumerManager<P extends ProducerThread<IP>, IP extends ItemQueue, IC extends ItemQueue>
		extends Thread implements ProducerConsumer {

	protected Logger logger = LogManager.getLogger(getClass());
	private Object mutex = new Object();

	private BlockingQueue<IC> input;
	private BlockingQueue<IP> output;

	ExecutorService executorService = null;

	private AtomicBoolean finishedProdcers = new AtomicBoolean(false);
	private Thread finalizer;
	private ProducerConsumer nextProducerConsumer;
	private	long startTime = 0;

	public ProducerConsumerManager(final String name, BlockingQueue<IC> input,
			BlockingQueue<IP> output, ProducerConsumer nextProducerConsumer) {
		super(name);
		this.input = input;
		this.output = output;
		this.nextProducerConsumer = nextProducerConsumer;
		executorService = Executors.newFixedThreadPool(10,new ThreadFactory() {
			AtomicInteger atomicInteger = new AtomicInteger(0);
			public Thread newThread(Runnable r) {
				return new Thread(r, name + "-pool-" + atomicInteger.addAndGet(1));
			}
		});
	}

	private boolean finished() {
		synchronized (mutex) {
			return finishedProdcers.get() && input.isEmpty();
		}
	}

	@Override
	public void run() {
		startTime = System.currentTimeMillis();
		logger.info(this.toString() + " start at " + new Date()  );
		while (!finished()) {
			try {
				IC item = input.take();
				if(acceptWork(item)){
					P consumerWork = createConsumerWork(item, output);
					executorService.submit(consumerWork);
				}

			} catch (InterruptedException e) {
				logger.debug("Interrupted " + getName());
				Thread.currentThread().interrupt();
			}
		}
	}

	protected abstract boolean acceptWork(IC item);

	protected abstract P createConsumerWork(IC take, BlockingQueue<IP> output);

	public void notifyEndProducers() {
		logger.debug("NOTIFY END PRODUCERS");
		finalizer = new Thread("finalizer-" + getName()) {
			@Override
			public void run() {
				while (!finished()) {
					try {
						sleep(1000);
						if(input.isEmpty() && !finishedProdcers.get()){
							logger.debug("Call Finalizer");
							finalizer();
						} 
					} catch (InterruptedException e) {
						logger.debug("Interrupted-" + getName());
					}
				}
				logger.debug("Finalizer End");
			}
		};
		finalizer.start();
	}

	public void finalizer() {
		finishedProdcers.set(true);
		this.executorService.shutdown();
		try {
			logger.debug("waiting to executor shutdown");
			this.executorService.awaitTermination(10, TimeUnit.MINUTES);
			logger.debug("executor shutdown");
		} catch (InterruptedException e) {
			logger.debug("executorService.awaitTermination  - Interrupted-" + getName());
		}
		if (nextProducerConsumer != null) {
			nextProducerConsumer.notifyEndProducers();
		}
		logger.debug("Interrupt this Thread");
		logger.info(this.toString() + " running " +   ((System.currentTimeMillis() - startTime)/1000) + "seg");
		this.interrupt();
	}
}
