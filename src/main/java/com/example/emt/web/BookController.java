package com.example.emt.web;

import com.example.emt.model.Author;
import com.example.emt.model.Book;
import com.example.emt.model.Category;
import com.example.emt.service.AuthorService;
import com.example.emt.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }



    @GetMapping
    private List<Book> findAll() {
        return this.bookService.findAll();
    }


    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestParam String name,
                                     @RequestParam Long authorId,
                                     @RequestParam Category category,
                                     @RequestParam int availableCopies) {
        Optional<Author> author = authorService.findById(authorId);
//        Book book = new Book(name, category, author.get(), availableCopies);


        return this.bookService.save(name, category, author.get(), availableCopies)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> save(@PathVariable Long id, @RequestParam String name,
                                     @RequestParam Long authorId,
                                     @RequestParam Category category,
                                     @RequestParam int availableCopies) {
        Optional<Author> author = authorService.findById(authorId);
        return this.bookService.edit( id,  name,  category, author.get(),  availableCopies)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }



    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if (this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

}

//event package vo model
// 3 klasi on bookAdded on bookEdited
// packeged listener
// bookeventhalndler ili listener
// vo nea 3 funkcii  koga kreiras brises ili editiras
//