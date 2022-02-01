package com.laboratorio.users.gifapp.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "giphy-client", url = "api.giphy.com/v1/gifs")
public interface GiphyFeignClient {

    @GetMapping(path = "/search", consumes = MediaType.APPLICATION_JSON_VALUE)
    Map getGifs(
            @RequestParam("api_key") String key,
            @RequestParam("q") String query,
            @RequestParam String limit,
            @RequestParam String offset
    );

    @GetMapping(path = "/trending", consumes = MediaType.APPLICATION_JSON_VALUE)
    Map getTrendingGifs(
            @RequestParam("api_key") String key,
            @RequestParam String limit,
            @RequestParam String offset
    );
}
