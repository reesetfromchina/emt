package com.example.emt.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "book_users")
public class User {
    @Id
    private String username;
    private String password;
    private String name;
    private String surname;

    @Enumerated(value = EnumType.STRING)
    private Role role;


    // default:
    // to-one -> FetchType.EAGER
    // to-many -> FetchType.LAZY
    @OneToMany
    private List<Book> books;



    public User(){

    }
}
