package com.targetindia.utils.exceptions;

public class InvalidYearException extends Exception{
    public InvalidYearException() {
    }

    public InvalidYearException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidYearException(Throwable cause) {
        super(cause);
    }

    public InvalidYearException(String s) {
    }
}
