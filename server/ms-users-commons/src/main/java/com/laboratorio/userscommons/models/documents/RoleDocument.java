package com.laboratorio.userscommons.models.documents;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("role")
@Data
@Builder
public class RoleDocument {
    @Id
    private String id;
    @Indexed(unique = true)
    private String role;
    private List<String> roleUsers;
}
