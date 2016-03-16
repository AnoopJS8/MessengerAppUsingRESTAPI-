package com.anoop.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.anoop.messenger.resources.model.Message;
import com.anoop.messenger.resources.service.MessageService;

@Path("/messages")
public class MessageResources {
	
	MessageService messageService=new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) //It tells the jersey what content to sent back of the resource. 
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)//MediaType.APPLICATION_JSON not working for newer postman version so change to text
	public Message addMessage(Message message){
		return messageService.addMessage(message);
		
	}
	
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") Long id){ //Jersey automatically changes it to Long from the String param
		return messageService.getMessage(id);
	}
}
