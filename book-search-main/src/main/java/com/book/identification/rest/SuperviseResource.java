package com.book.identification.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.atmosphere.annotation.Broadcast;
import org.atmosphere.annotation.Suspend;

@Path("supervise/chat/")
public class SuperviseResource {
	
	@GET
	@Suspend(contentType=MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response chat() {

//		String path;

		return Response.ok("").build();
	}

	/**
	 * Broadcast the received message object to all suspended response. Do not
	 * write back the message to the calling connection.
	 * 
	 * @param message
	 * @return a {@link Response}
	 */
	@Broadcast(writeEntity = false)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public Message broadcast(Message message) {
			return  new Message("asdasd");
	}
}
