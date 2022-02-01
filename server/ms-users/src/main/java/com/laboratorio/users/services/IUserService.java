package com.laboratorio.users.services;

import com.laboratorio.users.models.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findByUsername(String username);
    User save(User user);
    void deleteById(String id);
    boolean existsByUsername(String username);
}
