package com.rejola.BProject.master.chat;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.JsonNode;

public interface ChatService {

	ResponseEntity<JsonNode> createChat(Chat chat);

	ResponseEntity<JsonNode> getChats(String sender, String recipient);

}
