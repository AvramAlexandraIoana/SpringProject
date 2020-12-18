package com.example.demo.repository;

import com.example.demo.model.Tourist;
import com.example.demo.queries.TouristQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class TouristRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Tourist> getTourists() {
        return jdbcTemplate.query(TouristQueries.GET_TOURIST_SQL, new BeanPropertyRowMapper<>(Tourist.class));
    }

    public List<Tourist> addTourist(Tourist tourist) {
        tourist.setCreatedOn(new Date());
        jdbcTemplate.update(TouristQueries.ADD_TOURIST_SQL, tourist.getFirstName(), tourist.getLastName(), tourist.getDateOfBirth(), tourist.getCreatedOn());
        return jdbcTemplate.query(TouristQueries.GET_TOURIST_SQL, new BeanPropertyRowMapper<>(Tourist.class));
    }

    public List<Tourist> deleteTouristById(int id) {
        jdbcTemplate.update(TouristQueries.DELETE_TOURIST_SQL, id);
        return jdbcTemplate.query(TouristQueries.GET_TOURIST_SQL, new BeanPropertyRowMapper<>(Tourist.class));
    }
}
