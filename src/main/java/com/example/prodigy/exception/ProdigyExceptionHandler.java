package com.example.prodigy.exception;

public class ProdigyExceptionHandler extends RuntimeException{

    private Integer errorCode;

    public ProdigyExceptionHandler(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public Integer getErrorCode() {
        return errorCode;
    }
}
