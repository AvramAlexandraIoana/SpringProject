package com.example.demo.service;

import com.example.demo.model.Tourist;
import com.example.demo.queries.TouristQueries;
import com.example.demo.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
public class TouristService {

    @Autowired
    private TouristRepository touristRepository;

    public List<Tourist> getTourists() {
        return touristRepository.getTourists();
    }

    public Tourist addTourist(Tourist tourist){
        tourist.setCreatedOn(new Date());
        return touristRepository.addTourist(tourist);
    }

    public List<Tourist> deleteTouristById(int id) {
        return touristRepository.deleteTouristById(id);
    }

    public List<Tourist> getTouristByFirstName(String firstName) {
        return touristRepository.getTouristByFirstName(firstName);
    }
}
