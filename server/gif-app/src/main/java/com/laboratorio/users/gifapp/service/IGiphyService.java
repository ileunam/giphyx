package com.laboratorio.users.gifapp.service;

import java.util.Map;

public interface IGiphyService {

    Map searchGif(String query, String limit, String offset);
    Map trendingGifs(String limit, String offset);

}
