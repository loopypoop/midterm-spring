package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.service.IBookService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
@Api(value = "Book Controller Class", description = "This class allows to interact with Book object")
public class BookController {
    @Autowired
    IBookService ibookService;

    @PostMapping(value = "/create")
    public Book createBook(@RequestBody Book book) {
        return ibookService.addBook(book);
    }

    @GetMapping(value = "/read/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return ibookService.getById(id);
    }

    @GetMapping(value = "")
    public Book getParamBookById(Integer id) {
        return ibookService.getById(id);
    }

    @PutMapping(value = "/update")
    public Book updateBook(@RequestBody Book book) {
        return ibookService.updateBook(book);
    }

    @GetMapping(value = "/read/author/{authorId}")
    public List<Book> getBooksByAuthorId(@PathVariable Integer authorId) {
        return ibookService.getBooksByAuthorId(authorId);
    }

    @GetMapping(value = "/read/all")
    public List<Book> getAllBooks() {
        return ibookService.getAllBooks();
    }

    @GetMapping(value = "/read/by-book/{bookId}")
    public Author getAuthorByBookId(@PathVariable Integer bookId) {
        return ibookService.getAuthorByBookId(bookId);
    }
}
