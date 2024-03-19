package com.example.emt.service.impl;

import com.example.emt.model.Country;
import com.example.emt.repository.CountryRepository;
import com.example.emt.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        Country country = new Country(name, continent);
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public Optional<Country> edit(Long id, String name, String continent) {
        Country country = countryRepository.findById(id).orElseThrow();
        country.setName(name);
        country.setContinent(continent);
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public void deleteById(long id) {
        countryRepository.deleteById(id);
    }
}
