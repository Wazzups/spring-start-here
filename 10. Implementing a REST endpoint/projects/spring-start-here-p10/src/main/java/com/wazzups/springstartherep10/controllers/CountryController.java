package com.wazzups.springstartherep10.controllers;

import com.wazzups.springstartherep10.model.Country;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @GetMapping("/france")
    public Country france() {
        return Country.of("France", 67);
    }

    @GetMapping("/all")
    public List<Country> countries() {
        Country c1 = Country.of("Germany", 42);
        Country c2 = Country.of("France", 67);

        return List.of(c1, c2);
    }

    @GetMapping("/germany")
    public ResponseEntity<Country> germany() {
        Country c1 = Country.of("Germany", 42);

        return ResponseEntity.status(HttpStatus.ACCEPTED)
            .header("continent", "Europe")
            .header("capital", "Paris")
            .header("favorite_food", "cheese and wine")
            .body(c1);
    }
}
