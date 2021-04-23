package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private IUserService iUserService;

    @PostMapping(value = "/auth")
    public User login(@RequestBody User user) {

//        User currentUser = iUserService.login(user);
//        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());

        return null;
    }

//    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = "application/json")
//    public void signup(@RequestBody User user) {
//        iUserService.signup(user);
//
//    }
}
