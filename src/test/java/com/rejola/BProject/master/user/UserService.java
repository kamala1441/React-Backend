package com.rejola.BProject.master.user;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<JsonNode> getAllUser();

    ResponseEntity<JsonNode> createUser(UserRequest request);

    ResponseEntity<JsonNode> delete(String id);
}
