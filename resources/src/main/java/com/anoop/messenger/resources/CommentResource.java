package com.anoop.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.anoop.messenger.resources.model.Comment;
import com.anoop.messenger.resources.service.CommentService;

@Path("/") // Note: The class level @Path annotation is optional for sub
			// resources.
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

	private CommentService commentService = new CommentService();

	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
		return commentService.getAllComments(messageId);
	}

	@POST
	public Comment addMessage(@PathParam("messageId") long messageId, Comment comment) {
		return commentService.addComment(messageId, comment);
	}

	@PUT
	@Path("/{commentId}")
	public Comment updateMessage(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId,
			Comment comment) {
		comment.setId(commentId);
		return commentService.updateComment(messageId, comment);
	}

	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId){
		commentService.removeComment(messageId, commentId);
	}

	@GET
	@Path("/{}")
	public Comment getComment(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId){
		
		return commentService.getComment(messageId, commentId);
	}
}



/*
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
*In the sub resource we can access the path of the parent resource.By the following way:
@GET
@Path("/{commentId}")
public String test1(@PathParam("messageId") long mesgId,@PathParam("commentId") long comntId){
	return "Id working "+mesgId+" "+comntId;
}
*/
