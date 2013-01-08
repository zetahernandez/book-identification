package com.book.identification.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

public interface GenericDAO<T, ID extends Serializable>{

	T findById(ID id, boolean lock);
	List<T> findAll();
	List<T> findByExample(T exampleInstance, String... excludeProperty);
	T makePersistent(T entity);
	void makeTransient(T entity);
	void flush();
	void clear();
	List<T> findByCriteria(Criterion... criterion);
	Session getSession();
}
