package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.model.User;
import com.example.demo.service.IAuthorService;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    IUserService iUserService;

    public User createUser(@RequestBody User user) {
        return iUserService.create(user);
    }

    public User getById(@PathVariable("id") Integer id) {
        return iUserService.getById(id);
    }

    public List<User> getAllUsers() {
        return iUserService.getAllUsers();
    }

    public User updateUser(@RequestBody User user) {
        return iUserService.update(user);
    }

    public void deleteUser(@PathVariable("id") Integer id) {
        iUserService.delete(id);
    }
}

