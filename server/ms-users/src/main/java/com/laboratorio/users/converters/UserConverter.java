package com.laboratorio.users.converters;

import com.laboratorio.users.models.User;
import com.laboratorio.users.models.documents.UserDocument;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class UserConverter implements Converter<User, UserDocument> {
    @Override
    public UserDocument convert(User user) {
        return UserDocument.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .enabled(user.isEnabled())
                .email(user.getEmail())
                .roles(user.getRoles())
                .build();
    }

    public UserDocument convert(List<User> userList) {
        List<UserDocument> userDocuments = new ArrayList<>();
        userList.forEach(user -> userDocuments.add(convert(user)));
        return (UserDocument) userDocuments;
    }
}
