package com.example.demo.service.impl;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Book addBook(Book book) {
        Author author = authorRepository.getById(book.getAuthorId());
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @Override
    public Book getById(Integer id) {
        return bookRepository.getById(id);
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooksByAuthorId(Integer id) {
        return bookRepository.getAllByAuthorId(id);
    }


//    @Override
//    public List<Book> getAllBooksByAuthor(String author) {
//        return bookRepository.getAllByAuthor(author);
//    }

}
