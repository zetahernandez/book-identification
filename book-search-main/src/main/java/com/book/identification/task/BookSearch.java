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

import java.io.File;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.book.identification.FileFilter;
import com.book.identification.FilePDF;
import com.book.identification.dao.DAOFactory;
import com.book.identification.model.Volume;
import com.book.identification.task.base.ProducerConsumer;

public class BookSearch extends Thread {

	final static Logger logger = LogManager.getLogger(BookSearch.class);
	
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
		
		List<Volume> volumes = DAOFactory.getInstance().getVolumeDAO().findAll();
		
		for (Volume volume : volumes) {
			indexedFiles.add(new File(volume.getPath()));
		}
		
		FoundFileAndQueueTask foundFilesTask = new FoundFileAndQueueTask(this, root);
		foundFilesTask.start();
		try {
			foundFilesTask.join();
		} catch (InterruptedException e) {
			logger.error(e.getMessage());
		}
		producerConsumer.notifyEndProducers();
	}

	
}
