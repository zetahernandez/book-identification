package com.book.identification.dao;

import java.util.List;

import com.book.identification.model.Volume;

public interface VolumeDAO extends GenericDAO<Volume,Long> {

	List<Volume> volumesWithCategory(Long categoryId);
}
