package com.rejola.BProject.mapper;

import com.rejola.BProject.auth.LoginDTO;

import com.rejola.BProject.master.acl.RoleDto;
import com.rejola.BProject.master.registration.Registration;
import com.rejola.BProject.master.registration.RegistrationDto;
import com.rejola.BProject.master.registration.RegistrationRequest;
import com.rejola.BProject.master.user.SubUserDto;
import com.rejola.BProject.master.user.UserDto;
import com.rejola.BProject.master.user.UserRequest;
import com.rejola.BProject.master.user.Users;
import com.rejola.BProject.models.Role;

import com.rejola.BProject.master.user.*;

import com.rejola.BProject.security.UserRoleMap;
import com.rejola.BProject.shared.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class ModelMapperImpls implements ModelMapper {

	@Override
	public LoginDTO map(Users user) {
		if (user == null) {
			return null;
		}

		LoginDTO loginDTO = new LoginDTO();

		loginDTO.setRoles(userRoleMapListToRoleDTOList(user.getRoles()));
		loginDTO.setId(user.getId());
		loginDTO.setEmpId(user.getEmpId());

		return loginDTO;
	}

	@Override
	public RoleDto map(UserRoleMap userRoleMap) {
		if (userRoleMap == null) {
			return null;
		}

		RoleDto roleDto = new RoleDto();

		roleDto.setRole(userRoleMap.getRole());

		return roleDto;
	}

	@Override
	public UUID map(String id) {
		if (id == null) {
			return null;
		}

		long mostSigBits = 0L;
		long leastSigBits = 0L;

		return new UUID(mostSigBits, leastSigBits);
	}

	@Override
	public Users map(UserRequest request) {
		if (request == null) {
			return null;
		}

		Users users = new Users();

		users.setId(map(request.getId()));
		users.setEmpId(request.getEmpId());
		users.setName(request.getName());
		users.setEmail(request.getEmail());
		users.setPassword(request.getPassword());

		return users;
	}

	@Override
	public Users map(UUID value) {
		if (value == null) {
			return null;
		}

		return new Users();
	}

	@Override
	public UserDto mapTo(Users user) {
		if (user == null) {
			return null;
		}

		UserDto userDto = new UserDto();

		userDto.setId(UUIDToString(user.getId()));
		userDto.setEmpId(user.getEmpId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());

		userDto.setStatus(user.getStatus().toString());

		userDto.setPhoneNo(user.getPhoneNo());

		return userDto;
	}

	@Override
	public RoleDto map(Role role) {
		if (role == null) {
			return null;
		}

		RoleDto roleDto = new RoleDto();

		roleDto.setRole(role.getRoleId());
		roleDto.setDescription(role.getDescription());

		return roleDto;
	}

	protected List<RoleDto> userRoleMapListToRoleDTOList(List<UserRoleMap> list) {
		if (list == null) {
			return null;
		}

		List<RoleDto> list1 = new ArrayList<RoleDto>(list.size());
		for (UserRoleMap userRoleMap : list) {
			list1.add(map(userRoleMap));
		}

		return list1;
	}

	private String UUIDToString(UUID id) {
		if (id == null) {
			return null;
		}
		return id.toString();
	}

	private SubUserDto userToSubUserDto(Users user) {
		if (user == null) {
			return null;
		}

		SubUserDto subUserDto = new SubUserDto();

		subUserDto.setId(user.getId());
		subUserDto.setEmpId(user.getEmpId());
		subUserDto.setName(user.getName());
		subUserDto.setEmail(user.getEmail());

		return subUserDto;
	}

	@Override
	public Registration map(RegistrationRequest registration) {
		if (registration == null) {
			return null;
		}

		Registration registrationDto = new Registration();

		registrationDto.setId(registration.getId());
		registrationDto.setFirstName(registration.getFirstName());
		registrationDto.setLastName(registration.getLastName());
		registrationDto.setName(registration.getName());
		registrationDto.setEmail(registration.getEmail());
		registrationDto.setDOB(registration.getDOB());
		registrationDto.setPhoneNo(registration.getPhoneNo());

		return registrationDto;
	}
}