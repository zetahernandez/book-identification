package com.book.identification.dao;

import com.book.identification.model.Volume;
import java.util.List;

public interface VolumeDAO extends GenericDAO<Volume,Long> {

	List<Volume> volumesWithCategory(Long categoryId);
        List<Volume> retrievesVolumesPerPage( int page );
}
