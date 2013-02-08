package com.book.identification.rest;

import java.io.File;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.book.identification.dao.DAOFactory;
import com.book.identification.model.Volume;
import com.book.identification.model.VolumeInfo;

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
	
	@GET
	@Path("open/{volumeInfoId}")
	@Produces({"application/pdf"})
	public Response  openPDF(@PathParam("volumeInfoId") Long volumeInfoId) {
		final Volume volume = (Volume) DAOFactory.getInstance().getVolumeInfoDAO().getSession().createQuery("From Volume v where v.volumeInfo.entityId = :volumeInfoId").setParameter("volumeInfoId",volumeInfoId).uniqueResult();
		File file = new File(volume.getPath());
		ResponseBuilder response = Response.ok((Object) file);
		return response.build();
	}
}
