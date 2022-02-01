package com.laboratorio.users.models.errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class UserError {
    private String message;
    private String description;
    private LocalDateTime thrownAt;

}
