package com.anoop.messenger.resources.service;

import java.util.ArrayList;
import java.util.List;

import com.anoop.messenger.resources.model.Message;

public class MessageService {
	
	public List<Message> getAllMessages(){
		Message m1=new Message(1L,"Hello World","Anoop");
		Message m2=new Message(2L,"Hello EveryOne","Anoop");
		List<Message> list=new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;
	}
}
