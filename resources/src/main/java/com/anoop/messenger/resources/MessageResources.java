package com.anoop.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/messages")
public class MessageResources {
	@GET
	@Produces(MediaType.TEXT_PLAIN) //It tells the jersey what content to sent back of the resource. 
	public String getMessages(){
		return "Hello World";
	}

}
