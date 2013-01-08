package com.book.identification.task.base;

public abstract class ProducerThread<I extends ItemQueue> extends Thread implements Producer<I>{

	public ProducerThread() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProducerThread(Runnable target, String name) {
		super(target, name);
		// TODO Auto-generated constructor stub
	}

	public ProducerThread(Runnable target) {
		super(target);
		// TODO Auto-generated constructor stub
	}

	public ProducerThread(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public ProducerThread(ThreadGroup group, Runnable target, String name,
			long stackSize) {
		super(group, target, name, stackSize);
		// TODO Auto-generated constructor stub
	}

	public ProducerThread(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
		// TODO Auto-generated constructor stub
	}

	public ProducerThread(ThreadGroup group, Runnable target) {
		super(group, target);
		// TODO Auto-generated constructor stub
	}

	public ProducerThread(ThreadGroup group, String name) {
		super(group, name);
		// TODO Auto-generated constructor stub
	}

}
