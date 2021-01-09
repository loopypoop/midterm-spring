package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    IBookService ibookService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    public Book createBook(@RequestBody Book book) {
        return ibookService.addBook(book);
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET, produces = "application/json")
    public Book getBookById(@PathVariable(name = "id") Integer id) {
        return ibookService.getById(id);
    }

    @RequestMapping(value = "/getByParamId", method = RequestMethod.GET, produces = "application/json")
    public Book getParamBookById(@RequestParam Integer id) {
        return ibookService.getById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
    public Book updateBook(@RequestBody Book book) {
        return ibookService.updateBook(book);
    }

    @RequestMapping(value = "/getBooksByAuthorId", method = RequestMethod.GET, produces = "application/json")
    public List<Book> getBooksByAuthorId(@RequestParam Integer authorId) {
        return ibookService.getBooksByAuthorId(authorId);
    }
}