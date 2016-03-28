package com.anoop.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/") //Note: The class level @Path annotation is optional for sub resources.
public class CommentResource {
	
	@GET
	public String test(){
		return "new sub resource";
	}
	/*
	@GET
	@Path("/{commentId}")
	public String test1(@PathParam("commentId") long id){
		return "Id working "+id;
	}
	*/ //In the sub resource we can access the path of the parent resource.By the following way:
	@GET
	@Path("/{commentId}")
	public String test1(@PathParam("messageId") long mesgId,@PathParam("commentId") long comntId){
		return "Id working "+mesgId+" "+comntId;
	}

}
