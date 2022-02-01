package com.laboratorio.users.gifapp.models.documents;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("gif")
@Data
@Builder
public class GifDocument {
    @Id
    private String id;
    private String giphyId;
    private List<String> favs;
    @Indexed(unique = true)
    private String ownerUsername;
}
