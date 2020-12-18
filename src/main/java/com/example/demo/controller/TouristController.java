package com.example.demo.controller;

import com.example.demo.model.Tourist;
import com.example.demo.repository.TouristRepository;
import com.example.demo.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tourist")
public class TouristController {

    @Autowired
    private TouristService touristService;

    @GetMapping("/get")
    public List<Tourist> getTourists() {
        return touristService.getTourists();
    }

    @PostMapping("/add")
    public List<Tourist> addTourist(@RequestBody Tourist tourist) {
        return touristService.addTourist(tourist);
    }

    @DeleteMapping("/delete")
    public List<Tourist> deleteTouristById(@RequestParam int id) {
        return touristService.deleteTouristById(id);
    }
}
