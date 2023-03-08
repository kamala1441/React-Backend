package com.rejola.BProject.master.registration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

@RequestMapping("/registration")
@RestController
public class RegistrationController {

	private final RegistrationService registrationService;

	public RegistrationController(RegistrationService registrationService) {
		super();
		this.registrationService = registrationService;
	}

	@PostMapping()
	private ResponseEntity<JsonNode> createRegistration(@RequestBody RegistrationRequest registration) {
		return registrationService.createRegistration(registration);
	}
}