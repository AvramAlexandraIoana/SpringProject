package com.example.demo.controller;


import com.example.demo.model.Turist;
import com.example.demo.service.TuristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/turist")
public class TuristController {

    @Autowired
    private TuristService turistService;


    @GetMapping("/get")
    public ResponseEntity<List<Turist>> getTuristi() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                            .body(turistService.getTuristi());
    }


    @PostMapping("/add")
    public ResponseEntity<Turist> addTurist(@RequestBody @Valid Turist turist) {
        return ResponseEntity.created(UriComponentsBuilder.
                fromHttpUrl(ServletUriComponentsBuilder.
                        fromCurrentRequestUri().
                        toUriString())
                .replacePath("turist/get").build(turist.getNume()))
                .body(turistService.addTurist(turist));
    }

    @PutMapping("/update")
    public ResponseEntity<Turist> updateTurist(@RequestBody @Valid Turist turist) {
        return  ResponseEntity.status(HttpStatus.OK)
                .body(turistService.updateTurist(turist));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<List<Turist>> deleteTurist(@RequestParam int id) {
        return  ResponseEntity.status(HttpStatus.OK)
                .body(turistService.deleteTurist(id));
    }

    @GetMapping("/getTuristByFirstName")
    public ResponseEntity<List<Turist>> getTuristByFirstName(@RequestParam  String nume) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(turistService.getTuristByFirstName(nume));
    }
}
