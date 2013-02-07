package com.book.identification;

import java.io.File;

import com.book.identification.task.base.ItemQueue;

public class FilePDF implements ItemQueue {

	private File file;
	private String hash;
	
	public FilePDF(File file, String hash) {
		this.file  = file; 
		this.hash = hash;
	}
	
	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}


	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}

}
