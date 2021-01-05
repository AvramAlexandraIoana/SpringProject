package com.example.demo.controller;

import com.example.demo.model.Excursie;
import com.example.demo.service.ExcursieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/excursie")
public class ExcursieController {

    @Autowired
    private ExcursieService excursieService;

    @GetMapping("/get")
    public ResponseEntity<List<Excursie>> getExcursii() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                        .body(excursieService.getExcursii());
    }

    @PostMapping("/add")
    public ResponseEntity<Excursie> addExcursie(@RequestBody @Valid Excursie excursie) {
        return ResponseEntity.created(UriComponentsBuilder.
                fromHttpUrl(ServletUriComponentsBuilder.
                        fromCurrentRequestUri().
                        toUriString())
                .path("").query("denumire={denumire}").build(excursie.getDenumire()))
                .body(excursieService.addExcursie(excursie));
    }

    @PutMapping("/update")
    public ResponseEntity<Excursie> updateExcursie(@RequestBody @Valid Excursie excursie) {
        return ResponseEntity.status(HttpStatus.OK)
                            .body(excursieService.updateExcursie(excursie));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<List<Excursie>> deleteExcursie(@RequestParam int id) {
        return ResponseEntity.status(HttpStatus.OK)
                        .body(excursieService.deleteExcursie(id));
    }
}
