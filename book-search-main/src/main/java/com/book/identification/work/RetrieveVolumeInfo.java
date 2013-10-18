package com.book.identification.work;

import java.io.IOException;

import com.book.identification.BookFile;
import com.book.identification.model.Volume;
import com.book.identification.work.exceptions.VolumeNotFoundExecption;

public interface RetrieveVolumeInfo {

	Volume retriveVolumeInfo(BookFile fileIsbn) throws IOException, VolumeNotFoundExecption;
}
