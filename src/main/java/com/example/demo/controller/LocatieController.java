package com.example.demo.controller;

import com.example.demo.model.Locatie;
import com.example.demo.service.LocatieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/locatie")
public class LocatieController {

    @Autowired
    private LocatieService locatieService;


    @GetMapping("/get")
    public ResponseEntity<List<Locatie>> getLocatii() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                            .body(locatieService.getLocatii());
    }

    @PostMapping("/add")
    public ResponseEntity<Locatie> addLocatie(@RequestBody @Valid Locatie locatie) {
        return ResponseEntity.created(UriComponentsBuilder.
                fromHttpUrl(ServletUriComponentsBuilder.
                        fromCurrentRequestUri().
                        toUriString())
                .path("").query("oras={oras}").build(locatie.getOras()))
                .body(locatieService.addLocatie(locatie));
    }


    @PutMapping("/update")
    public ResponseEntity<Locatie> updateLocatie(@RequestBody  @Valid Locatie locatie) {
        return ResponseEntity.status(HttpStatus.OK)
                            .body(locatieService.updateLocatie(locatie));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<List<Locatie>> deleteLocatie(@RequestParam int id) {
        return ResponseEntity.status(HttpStatus.OK)
                            .body(locatieService.deleteLocatie(id));
    }
}
