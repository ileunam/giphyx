package com.laboratorio.users.gifapp.controller;

import com.laboratorio.users.gifapp.models.Gif;
import com.laboratorio.users.gifapp.service.impl.GifServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.json.JsonObject;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
public class GifController {
    GifServiceImpl gifService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Gif> getAllGifs(){
        return gifService.findAll();
    }

    @GetMapping("/authuser/search")
    @ResponseStatus(HttpStatus.OK)
    public List<Gif> getAuthUserGifs(@RequestHeader("Authorization") String token){
        String username = decodeToken(token);
        return gifService.findByOwnerUsername(username);
    }

    @PostMapping("/authuser/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Gif createAuthUserGif(@RequestBody Gif gif, @RequestHeader("Authorization") String token){
        String username = decodeToken(token);
        gif.setOwnerUsername(username);
        return gifService.save(gif);
    }

    @DeleteMapping("/authuser/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthUserGif(@PathVariable String id, @RequestHeader("Authorization") String token){
        String username = decodeToken(token);
        gifService.deleteByIdAndOwnerUsername(id, username);
    }

    private String decodeToken(String token){
        String[] chunks = token.split(" ")[1].split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String header = new String(decoder.decode(chunks[0]));
        String payload = new String(decoder.decode(chunks[1]));

        JSONObject obj = new JSONObject(payload);
        return obj.getString("user_name");
    }


}
