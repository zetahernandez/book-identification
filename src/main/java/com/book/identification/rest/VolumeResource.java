package com.book.identification.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.book.identification.dao.DAOFactory;
import com.book.identification.model.Volume;

@Path("volumes/")
public class VolumeResource {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Volume> volumes() {
        return DAOFactory.getInstance().getVolumeDAO().findAll();
    }
}
