package com.example.demo.service.impl;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getById(Integer id) {
        return authorRepository.getById(id);
    }
}
