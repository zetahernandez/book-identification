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

package com.book.identification.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.criterion.Restrictions;

import com.book.identification.dao.DAOFactory;
import com.book.identification.model.Category;
import com.book.identification.model.collections.Categories;

@Path("categories/")
public class CategoryResource {

	
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response parentCategories() {
		List<Category> findAll = DAOFactory.getInstance().getCategoryDAO().findByCriteria(Restrictions.isNull("parent"));
		Categories categories = new Categories();
		categories.setCategories(findAll);
		return Response.ok(categories).build();
    }
	
//	@GET
//    @Produces(MediaType.APPLICATION_JSON)
//	@Path("{parentId}")
//    public Response childsCategory(@QueryParam("parentId") Long parentId) {
//		List<Category> findAll = DAOFactory.getInstance().getCategoryDAO().childCategories(parentId);
//		Categories categories = new Categories();
//		categories.setCategories(findAll);
//		return Response.ok(categories).build();
//    }
}
