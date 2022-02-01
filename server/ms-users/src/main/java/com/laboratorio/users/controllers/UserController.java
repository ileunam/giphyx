package com.laboratorio.users.controllers;


import com.laboratorio.users.exceptions.UserException;
import com.laboratorio.users.exceptions.UserNotFoundException;
import com.laboratorio.users.exceptions.UserSaveException;
import com.laboratorio.users.models.User;
import com.laboratorio.users.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping
public class UserController {
    IUserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/search/{username}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserByUsername(@PathVariable String username) {
        try {
            return userService.findByUsername(username);
        } catch (Exception e) {
            throw new UserNotFoundException("User not found");
        }

    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        try {
            return userService.save(user);
        } catch (Exception e) {
            throw new UserSaveException("Can't create the user");
        }
    }

    @PutMapping("/edit")
    @ResponseStatus(HttpStatus.CREATED)
    public User editUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@RequestParam String id) {
        userService.deleteById(id);
    }

    @GetMapping("/exists")
    @ResponseStatus(HttpStatus.OK)
    public boolean userExists(@RequestParam String username) {
        return userService.existsByUsername(username);
    }


}
