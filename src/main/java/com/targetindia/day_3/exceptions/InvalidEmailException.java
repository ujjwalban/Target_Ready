package com.targetindia.day_3.exceptions;

public class InvalidEmailException extends RuntimeException{
    public InvalidEmailException() {
    }

    public InvalidEmailException(String message) {
        super(message);
    }

    public InvalidEmailException(Throwable cause) {
        super(cause);
    }
}
