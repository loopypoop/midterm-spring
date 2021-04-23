package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.service.IAuthorService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@Api(value = "Author Controller Class", description = "This class allows to interact with Author object")
public class AuthorController {
    @Autowired
    IAuthorService iAuthorService;

    @PostMapping(value = "/create")
    public Author createAuthor(@RequestBody Author author) {
        return iAuthorService.create(author);
    }

    @GetMapping(value = "/read/{id}")
    public Author getById(@PathVariable Integer id) {
        return iAuthorService.getById(id);
    }

    @GetMapping(value = "/read")
    public List<Author> getAllAuthors() {
        return iAuthorService.getAllAuthors();
    }

    @PutMapping(value = "/update")
    public Author updateAuthor(@RequestBody Author author) {
        return iAuthorService.update(author);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteAuthor(@PathVariable Integer id) {
        iAuthorService.delete(id);
    }

}
