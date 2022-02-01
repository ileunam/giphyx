package com.laboratorio.users.gifapp.converters;

import com.laboratorio.users.gifapp.models.Gif;
import com.laboratorio.users.gifapp.models.documents.GifDocument;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GifConverter implements Converter<Gif, GifDocument> {

    @Override
    public GifDocument convert(Gif gif) {
        return GifDocument.builder()
                .id(gif.getId())
                .giphyId(gif.getGiphyId())
                .favs(gif.getFavs())
                .ownerUsername(gif.getOwnerUsername())
                .build();
    }

    public List<GifDocument> convert(List<Gif> gifList) {
        List<GifDocument> gifDocumentList = new ArrayList<>();
        gifList.forEach(gif -> gifDocumentList.add(convert(gif)));
        return gifDocumentList;
    }
}
