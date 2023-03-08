package com.rejola.BProject.master.chat;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.rejola.BProject.mapper.ModelMapper;
import com.rejola.BProject.master.registration.RegistrationRepo;
import com.rejola.BProject.master.registration.RegistrationServiceImpl;
import com.rejola.BProject.shared.ResultBuilder;

@Service
public class ChatServiceImpl implements ChatService{
	private static final Logger logger = LogManager.getLogger(RegistrationServiceImpl.class);
	public final ChatRepo chatRepo;
	private final ModelMapper modelMapper;
	
	public ChatServiceImpl(ChatRepo chatRepo, ModelMapper modelMapper) {
		super();
		this.chatRepo = chatRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public ResponseEntity<JsonNode> createChat(Chat chat) {
		chat.setTimestamp(LocalDateTime.now());
        chatRepo.save(chat);
        return ResponseEntity.ok(ResultBuilder.successJson("Chat created"));
    }

	@Override
	public ResponseEntity<JsonNode> getChats(String sender, String recipient) {
		   return chatRepo.findBySenderAndRecipient(sender, recipient);
    }

}
