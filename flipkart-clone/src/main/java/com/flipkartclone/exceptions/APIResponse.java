package com.flipkartclone.exceptions;

import org.springframework.http.HttpStatus;

public class APIResponse {

    private HttpStatus statusCode;
    private String message;

    public APIResponse() {

    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public APIResponse(HttpStatus statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
