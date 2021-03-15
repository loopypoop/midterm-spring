package com.example.demo.service.impl;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.User;
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
    public List<Book> getBooksByAuthorId(Integer id) {
        return bookRepository.getAllByAuthorId(id);
    }

    @Override
    public List<Book> getBooksByUserId(Integer id) {
        return bookRepository.getAllByUserId(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Author getAuthorByBookId(Integer id) {
        Book book = bookRepository.getById(id);
        return book.getAuthor();
    }

    @Override
    public User getUserByBookId(Integer id) {
        Book book = bookRepository.getById(id);
        return book.getUser();
    }


//    @Override
//    public List<Book> getAllBooksByAuthor(String author) {
//        return bookRepository.getAllByAuthor(author);
//    }

}
