package com.book.identification.task;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;

import com.book.identification.FileISBN;
import com.book.identification.FilePDF;
import com.book.identification.dao.DAOFactory;
import com.book.identification.model.Volume;
import com.book.identification.task.base.ProducerConsumer;
import com.book.identification.task.base.ProducerConsumerManager;
import com.book.identification.task.base.ProducerThread;


public class BookReader extends ProducerConsumerManager<ProducerThread<FileISBN>,FileISBN, FilePDF> {
	
	final static Logger logger = LogManager.getLogger(BookReader.class);

	public BookReader(String name, BlockingQueue<FilePDF> input,
			BlockingQueue<FileISBN> output,
			ProducerConsumer nextProducerConsumer) {
		super(name, input, output, nextProducerConsumer);
	}


	@Override
	protected ProducerThread<FileISBN> createConsumerWork(FilePDF take,
			BlockingQueue<FileISBN> output) {
		
		List<Volume> volumes = DAOFactory.getInstance().getVolumeDAO().findByCriteria(Restrictions.eq("hashSH1", take.getHash()));
		if(volumes.size()==0){
			return new SearchISBN(take, output);
		}else{
			return null;
		}
		
	}
	
}
