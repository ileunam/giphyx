package com.laboratorio.users.models;

import lombok.*;

import java.util.List;

@Data
@Builder
public class User {
    private String id;
    private String username;
    private String password;
    private boolean enabled;
    private String email;
    private List<String> roles;
}
