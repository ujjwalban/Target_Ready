package com.targetindia.utils.exceptions;

public class InvalidMonthException extends Exception{
    public InvalidMonthException() {
    }

    public InvalidMonthException(String message) {
        super(message);
    }

    public InvalidMonthException(String message, Throwable cause) {
        super(message, cause);
    }
}
