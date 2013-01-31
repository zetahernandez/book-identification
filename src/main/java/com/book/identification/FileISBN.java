package com.book.identification;

import com.book.identification.task.base.ItemQueue;

public class FileISBN implements ItemQueue {
	private FilePDF file;
	private String isbn;
	

	public FileISBN(FilePDF file, String isbn) {
		super();
		this.file = file;
		this.isbn = isbn;
	}

	public FilePDF getFilePDF() {
		return file;
	}

	public String getIsbn() {
		return isbn;
	}

}
