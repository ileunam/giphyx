package com.laboratorio.users.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
public class UserException {
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;

}
