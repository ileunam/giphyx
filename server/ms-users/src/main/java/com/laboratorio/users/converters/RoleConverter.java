package com.laboratorio.users.converters;

import com.laboratorio.users.models.Role;
import com.laboratorio.users.models.documents.RoleDocument;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter implements Converter<Role, RoleDocument> {
    @Override
    public RoleDocument convert(Role role) {
        return RoleDocument.builder()
                .role(role.getRole())
                .roleUsers(role.getUsersRole())
                .build();
    }
}
