package com.rejola.BProject.master.user;

import com.fasterxml.jackson.databind.JsonNode;
import com.rejola.BProject.exception.BadRequestException;
import com.rejola.BProject.exception.UserNotFoundException;
import com.rejola.BProject.mapper.ModelMapper;
import com.rejola.BProject.shared.ResultBuilder;
import com.rejola.BProject.shared.Status;
import com.rejola.BProject.utils.Json;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;

	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ResponseEntity<JsonNode> getAllUser() {
		return ResponseEntity
				.ok(ResultBuilder.successJson(userRepository.findAll().stream().map(modelMapper::mapTo), "userList"));
	}

	@Override
	public ResponseEntity<JsonNode> createUser(UserRequest request) {
		Users user = validateUserAndGetData(request);
		user.setStatus(Status.ACTIVE);
		userRepository.save(user);
		return ResponseEntity.ok(ResultBuilder.successJson("User created successfully"));
	}

	@Override
	public ResponseEntity<JsonNode> delete(String id) {
		try {
			userRepository.delete(userRepository.findById(UUID.fromString(id))
					.orElseThrow(() -> new UserNotFoundException("User not found")));
			return ResponseEntity.ok(ResultBuilder.successJson("User deleted successfully"));
		} catch (Exception e) {
			throw new BadRequestException("User not found");
		}
	}

	private Users validateUserAndGetData(UserRequest request) {

		boolean isUpdate = request.getId() != null;
		Users user = modelMapper.map(request);
		if (isUpdate) {
			user.setId(UUID.fromString(request.getId()));
		}

		userRepository.findByEmpId(request.getEmpId()).ifPresent(data -> {
			if (isUpdate && (data.getEmpId().equals(request.getEmpId())
					&& !data.getId().equals(UUID.fromString(request.getId())))) {
				throw new BadRequestException("Employee Id already exists");
			} else if (!isUpdate) {
				throw new BadRequestException("Employee Id already exists");
			}
		});

		userRepository.findByEmail(request.getEmail()).ifPresent(data -> {
			if (isUpdate && !data.getEmail().equals(request.getEmail())) {
				throw new BadRequestException("Email already exists");
			} else if (!isUpdate) {
				throw new UserNotFoundException("Email already exists");
			}
		});

		System.out.println("request " + Json.toJson(request));
		System.out.println("user " + Json.toJson(user));
		return user;
	}

}
