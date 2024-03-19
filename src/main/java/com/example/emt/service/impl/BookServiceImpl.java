package com.example.emt.service.impl;

import com.example.emt.model.Author;
import com.example.emt.model.Book;
import com.example.emt.model.Category;
import com.example.emt.repository.BookRepository;
import com.example.emt.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }


    @Override
    public Optional<Book> save(String name, Category category, Author author, int availableCopies) {
        Book book = new Book(name, category, author, availableCopies);
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Author author, int availableCopies) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
