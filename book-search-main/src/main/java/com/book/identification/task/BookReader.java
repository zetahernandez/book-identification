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
		
			return new SearchISBN(take, output);
		
	}


	@Override
	protected boolean acceptWork(FilePDF item) {
		List<Volume> volumes = DAOFactory.getInstance().getVolumeDAO().findByCriteria(Restrictions.eq("hashSH1", item.getHash()));
		return volumes.size()==0;
	}
	
}
