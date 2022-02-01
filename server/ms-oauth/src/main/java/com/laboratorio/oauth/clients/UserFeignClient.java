package com.laboratorio.oauth.clients;

import com.laboratorio.oauth.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ms-users")
public interface UserFeignClient {

    @GetMapping("/search/{username}")
    public User findByUsername(@PathVariable String username);
}
