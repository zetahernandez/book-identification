package com.book.identification;

import java.io.File;

import com.book.identification.task.base.ItemQueue;

public class FileISBN implements ItemQueue {
	private File file;
	private String isbn;

	public FileISBN(File file, String isbn) {
		super();
		this.file = file;
		this.isbn = isbn;
	}

	public File getFile() {
		return file;
	}

	public String getIsbn() {
		return isbn;
	}

}
