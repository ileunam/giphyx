package com.laboratorio.users.converters;

import com.laboratorio.users.models.Role;
import com.laboratorio.users.models.documents.RoleDocument;
import org.springframework.core.convert.converter.Converter;

public class RoleDocumentConverter implements Converter<RoleDocument, Role> {
    @Override
    public Role convert(RoleDocument roleDocument) {
        return Role.builder()
                .role(roleDocument.getRole())
                .usersRole(roleDocument.getRoleUsers())
                .build();
    }
}
