package com.example.demo.events.handler;

import com.example.demo.events.BookUpdateEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class BookUpdateHandler implements ApplicationListener<BookUpdateEvent> {
    @Override
    public void onApplicationEvent(BookUpdateEvent bookUpdateEvent) {
        System.out.println("UserCreateHandler.onApplicationEvent");
        System.out.println("Book updated info: " + bookUpdateEvent.getBook());
    }
}
