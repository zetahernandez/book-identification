package com.book.identification;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.book.identification.util.FileHashUtil;

public class BookIdentification {

	private File file;

	public BookIdentification(String path) {
			this.file = new File( path);
	}
	
	public String identificate() throws InterruptedException {
		
		BookFile filePdf = new BookFile(file,  FileHashUtil.getFileSHA1(file), FileType.PDF);
		BlockingQueue<BookFile> arrayBlockingQueue = new ArrayBlockingQueue<BookFile>(1);
		BookFile take = arrayBlockingQueue.take();
		return take.getIsbn();
	}
}
