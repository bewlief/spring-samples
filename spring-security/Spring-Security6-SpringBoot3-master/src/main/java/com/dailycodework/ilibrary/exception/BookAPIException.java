package com.dailycodework.ilibrary.exception;

import org.springframework.http.HttpStatus;

public class BookAPIException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public BookAPIException(String message, HttpStatus status) {
        this.status = status;
        this.message = message;
    }

    public BookAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
