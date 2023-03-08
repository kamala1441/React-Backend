package com.rejola.BProject.shared;

import lombok.Data;
@Data
public class ApiResponse {
    private int statusCode;
    private Object message;
    private boolean status;

    public ApiResponse success(Object message){
        this.message = message;
        this.status = true;
        this.statusCode = 200;
        return this;
    }


    public ApiResponse error(String message, int statusCode){
        this.message = message;
        this.status = true;
        this.statusCode = statusCode;
        return this;
    }

    public ApiResponse error(String message){
        this.message = message;
        this.status = false;
        this.statusCode = 400;
        return this;
    }
}
