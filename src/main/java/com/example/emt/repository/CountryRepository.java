package com.example.emt.repository;

import com.example.emt.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    public Optional<Country> findCountryByName(String country);
}
