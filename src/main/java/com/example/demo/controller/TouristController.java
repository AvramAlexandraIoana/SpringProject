package com.example.demo.controller;

import com.example.demo.model.Tourist;
import com.example.demo.repository.TouristRepository;
import com.example.demo.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/tourist")
public class TouristController {

    @Autowired
    private TouristService touristService;

    @GetMapping("/get")
    public ResponseEntity<List<Tourist>> getTourists() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(touristService.getTourists());
    }

    @PostMapping("/add")
    public ResponseEntity<Tourist> addTourist(@RequestBody @Valid Tourist tourist) {
        return ResponseEntity.created(UriComponentsBuilder
                .fromHttpUrl(ServletUriComponentsBuilder.
                        fromCurrentRequestUri().toUriString())
                .path("").query("firstName={firstName}").build().toUri())
                .body(touristService.addTourist(tourist));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<List<Tourist>> deleteTouristById(@RequestParam int id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(touristService.deleteTouristById(id));
    }

    @GetMapping("/getTouristByFirstName")
    public ResponseEntity<List<Tourist>> getTouristByFirstName(@RequestParam  String firstName) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                        .body(touristService.getTouristByFirstName(firstName));
    }
}
