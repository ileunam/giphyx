package com.laboratorio.userscommons.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Role {
    private String id;
    private String role;
    private List<String> usersRole;
}
