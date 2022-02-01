package com.laboratorio.users.exceptions;

import com.laboratorio.users.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException e) {
        UserException userException = new UserException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(userException, userException.getHttpStatus());
    }

    @ExceptionHandler(value = {UserSaveException.class})
    public ResponseEntity<Object> handleUserSaveException(UserSaveException e) {
        UserException userException = new UserException(
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(userException, userException.getHttpStatus());
    }
}
