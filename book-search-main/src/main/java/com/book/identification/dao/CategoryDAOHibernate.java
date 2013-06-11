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

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;

import com.book.identification.model.Category;

public class CategoryDAOHibernate extends GenericHibernateDAO<Category, Long>
		implements CategoryDAO {

	public Category retrieveCategory(String categoryName,
			String... parentCategoryName) {
		Query query;
		if(parentCategoryName == null){
			query = getSession().createQuery("Select c From Category c Where c.category = :categoryName AND c.parent is null")
			.setParameter("categoryName", categoryName);
		}else{
			StringBuilder stringQuery  = new StringBuilder();
			stringQuery.append("Select c From Category c Where c.category = :categoryName");
			for (int i = 0; i < parentCategoryName.length; i++) {
				stringQuery.append(" AND c."+StringUtils.repeat("parent.", i + 1)  +"category = :parentCategoryName" + i);
			}
			stringQuery.append(" AND c.parent"+StringUtils.repeat(".parent", parentCategoryName.length)  +" is null");
			
			query = getSession().createQuery(stringQuery.toString()).setParameter("categoryName", categoryName);
			for (int i = parentCategoryName.length ; i > 0; i--) {
				query = query.setParameter("parentCategoryName" + (parentCategoryName.length - i), StringUtils.trim(parentCategoryName[i-1]));
			}
		}
		return (Category) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Long> childCategories(Long parentId) {
		Query query;
		
			query = getSession().createQuery("Select c.entityId From Category c LEFT OUTER JOIN c.parent cp WHERE c.id = :categoryId OR cp.id = :categoryId")
			.setParameter("categoryId", parentId);
			return (List<Long>) query.list();
		
	}

}
