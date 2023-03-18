package com.rejola.BProject.models;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @Column(name = "roleId", nullable = false)
    private String roleId;
    private String description;


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
