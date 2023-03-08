package com.rejola.BProject.master.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.rejola.BProject.master.registration.RegistrationRequest;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;


    @PostMapping()
	private ResponseEntity<JsonNode> createChat(@RequestBody Chat chat) {
		return chatService.createChat(chat);
	}

    @GetMapping
    public ResponseEntity<JsonNode> getChats(@RequestParam String sender, @RequestParam String recipient) {
        return chatService.getChats(sender, recipient);
    }
}