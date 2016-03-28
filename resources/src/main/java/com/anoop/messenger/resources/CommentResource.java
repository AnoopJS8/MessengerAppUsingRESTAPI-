package com.anoop.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/") //Note: The class level @Path annotation is optional for sub resources.
public class CommentResource {
	
	@GET
	public String test(){
		return "new sub resource";
	}

}
