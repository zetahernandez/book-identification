package com.book.identification.volumes;

import com.book.identification.BookFile;
import com.book.identification.model.Volume;

public interface RetrieveVolumeInfo {

	Volume retriveVolumeInfo(BookFile fileIsbn);
}
