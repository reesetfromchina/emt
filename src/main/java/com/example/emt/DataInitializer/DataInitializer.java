package com.example.emt.DataInitializer;

import com.example.emt.model.Author;
import com.example.emt.model.Book;
import com.example.emt.model.Category;
import com.example.emt.model.Country;
import com.example.emt.repository.AuthorRepository;
import com.example.emt.repository.BookRepository;
import com.example.emt.repository.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataInitializer(CountryRepository countryRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {


        // Initialize country data
        countryRepository.save(new Country("default", "default"));
        countryRepository.save(new Country("United States", "North America"));
        countryRepository.save(new Country("United Kingdom", "Europe"));

        // Initialize author data
        authorRepository.save(new Author("Stephen", "King", countryRepository.findCountryByName("United States").get()));
        authorRepository.save(new Author("J.K.", "Rowling", countryRepository.findCountryByName("United Kingdom").get()));

        // Initialize book data
       // bookRepository.save(new Book("The Shining", authorRepository.findByNameAndAndSurname("Stephen", "King").get(), Category.THRILER, 10));
     //   bookRepository.save(new Book("Harry Potter", authorRepository.findBedityNameAndAndSurname("J.K.", "Rowling").get(), Category.FANTASY, 15));
            bookRepository.save(new Book("Atomic Habits",Category.BIOGRAPHY, authorRepository.findById(1l).get(), 10));
    }

}
