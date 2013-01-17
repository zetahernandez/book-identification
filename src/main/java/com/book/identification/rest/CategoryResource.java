package com.book.identification.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
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
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{categoryId}")
    public Response Category() {
		List<Category> findAll = DAOFactory.getInstance().getCategoryDAO().findByCriteria(Restrictions.isNull("parent"));
		Categories categories = new Categories();
		categories.setCategories(findAll);
		return Response.ok(categories).build();
    }
}
