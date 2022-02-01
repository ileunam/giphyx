package com.laboratorio.users.converters;

import com.laboratorio.users.models.User;
import com.laboratorio.users.models.documents.UserDocument;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class UserDocumentConverter implements Converter<UserDocument, User> {
    @Override
    public User convert(UserDocument userDocument) {
        return User.builder()
                .id(userDocument.getId())
                .username(userDocument.getUsername())
                .password(userDocument.getPassword())
                .enabled(userDocument.isEnabled())
                .email(userDocument.getEmail())
                .roles(userDocument.getRoles())
                .build();
    }

    public List<User> convert(List<UserDocument> userDocuments){
        List<User> users = new ArrayList<>();
        userDocuments.forEach(user -> users.add(convert(user)));
        return users;
    }
}
