package com.laboratorio.users.gifapp.converters;

import com.laboratorio.users.gifapp.models.Gif;
import com.laboratorio.users.gifapp.models.documents.GifDocument;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GifDocumentConverter implements Converter<GifDocument, Gif> {

    @Override
    public Gif convert(GifDocument gifDocument) {
        return Gif.builder()
                .id(gifDocument.getId())
                .giphyId(gifDocument.getGiphyId())
                .favs(gifDocument.getFavs())
                .ownerUsername(gifDocument.getOwnerUsername())
                .build();
    }

    public List<Gif> convert(List<GifDocument> gifDocumentList) {
        List<Gif> gifList = new ArrayList<>();
        gifDocumentList.forEach(gifDocument -> gifList.add(convert(gifDocument)));
        return gifList;
    }
}
