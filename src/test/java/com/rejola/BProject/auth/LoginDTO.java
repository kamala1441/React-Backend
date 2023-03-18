package com.rejola.BProject.auth;

import com.rejola.BProject.master.acl.RoleDto;


import java.util.List;
import java.util.UUID;

public class LoginDTO {
    private UUID id;
    private String empId;
    List<RoleDto> roles;
    private String token;

    public List<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }
}
