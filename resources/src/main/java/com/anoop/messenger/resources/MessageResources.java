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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.anoop.messenger.resources.model.Message;
import com.anoop.messenger.resources.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON) //Instead add in front of class rather than adding for every method
public class MessageResources {
	
	MessageService messageService=new MessageService();
	
	@GET
	//@Produces(MediaType.APPLICATION_JSON) //It tells the jersey what content to sent back of the resource. 
	public List<Message> getMessages(@QueryParam("year") int year,@QueryParam("start") int start
															,@QueryParam("size") int size){
		if(year>0){//if we dont pass anything in year it will come as 0
			return messageService.getAllMessagesForYear(year);
		}
		if(start>0 || size >0){
			return messageService.getAllMessagesPaginated(start, size);
		}
		return messageService.getAllMessages();
	}
	@POST  //POST API used for creating a message
	//@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)//MediaType.APPLICATION_JSON not working for newer postman version so change to text
	public Message addMessage(Message message){
		return messageService.addMessage(message);
		
	}
	
	@PUT //PUT API used for updating a message
	@Path("/{messageId}")
	//@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long id,Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	//@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long id){
		messageService.removeMessage(id);
	}
	
	@GET
	@Path("/{messageId}")//For getting a particular requested method.
	//@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") Long id){ //Jersey automatically changes it to Long from the String param
		return messageService.getMessage(id);
	}
}
