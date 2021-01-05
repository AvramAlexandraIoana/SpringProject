package com.example.demo.controller;


import com.example.demo.model.Achizitioneaza;
import com.example.demo.service.AchizitioneazaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/achizitioneaza")
public class AchizitioneazaController {

    @Autowired
    private AchizitioneazaService achizitioneazaService;


    @GetMapping("/get")
    public ResponseEntity<List<Achizitioneaza>> getAchizitii() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                            .body(achizitioneazaService.getAchizitii());
    }

    @PostMapping("/add")
    public ResponseEntity<Achizitioneaza> addAchizitie(@RequestBody @Valid Achizitioneaza achizitioneaza) {
        return ResponseEntity.created(UriComponentsBuilder.
                fromHttpUrl(ServletUriComponentsBuilder.
                        fromCurrentRequestUri().
                        toUriString())
                .replacePath("achizitioneaza/get").build(achizitioneaza.getDataAchizitie()))
                .body(achizitioneazaService.addAchizitie(achizitioneaza));
    }

    @PutMapping("/update")
    public ResponseEntity<Achizitioneaza> updateAchizitie(@RequestBody @Valid Achizitioneaza achizitioneaza) {
        return  ResponseEntity.status(HttpStatus.OK)
                            .body(achizitioneazaService.updateAchizitie(achizitioneaza));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<List<Achizitioneaza>> deleteAchizitie(@RequestParam int idTurist, @RequestParam int idExcursie) {
        return ResponseEntity.status(HttpStatus.OK)
                    .body(achizitioneazaService.deleteAchizitie(idTurist, idExcursie));
    }
}
