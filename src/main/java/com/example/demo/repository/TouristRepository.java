package com.example.demo.repository;

import com.example.demo.model.Tourist;
import com.example.demo.queries.TouristQueries;
import com.example.demo.utils.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Date;
import java.util.List;

@Repository
public class TouristRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(TouristRepository.class);

    public List<Tourist> getTourists() {
        List<Tourist> touristList = jdbcTemplate.query(TouristQueries.GET_TOURIST_SQL, new BeanPropertyRowMapper<>(Tourist.class));
        logger.info("Tourists will be picked up from repo {}", touristList);
        return touristList;
    }

    public Tourist addTourist(Tourist tourist){

        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(TouristQueries.ADD_TOURIST_SQL, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, tourist.getFirstName());
                ps.setString(2, tourist.getLastName());
                ps.setDate(3, new java.sql.Date(tourist.getDateOfBirth().getTime()));
                ps.setDate(4, new java.sql.Date(tourist.getCreatedOn().getTime()));
                return ps;
            }
        }, holder);

        int newTouristId = holder.getKey().intValue();
        tourist.setTouristId(newTouristId);
        return tourist;
    }

    public List<Tourist> deleteTouristById(int id) {
        jdbcTemplate.update(TouristQueries.DELETE_TOURIST_SQL, id);
        return jdbcTemplate.query(TouristQueries.GET_TOURIST_SQL, new BeanPropertyRowMapper<>(Tourist.class));
    }

    public List<Tourist> getTouristByFirstName(String firstName) {
        List<Tourist> touristList = jdbcTemplate.query(TouristQueries.GET_TOURIST_BYFIRSTNAME_SQL, new BeanPropertyRowMapper<>(Tourist.class), firstName);
        if (touristList.isEmpty()) {
            throw new ObjectNotFoundException("First Name doesn't exist!!");
        }
        return touristList;
    }
}
