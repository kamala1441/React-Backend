package com.rejola.BProject.mapper;

import com.rejola.BProject.auth.LoginDTO;

import com.rejola.BProject.master.acl.RoleDto;
import com.rejola.BProject.master.registration.Registration;
import com.rejola.BProject.master.registration.RegistrationRequest;
import com.rejola.BProject.master.user.*;
import com.rejola.BProject.models.Role;
import com.rejola. BProject.security.UserRoleMap;


import java.util.List;
import java.util.UUID;

public interface ModelMapper {

    LoginDTO map(Users user);

    RoleDto map(UserRoleMap userRoleMap);

   
    UUID map(String id);

    
    Users map(UserRequest request);

    Users map(UUID value);

    UserDto mapTo(Users user);


    RoleDto map(Role role);

	Registration map(RegistrationRequest registration);

  



}

