package com.book.identification;

import java.io.File;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

public class FileFilter implements java.io.FileFilter {

	private final EnumSet<FileType> fileTypes;

	
	public FileFilter(FileType ...fileType) {
		super();
		this.fileTypes =EnumSet.copyOf(Arrays.asList(fileType));
	}


	public synchronized boolean accept(File file){
		
		Iterator<FileType> iterator = fileTypes.iterator();
		boolean result = false;
		while(iterator.hasNext()){
			if(file.isFile()){
				String extension = FilenameUtils.getExtension(file.getName());
				if(StringUtils.equalsIgnoreCase(iterator.next().toString(), extension)){
					result = true;
					break;
				}
			}else{
				result = true;
				break;
			}
		}
		return result;
	}

	
	
}
