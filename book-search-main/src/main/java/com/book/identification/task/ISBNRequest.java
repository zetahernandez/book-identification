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

import java.io.IOException;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.book.identification.BookFile;
import com.book.identification.task.base.Work;
import com.book.identification.work.GoogleBooksRetrieveVolumeInfo;
import com.book.identification.work.exceptions.VolumeNotFoundExecption;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

public class ISBNRequest extends
		Work<com.book.identification.model.Volume> {
	final static Logger logger = LogManager.getLogger(ISBNRequest.class);
	
	private NetHttpTransport netHttpTransport = new NetHttpTransport();
	private JacksonFactory jacksonFactory = new JacksonFactory();
	/**
	 * 
	 */
	private BookFile fileIsbn;

	private BlockingQueue<com.book.identification.model.Volume> volumesQueue;

	public ISBNRequest(BookFile isbn,
			BlockingQueue<com.book.identification.model.Volume> volumesQueue) {
		super("ISBNRequest-" + isbn);
		this.volumesQueue = volumesQueue;
		this.fileIsbn = isbn;
	}

	@Override
	public void run() {
		GoogleBooksRetrieveVolumeInfo googleBooksRetrieveVolumeInfo = new GoogleBooksRetrieveVolumeInfo(netHttpTransport, jacksonFactory);
		com.book.identification.model.Volume volumeInfo = null;
		try {
			volumeInfo = googleBooksRetrieveVolumeInfo.retriveVolumeInfo(fileIsbn);
		} catch (IOException | VolumeNotFoundExecption e1) {
			logger.error(e1);
		}
		if (volumeInfo != null) {
			logger.debug("found Volume: ----- >\n" + volumeInfo.toString());
			try {
				volumesQueue.put(volumeInfo);
			} catch (InterruptedException e) {
				logger.error(e.getMessage());
			}
		}
	}



}