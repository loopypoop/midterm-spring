package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.model.Role;
import com.example.demo.model.User;

import java.util.List;

public interface IUserService {
    User create(User user);
    User getById(Integer id);
    List<User> getAllUsers();
    User update(User user);
    void delete(Integer id);

    User login(User user);
}
