package com.rejola.BProject.master.registration;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.JsonNode;

public interface RegistrationService {

	ResponseEntity<JsonNode> createRegistration(RegistrationRequest registration);

}
