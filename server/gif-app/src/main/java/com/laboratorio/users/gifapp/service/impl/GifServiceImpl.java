package com.laboratorio.users.gifapp.service.impl;

import com.laboratorio.users.gifapp.converters.GifConverter;
import com.laboratorio.users.gifapp.converters.GifDocumentConverter;
import com.laboratorio.users.gifapp.models.Gif;
import com.laboratorio.users.gifapp.models.dao.GifDAO;
import com.laboratorio.users.gifapp.models.documents.GifDocument;
import com.laboratorio.users.gifapp.service.IGifService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GifServiceImpl implements IGifService {

    GifDAO gifDAO;
    GifConverter gifConverter;
    GifDocumentConverter gifDocumentConverter;

    @Override
    public List<Gif> findAll() {
        return gifDocumentConverter.convert(gifDAO.findAll());
    }

    @Override
    public List<Gif> findByOwnerUsername(String ownerUsername) {
        return gifDocumentConverter.convert(gifDAO.findByOwnerUsername(ownerUsername));
    }

    @Override
    public Gif save(Gif gif) {
        return gifDocumentConverter.convert(gifDAO.save(gifConverter.convert(gif)));
    }

    @Override
    public void deleteById(String id) {
        gifDAO.deleteById(id);
    }

    @Override
    public void deleteByIdAndOwnerUsername(String id, String ownerUsername) {
        gifDAO.deleteByIdAndOwnerUsername(id, ownerUsername);
    }
}
