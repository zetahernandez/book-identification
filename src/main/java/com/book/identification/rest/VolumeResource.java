package com.book.identification.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.criterion.Restrictions;
import org.hibernate.search.FullTextSession;

import com.book.identification.dao.DAOFactory;
import com.book.identification.model.Volume;
import com.book.identification.model.collections.Volumes;

@Path("volumes/")
public class VolumeResource {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response volumes(@QueryParam("categoryId") Long categoryId, @QueryParam("page") Integer page) {
		Volumes volumes = new Volumes();
		if(categoryId!=null){
			volumes.setVolumes(DAOFactory.getInstance().getVolumeDAO().volumesWithCategory(categoryId))  ;
		}else{
                    if ( page == null ){
                        volumes.setVolumes(DAOFactory.getInstance().getVolumeDAO().findAll());
                    }else{
                        volumes.setVolumes( DAOFactory.getInstance().getVolumeDAO().retrievesVolumesPerPage(page) );
                    }	
                    
		}
		return Response.ok(volumes).build();
        
    }

	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("{categoryID}")
//	public Response findVolumesBySelectedCategory(@PathParam("categoryID") Long categoryId) {
//		FullTextSession fts =
//				org.hibernate.search.Search.getFullTextSession( DAOFactory.getInstance().getVolumeDAO().getSession());
//		return null;
//	}
}
