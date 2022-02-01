package com.laboratorio.users.models.documents;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document("user")
@Data
@Builder
public class UserDocument {
    @Id
    private String id;
    @Indexed(unique = true)
    private String username;
    private String password;
    private boolean enabled;
    @Indexed(unique = true)
    private String email;
    private List<String> roles;

}
