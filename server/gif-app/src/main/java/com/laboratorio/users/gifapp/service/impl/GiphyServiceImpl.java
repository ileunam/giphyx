package com.laboratorio.users.gifapp.service.impl;

import com.laboratorio.users.gifapp.constants.Constants;
import com.laboratorio.users.gifapp.clients.GiphyFeignClient;
import com.laboratorio.users.gifapp.service.IGiphyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class GiphyServiceImpl implements IGiphyService {

    GiphyFeignClient giphyRestClient;
    @Override
    public Map searchGif(String query, String limit, String offset) {
        return giphyRestClient.getGifs(Constants.KEY, query, limit, offset);
    }

    @Override
    public Map trendingGifs(String limit, String offset) {
        return giphyRestClient.getTrendingGifs(Constants.KEY, limit, offset);
    }
}
