package com.book.identification.dao;

import com.book.identification.model.Category;

public interface CategoryDAO extends GenericDAO<Category, Long> {

	Category retrieveCategory(String categoryName, String... parentsCategoryName);
}
