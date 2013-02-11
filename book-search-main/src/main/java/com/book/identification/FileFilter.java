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
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

public class FileFilter implements java.io.FileFilter {

	private final EnumSet<FileType> fileTypes;

	
	public FileFilter(FileType ...fileType) {
		super();
		this.fileTypes = EnumSet.copyOf(Arrays.asList(fileType));
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
