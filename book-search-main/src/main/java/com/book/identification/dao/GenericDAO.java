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
