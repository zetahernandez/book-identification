package com.book.identification.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.book.identification.dao.DAOFactory;
import com.book.identification.model.Category;

@Path("categories/")
public class CategoryResource {

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response categories() {
		List<Category> findAll = DAOFactory.getInstance().getCategoryDAO().findAll();
        return Response.ok(findAll).build();
    }
}
