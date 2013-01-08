package com.book.identification;

import java.io.File;

import com.book.identification.task.base.ItemQueue;

public class FilePDF implements ItemQueue {

	private File file;
	public FilePDF(File file) {
		this.file  = file; 
		// TODO Auto-generated constructor stub
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}

}
