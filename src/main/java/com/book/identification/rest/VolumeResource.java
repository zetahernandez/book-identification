package com.book.identification.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.book.identification.dao.DAOFactory;
import com.book.identification.model.Volume;
import com.book.identification.model.collections.Volumes;

@Path("volumes/")
public class VolumeResource {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response volumes() {
		
		Volumes volumes = new Volumes();
		volumes.setVolumes(DAOFactory.getInstance().getVolumeDAO().findAll());
		return Response.ok(volumes).build();
        
    }

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{entityId}")
	public Response volume(@PathParam("entityId") Long entityId) {
		Volume volume = DAOFactory.getInstance().getVolumeDAO().findById(entityId, false);
		return  Response.ok(volume).build();
		
	}
}
