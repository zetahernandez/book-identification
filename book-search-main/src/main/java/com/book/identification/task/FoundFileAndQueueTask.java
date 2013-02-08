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

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.book.identification.FilePDF;
import com.book.identification.util.FileHashUtil;


public class FoundFileAndQueueTask extends Thread {
	final static Logger logger = LogManager.getLogger(FoundFileAndQueueTask.class);
	/**
	 * 
	 */
	private final BookSearch bookSearch;
	private final File file;

	public FoundFileAndQueueTask(BookSearch bookSearch, File file) {
		this.bookSearch = bookSearch;
		this.file = file;
	}

	public void run() {
		if (Thread.currentThread().isInterrupted())
			return;

		File[] entries = file.listFiles(this.bookSearch.fileFilter);

		if (entries != null) {
			for (File entry : entries)
				if (entry.isDirectory()) {
					FoundFileAndQueueTask foundFileAndQueueTask = new FoundFileAndQueueTask(bookSearch, entry);
					foundFileAndQueueTask.start();
					try {
						foundFileAndQueueTask.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else if (entry != null && !this.bookSearch.indexedFiles.contains(entry)) {
					this.bookSearch.indexedFiles.add(entry);
					try {
						//Hashing
						String fileSHA1 = FileHashUtil.getFileSHA1(entry);
						logger.info("Accepted file -> " + entry.getName() + " Hash -> " + fileSHA1);
						this.bookSearch.fileQueue.put(new FilePDF(entry,fileSHA1));
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					} catch (Throwable e) {
						Thread.currentThread().interrupt();
					}
				}
		}
	}
}