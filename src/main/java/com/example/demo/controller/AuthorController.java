package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
public class AuthorController {
    @Autowired
    IAuthorService iAuthorService;


    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    public Author createAuthor(@RequestBody Author author) {
        return iAuthorService.create(author);
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET, produces = "application/json")
    public Author getById(@PathVariable("id") Integer id) {
        return iAuthorService.getById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
    public Author updateAuthor(@RequestBody Author author) {
        return iAuthorService.update(author);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public void deleteAuthor(@PathVariable("id") Integer id) {
        iAuthorService.delete(id);
    }
}
