package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;

public interface IBookService {
    Book addBook(Book book);
    Book getById(Integer id);
    void deleteBook(Book book);
    Book updateBook(Book book);
    List<Book> getAllBooksByAuthorId(Integer id);
//    List<Book> getAllBooksByAuthor(String author);
}
