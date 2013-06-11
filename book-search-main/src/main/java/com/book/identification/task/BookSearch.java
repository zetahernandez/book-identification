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
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.book.identification.FileFilter;
import com.book.identification.BookFile;
import com.book.identification.FileType;
import com.book.identification.dao.DAOFactory;
import com.book.identification.model.Volume;
import com.book.identification.task.base.Worker;
import com.book.identification.util.FileHashUtil;

public class BookSearch extends Thread {

	final static Logger logger = LogManager.getLogger(BookSearch.class);

	public final BlockingQueue<BookFile> fileQueue;
	public ConcurrentSkipListSet<File> indexedFiles = new ConcurrentSkipListSet<File>();
	private final File root;
	private Worker nextWorker;

	public BookSearch(BlockingQueue<BookFile> fileQueue,
			final FileFilter fileFilter, File root,
			Worker producerConsumer) {
		super("BookSearch");
		this.fileQueue = fileQueue;
		this.root = root;
		this.nextWorker = producerConsumer;
	}

	@Override
	public void run() {

		List<Volume> volumes = DAOFactory.getInstance().getVolumeDAO()
				.findAll();

		for (Volume volume : volumes) {
			indexedFiles.add(new File(volume.getPath()));
		}
		Collection<File> entries = FileUtils.listFiles(root, new SuffixFileFilter(new String[]{".pdf",".chm" }),TrueFileFilter.INSTANCE);
		for (File fileToProcces : entries) {
			String fileSHA1 = FileHashUtil.getFileSHA1(fileToProcces);
			logger.info("Accepted file -> " + fileToProcces.getName() + " Hash -> " + fileSHA1);
			FileType fileType = FileType.valueOf(StringUtils.upperCase(FilenameUtils.getExtension(fileToProcces.getName())));
			try {
				fileQueue.put(new BookFile(fileToProcces, fileSHA1, fileType));
			} catch (InterruptedException e) {
				logger.info(e);
			}
		}
		nextWorker.notifyEndProducers();
	}

}
