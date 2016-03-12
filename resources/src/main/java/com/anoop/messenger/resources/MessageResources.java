package com.anoop.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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

}
