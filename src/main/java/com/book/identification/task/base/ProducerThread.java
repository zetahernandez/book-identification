package com.book.identification.task.base;

public abstract class ProducerThread<I extends ItemQueue> extends Thread implements Producer<I>{

	public ProducerThread() {
		super();
	}

	public ProducerThread(Runnable target, String name) {
		super(target, name);
	}

	public ProducerThread(Runnable target) {
		super(target);
	}

	public ProducerThread(String name) {
		super(name);
	}

	public ProducerThread(ThreadGroup group, Runnable target, String name,
			long stackSize) {
		super(group, target, name, stackSize);
	}

	public ProducerThread(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
	}

	public ProducerThread(ThreadGroup group, Runnable target) {
		super(group, target);
	}

	public ProducerThread(ThreadGroup group, String name) {
		super(group, name);
	}

}
