package com.example.emt.service;

import com.example.emt.model.Author;
import com.example.emt.model.Book;
import com.example.emt.model.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);


    Optional<Book> save(String name, Category category, Author author, int availableCopies);

    Optional<Book> edit(Long id,String name, Category category, Author author, int availableCopies);

    void deleteById(Long id);


}
