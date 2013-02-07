package com.book.identification.task;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;

import com.book.identification.dao.DAOFactory;
import com.book.identification.model.Volume;
import com.book.identification.task.base.ProducerConsumer;
import com.book.identification.task.base.ProducerConsumerManager;
import com.book.identification.task.base.ProducerThread;

public class PersistVolumes  extends ProducerConsumerManager<ProducerThread<Volume>, Volume, Volume> {
	
	final static Logger logger = LogManager.getLogger(PersistVolumes.class);

	public PersistVolumes(String name, BlockingQueue<Volume> input,
			BlockingQueue<Volume> output, ProducerConsumer nextProducerConsumer) {
		super(name, input, output, nextProducerConsumer);
	}


	@Override
	protected ProducerThread<Volume> createConsumerWork(Volume take,
			BlockingQueue<Volume> output) {
		return new SaveVolume(take);
	}


	@Override
	protected boolean acceptWork(Volume item) {
		List<Volume> volumes = DAOFactory.getInstance().getVolumeDAO().findByCriteria(Restrictions.eq("hashSH1", item.getHashSH1()));
		return volumes.size()==0;
	}


	
}
