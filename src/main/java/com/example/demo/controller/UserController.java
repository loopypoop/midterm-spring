package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@Api(value = "User Controller Class", description = "This class allows to interact with User object")
public class UserController {

    @Autowired
    IUserService iUserService;

    @PostMapping(value = "/create")
    public User createUser(@RequestBody User user) {
        return iUserService.create(user);
    }

    @GetMapping(value = "/read/{id}")
    public User getById(@PathVariable Integer id) {
        return iUserService.getById(id);
    }

    @GetMapping(value = "/read/all")
    @ApiOperation(value = "Method to get list of all users", response = List.class)
    public List<User> getAllUsers() {
        return iUserService.getAllUsers();
    }

    @PutMapping(value = "/update")
    public User updateUser(@RequestBody User user) {
        return iUserService.update(user);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        iUserService.delete(id);
    }

    @GetMapping(value = "/login")
    public User login(@RequestBody User user) {
        return iUserService.login(user);
    }
}

