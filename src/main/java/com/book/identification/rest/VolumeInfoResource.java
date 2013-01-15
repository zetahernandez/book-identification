package com.book.identification.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.book.identification.dao.DAOFactory;
import com.book.identification.model.Volume;
import com.book.identification.model.VolumeInfo;
import com.book.identification.model.collections.Volumes;

@Path("volumesInfo/")
public class VolumeInfoResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VolumeInfo> volumeinfo() {
		return DAOFactory.getInstance().getVolumeInfoDAO().findAll();
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{entityId}")
	public Response volumeInfo(@PathParam("entityId") Long entityId) {
		VolumeInfo volumeInfo = DAOFactory.getInstance().getVolumeInfoDAO().findById(entityId, false);
		return  Response.ok(volumeInfo).build();
		
	}
}
