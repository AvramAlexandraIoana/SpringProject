package com.example.demo.mapper;

import com.example.demo.dto.CountryRequest;
import com.example.demo.model.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {
    public Country countryRequestToCountry(CountryRequest countryRequest) {
        return new Country(countryRequest.getName());
    }
}
