package com.pws.example.exception;

public class ExampleException extends Exception {

    private static final long serialVersionUID = 1L;

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public ExampleException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
