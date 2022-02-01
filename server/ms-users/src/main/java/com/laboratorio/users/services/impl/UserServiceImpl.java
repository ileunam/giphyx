package com.laboratorio.users.services.impl;

import com.laboratorio.users.converters.UserConverter;
import com.laboratorio.users.converters.UserDocumentConverter;
import com.laboratorio.users.models.User;
import com.laboratorio.users.models.dao.UserDAO;
import com.laboratorio.users.models.documents.UserDocument;
import com.laboratorio.users.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    UserDAO userDAO;
    UserConverter userConverter;
    UserDocumentConverter userDocumentConverter;

    @Override
    public List<User> findAll() {
        return userDocumentConverter.convert(userDAO.findAll());
    }

    @Override
    public User findByUsername(String username) {
        return userDocumentConverter.convert(userDAO.findByUsername(username));
    }

    @Override
    public User save(User user) {
        UserDocument user1 = userConverter.convert(user);
        return userDocumentConverter.convert(userDAO.save(user1));
    }

    @Override
    public void deleteById(String id) {
        userDAO.deleteById(id);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userDAO.existsByUsername(username);
    }
}
