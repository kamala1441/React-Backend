package com.rejola.BProject.auth;

import io.swagger.annotations.ApiModelProperty;


public class ResetPasswordRequest {
    @ApiModelProperty(notes = "New password", example = "changme", dataType = "String", required = true, position = 0)
    private String password;
    @ApiModelProperty(notes = "Token", required = true, position = 1)
    private String t;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }
}
