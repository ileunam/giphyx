package com.laboratorio.users.gifapp.models.dao;


import com.laboratorio.users.gifapp.models.documents.GifDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GifDAO extends MongoRepository<GifDocument, String> {
    List<GifDocument> findAll();
    List<GifDocument> findByOwnerUsername(String ownerUsername);
    GifDocument save(GifDocument gif);
    void deleteById(String id);
    void deleteByIdAndOwnerUsername(String id, String ownerUsername);

}
