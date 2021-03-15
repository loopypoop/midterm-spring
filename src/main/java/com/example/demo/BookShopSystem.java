package com.example.demo;

import com.example.demo.config.SpringConfig;
import com.example.demo.controller.AuthorController;
import com.example.demo.controller.BookController;
import com.example.demo.controller.UserController;
import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookShopSystem {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    AuthorController authorController = context.getBean(AuthorController.class);
    BookController bookController = context.getBean(BookController.class);
    UserController userController = context.getBean(UserController.class);

    Scanner in = new Scanner(System.in);

    public void menu() {


        List<User> auth = userController.getAllUsers();
        boolean loggedIn = false;

        System.out.println("Enter username");
        String username = in.next();
        System.out.println("Enter password");
        String password = in.next();

        User currentUser = new User();
        for(User user: auth) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                loggedIn = true;
                currentUser = user;
                break;
            }
        }

        if (loggedIn) {
            List<Book> bookList = bookController.getAllBooks();
            int i = 1;
            for (Book book: bookList) {
                System.out.println(i + ". " + book.getName() + " - " + book.getPrice());
                i++;
            }
            System.out.println();
            System.out.print("Enter book you want to buy: ");
            int select = in.nextInt();

            Book currentBook = bookList.get(select - 1);
            String authorName = authorController.getById(currentBook.getAuthorId()).getName();

            System.out.println("Title: " + currentBook.getName());
            System.out.println("Description: " + '\n' + currentBook.getDescription());
            System.out.println("Author: " + authorName);
            System.out.println("Price: " + currentBook.getPrice());
            System.out.println('\n');

            System.out.println("1. Buy");
            System.out.println("2. Back");

            int buy = in.nextInt();

            if (buy == 1) {
                if (currentUser.getBalance() >= currentBook.getPrice() && currentBook.getUserId() == null) {
                    currentBook.setUserId(currentUser.getId());
                    bookController.updateBook(currentBook);
                    System.out.println("Book successfully bought");
                } else if (currentUser.getBalance() < currentBook.getPrice()){
                    System.out.println("Not enough money!");
                } else if (currentBook.getUserId() != null) {
                    System.out.println("Book has already bought");
                }
            }
        }
    }

    public void create() {

        int choice = -1;

        while (choice != 0) {

            System.out.println("1. Create User");
            System.out.println("2. Create Author");
            System.out.println("3. Create Book");
            System.out.println("0. Exit");

            choice = in.nextInt();

            switch (choice) {
                case 1:
                    User user = new User();

                    System.out.print("Enter username: ");
                    String ignore = in.nextLine();
                    String username = in.nextLine();
                    System.out.print("Enter password: ");
                    String password = in.nextLine();
                    System.out.print("Enter email: ");
                    String email = in.nextLine();
                    System.out.print("Enter balance: ");
                    Double balance = in.nextDouble();

                    user.setUsername(username);
                    user.setPassword(password);
                    user.setEmail(email);
                    user.setBalance(balance);
                    System.out.println(userController.createUser(user));
                    break;
                case 2:
                    Author author = new Author();

                    System.out.print("Enter name: ");
                    String ignore1 = in.nextLine();
                    String authorName = in.nextLine();
                    System.out.println("Who is he/she?");
                    String about = in.nextLine();

                    author.setName(authorName);
                    author.setAbout(about);

                    System.out.println(authorController.createAuthor(author));
                    break;
                case 3:
                    Book book = new Book();

                    System.out.print("Enter title: ");
                    String ignore2 = in.nextLine();
                    String title = in.nextLine();
                    System.out.println("Enter Description: ");
                    String description = in.nextLine();
                    System.out.print("Enter price: ");
                    Double price = in.nextDouble();
                    System.out.println("Enter ID of author");
                    Integer authorId = in.nextInt();


                    book.setName(title);
                    book.setDescription(description);
                    book.setPrice(price);
                    book.setAuthorId(authorId);

                    System.out.println(bookController.createBook(book));
                    break;
                default:
                    System.out.println("Wrong choice!");
                    break;
                case 0:
                    return;
            }
        }

    }
}
