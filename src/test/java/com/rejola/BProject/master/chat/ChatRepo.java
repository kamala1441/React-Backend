package com.rejola.BProject.master.chat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.JsonNode;

public interface ChatRepo extends JpaRepository<Chat, Long> {

	ResponseEntity<JsonNode> findBySenderAndRecipient(String sender, String recipient);
 

}
