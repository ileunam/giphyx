package com.laboratorio.users.gifapp.service;

import com.laboratorio.users.gifapp.models.Gif;
import com.laboratorio.users.gifapp.models.dao.GifDAO;
import com.laboratorio.users.gifapp.models.documents.GifDocument;

import java.util.List;

public interface IGifService {
    List<Gif> findAll();
    List<Gif> findByOwnerUsername(String ownerUsername);
    Gif save(Gif gif);
    void deleteById(String id);
    void deleteByIdAndOwnerUsername(String id, String ownerUsername);

}
