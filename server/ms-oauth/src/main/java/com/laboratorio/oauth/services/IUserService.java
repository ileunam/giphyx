package com.laboratorio.oauth.services;

import com.laboratorio.oauth.models.User;

public interface IUserService {
    public User findByUsername(String username);
}
