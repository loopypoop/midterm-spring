package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    IBookService ibookService;

    public Book createBook(@RequestBody Book book) {
        return ibookService.addBook(book);
    }

    public Book getBookById(@PathVariable(name = "id") Integer id) {
        return ibookService.getById(id);
    }

    public Book getParamBookById(@RequestParam Integer id) {
        return ibookService.getById(id);
    }

    public Book updateBook(@RequestBody Book book) {
        return ibookService.updateBook(book);
    }

    public List<Book> getBooksByAuthorId(@RequestParam Integer authorId) {
        return ibookService.getBooksByAuthorId(authorId);
    }

    public List<Book> getAllBooks() {
        return ibookService.getAllBooks();
    }

    public Author getAuthorByBookId(@PathVariable(name = "id") Integer id) {
        return ibookService.getAuthorByBookId(id);
    }
}
