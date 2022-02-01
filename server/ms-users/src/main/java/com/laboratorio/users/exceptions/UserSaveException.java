package com.laboratorio.users.exceptions;

public class UserSaveException extends RuntimeException {
    public UserSaveException(String message) {
        super(message);
    }

    public UserSaveException(String message, Throwable cause) {
        super(message, cause);
    }
}
