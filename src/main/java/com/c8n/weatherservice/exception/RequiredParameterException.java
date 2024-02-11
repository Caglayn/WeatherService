package com.c8n.weatherservice.exception;

import lombok.Getter;

@Getter
public class RequiredParameterException extends RuntimeException{
    private final int statusCode;

    public RequiredParameterException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
