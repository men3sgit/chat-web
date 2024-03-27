package com.nlu.fit.chat.exceptions;

public class ApiRequestException extends RuntimeException {
    public ApiRequestException() {
    }

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiRequestException(Throwable cause) {
        super(cause);
    }
}
