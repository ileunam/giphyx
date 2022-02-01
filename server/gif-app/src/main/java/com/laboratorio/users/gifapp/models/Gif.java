package com.laboratorio.users.gifapp.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Gif {
    private String id;
    private String giphyId;
    private List<String> favs;
    private String ownerUsername;
}
