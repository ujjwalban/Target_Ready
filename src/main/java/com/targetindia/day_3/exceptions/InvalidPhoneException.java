package com.targetindia.day_3.exceptions;

public class InvalidPhoneException extends RuntimeException{
    public InvalidPhoneException() {
    }

    public InvalidPhoneException(String message) {
        super(message);
    }

    public InvalidPhoneException(Throwable cause) {
        super(cause);
    }
}
