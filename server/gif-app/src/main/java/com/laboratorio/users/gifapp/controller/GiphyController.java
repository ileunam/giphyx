package com.laboratorio.users.gifapp.controller;

import com.laboratorio.users.gifapp.constants.Constants;
import com.laboratorio.users.gifapp.service.IGiphyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.PATH_GIPHY)
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class GiphyController {

    IGiphyService giphyService;

    @GetMapping("/trending")
    public ResponseEntity trendingGifs(
            @RequestParam(required = false) String limit,
            @RequestParam(required = false) String offset
    ) {
        return ResponseEntity.ok(giphyService.trendingGifs(limit, offset));
    }

    @GetMapping("/search")
    public ResponseEntity searchGifs(
            @RequestParam("q") String query,
            @RequestParam(required = false) String limit,
            @RequestParam(required = false) String offset
    ) {
        return ResponseEntity.ok(giphyService.searchGif(query, limit, offset));
    }

}
