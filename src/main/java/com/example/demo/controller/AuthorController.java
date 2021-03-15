package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    IAuthorService iAuthorService;

    public Author createAuthor(@RequestBody Author author) {
        return iAuthorService.create(author);
    }

    public Author getById(@PathVariable("id") Integer id) {
        return iAuthorService.getById(id);
    }

    public List<Author> getAllAuthors() {
        return iAuthorService.getAllAuthors();
    }

    public Author updateAuthor(@RequestBody Author author) {
        return iAuthorService.update(author);
    }

    public void deleteAuthor(@PathVariable("id") Integer id) {
        iAuthorService.delete(id);
    }

}
