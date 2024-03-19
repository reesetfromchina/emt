package com.example.emt.service.impl;

import com.example.emt.model.Author;
import com.example.emt.model.Country;
import com.example.emt.repository.AuthorRepository;
import com.example.emt.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> save(String name, String surname, Country country) {
        Author author = new Author(name, surname, country);
        return Optional.of(author);
    }


    @Override
    public Optional<Author> edit(Long id, String name, String surname, Country country) {
        Author author = authorRepository.findById(id).orElseThrow();
        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country);
        return Optional.of(authorRepository.save(author));
    }

    @Override
    public void deleteById(long id) {
        authorRepository.deleteById(id);
    }
}
