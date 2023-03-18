package com.rejola.BProject.master.acl;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;

public interface AclService {
    ResponseEntity<JsonNode> getRole();

}
