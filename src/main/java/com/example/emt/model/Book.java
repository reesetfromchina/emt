package com.example.emt.model;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Category category;
    @ManyToOne
    private Author author;
    private int availableCopies;

    public Book(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book(String name, Category category, Author author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Book() {

    }
}
