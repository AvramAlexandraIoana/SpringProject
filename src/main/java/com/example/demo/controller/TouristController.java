package com.example.demo.controller;

import com.example.demo.dto.LocationRequest;
import com.example.demo.dto.TouristRequest;
import com.example.demo.mapper.LocationMapper;
import com.example.demo.mapper.TouristMapper;
import com.example.demo.model.Location;
import com.example.demo.model.Tourist;
import com.example.demo.repository.TouristRepository;
import com.example.demo.service.LocationService;
import com.example.demo.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tourists")
public class TouristController {
    private TouristService touristService;
    private TouristMapper touristMapper;

    public TouristController(TouristService touristService, TouristMapper touristMapper) {
        this.touristService = touristService;
        this.touristMapper = touristMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<Tourist> create(@RequestBody @Valid TouristRequest touristRequest) {
        Tourist savedTourist = touristService.create(
                touristMapper.touristRequestToTourist(touristRequest));
        return ResponseEntity.created(UriComponentsBuilder.
                fromHttpUrl(ServletUriComponentsBuilder.
                        fromCurrentRequestUri().
                        toUriString())
                .replacePath("tourists/" + savedTourist.getTouristId())
                .build(savedTourist.getTouristId()))
                .body(savedTourist);

    }

    @GetMapping("/get")
    public ResponseEntity<List<Tourist>> get() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(touristService.get());
    }

    @PutMapping("/update")
    public ResponseEntity<Tourist> update(@RequestBody @Valid Tourist tourist) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(touristService.update(tourist));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Optional<Tourist>> delete(@RequestParam int id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(touristService.delete(id));
    }
}
