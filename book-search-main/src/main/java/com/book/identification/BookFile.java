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

package com.book.identification;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

import com.book.identification.task.base.ItemQueue;

public class BookFile implements ItemQueue {

	private File file;
	private String hash;
	private FileType fileType;
	private String isbn;
	
	
	public BookFile(File file, String hash, FileType fileType) {
		super();
		this.file = file;
		this.hash = hash;
		this.fileType = fileType;
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

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public boolean hasISBN() {
		return StringUtils.isNotBlank(isbn);
	}

}
