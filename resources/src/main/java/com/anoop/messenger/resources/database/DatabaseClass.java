package com.anoop.messenger.resources.database;

import java.util.HashMap;
import java.util.Map;

import com.anoop.messenger.resources.model.Message;
import com.anoop.messenger.resources.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<Long, Profile> profiles = new HashMap<>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<Long, Profile> getProfiles() {
		return profiles;
	}

}
