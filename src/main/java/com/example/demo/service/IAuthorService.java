package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.model.Book;

import java.util.List;

public interface IAuthorService {
    Author create(Author author);
    Author getById(Integer id);
    List<Author> getAllAuthors();
    Author update(Author author);
    void delete(Integer id);
}
