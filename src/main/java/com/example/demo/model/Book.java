package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Component
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column(name = "authorId")
    private Integer authorId;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private Double price;

    @Column(name = "userId")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "authorId", insertable = false, updatable = false)
    private Author author;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", authorId=" + authorId +
                '}';
    }
}
