package com.rejola.BProject.master.registration;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.rejola.BProject.exception.AlreadyExistException;
import com.rejola.BProject.exception.BadRequestException;
import com.rejola.BProject.mapper.ModelMapper;
import com.rejola.BProject.shared.Message;
import com.rejola.BProject.shared.ResultBuilder;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	private static final Logger logger = LogManager.getLogger(RegistrationServiceImpl.class);
	public final RegistrationRepo registrationRepo;
	private final ModelMapper modelMapper;

	public RegistrationServiceImpl(RegistrationRepo registrationRepo, ModelMapper modelMapper) {
		super();
		this.registrationRepo = registrationRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public ResponseEntity<JsonNode> createRegistration(RegistrationRequest registration) {
		registrationRepo.findById(registration.getId()).ifPresent(newRegistration -> {
			if (registration.getId() != null) {
				if (newRegistration.getId().equals(registration.getId())) {
					throw new BadRequestException("Id already exist");
				}
			} else {
				throw new BadRequestException("Id already exist");
			}
		});
		try {
			Registration newRegistration = modelMapper.map(registration);
			registrationRepo.save(newRegistration);
			return ResponseEntity.ok(ResultBuilder.successJson("Registration created"));
		} catch (Exception e) {
			throw new BadRequestException("Failed to create registration");
		}
	}
}