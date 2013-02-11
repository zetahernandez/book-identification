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

import java.io.File;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.book.identification.FileType;
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
	@Produces({"application/pdf",MediaType.TEXT_PLAIN})
	public Response  openPDF(@PathParam("volumeInfoId") Long volumeInfoId) {
		final Volume volume = (Volume) DAOFactory.getInstance().getVolumeInfoDAO().getSession().createQuery("From Volume v where v.volumeInfo.entityId = :volumeInfoId").setParameter("volumeInfoId",volumeInfoId).uniqueResult();
		File file = new File(volume.getPath());
		
		ResponseBuilder response = null;
		response = Response.ok((Object) file);
		if(volume.getFileType().equals(FileType.CHM)){
			response.header("Content-Type", MediaType.TEXT_PLAIN);
			response.header("Content-Disposition",	"attachment; filename=\""+ volume.getVolumeInfo().getTitle() + ".chm" + "\"");
		}
	
		
		return response.build();
	}
}
