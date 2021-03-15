package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.User;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface IBookService {
    Book addBook(Book book);
    Book getById(Integer id);
    void deleteBook(Book book);
    Book updateBook(Book book);
    List<Book> getBooksByAuthorId(Integer id);
    List<Book> getBooksByUserId(Integer id);
    List<Book> getAllBooks();
    Author getAuthorByBookId(Integer id);
    User getUserByBookId(Integer id);
//    List<Book> getAllBooksByAuthor(String author);
}
