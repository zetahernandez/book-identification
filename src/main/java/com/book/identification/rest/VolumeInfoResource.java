package com.book.identification.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.book.identification.dao.DAOFactory;
import com.book.identification.model.VolumeInfo;

@Path("volumeinfo/")
public class VolumeInfoResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VolumeInfo> volumeinfo() {
		return DAOFactory.getInstance().getVolumeInfoDAO().findAll();
	}
}
