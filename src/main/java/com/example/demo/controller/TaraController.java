package com.example.demo.controller;

import com.example.demo.model.Tara;
import com.example.demo.service.TaraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tara")
public class TaraController {

    @Autowired
    private TaraService taraService;


    @GetMapping("/get")
    public ResponseEntity<List<Tara>> getTari() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                            .body(taraService.getTari());
    }

    @PostMapping("/add")
    public ResponseEntity<Tara> addTara(@RequestBody @Valid Tara tara) {
        return ResponseEntity.created(UriComponentsBuilder.
                fromHttpUrl(ServletUriComponentsBuilder.
                        fromCurrentRequestUri().toUriString())
                .replacePath("tara/get").build(tara.getNume()))
                .body(taraService.addTara(tara));
    }

    @PutMapping("/update")
    public ResponseEntity<Tara> updateTara(@RequestBody @Valid Tara tara) {
        return ResponseEntity.status(HttpStatus.OK)
                            .body(taraService.updateTara(tara));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<List<Tara>> deleteTara(@RequestParam int id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(taraService.deleteTara(id));
    }
}
