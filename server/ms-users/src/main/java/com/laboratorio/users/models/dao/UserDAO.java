package com.laboratorio.users.models.dao;

import com.laboratorio.users.models.User;
import com.laboratorio.users.models.documents.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserDAO extends MongoRepository<UserDocument, String> {
    List<UserDocument> findAll();
    UserDocument findByUsername(String username);
    UserDocument save(UserDocument user);
    boolean existsByUsername(String username);

}
