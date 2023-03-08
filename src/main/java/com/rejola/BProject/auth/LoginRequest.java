package com.rejola.BProject.auth;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

public class LoginRequest {
    @ApiParam("Employee Id")
    @ApiModelProperty(notes = "Employee Id", example = "EMP001", dataType = "String", required = true, position = 0)
    private String empId;
    @ApiParam("password")
    @ApiModelProperty(notes = "Employee password", example = "changeme", dataType = "String", required = true, position = 1)
    private String password;
    @ApiModelProperty(hidden = true)
    private String email;



    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
