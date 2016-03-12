package com.anoop.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
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
	@Produces(MediaType.APPLICATION_XML) //It tells the jersey what content to sent back of the resource. 
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("messageId") Long id){ //Jersey automatically changes it to Long from the String param
		return messageService.getMessage(id);
	}
}
