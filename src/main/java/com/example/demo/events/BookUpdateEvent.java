package com.example.demo.events;

import com.example.demo.model.Book;
import org.springframework.context.ApplicationEvent;

public class BookUpdateEvent extends ApplicationEvent {

    private Book book;

    public BookUpdateEvent (Object source, Book book) {
        super(source);
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
}
