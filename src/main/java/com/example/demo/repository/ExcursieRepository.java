package com.example.demo.repository;

import com.example.demo.model.Excursie;
import com.example.demo.model.Locatie;
import com.example.demo.queries.ExcursieQueries;
import com.example.demo.queries.LocatieQueries;
import com.example.demo.utils.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class ExcursieRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(ExcursieRepository.class);

    public List<Excursie> getExcursii() {
        List<Excursie> excursii = jdbcTemplate.query(ExcursieQueries.GET_EXCURSII_SQL, new BeanPropertyRowMapper<>(Excursie.class));
        logger.info("Excursiile sunt preluate din repo {}", excursii);
        return excursii;
    }

    public Excursie addExcursie(Excursie excursie) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(ExcursieQueries.ADD_EXCURSIE_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, excursie.getDenumire());
            ps.setDouble(2, excursie.getPret());
            ps.setInt(3, excursie.getDurata());
            ps.setInt(4, excursie.getNrLocuri());
            ps.setInt(5, excursie.getCodAgentie());
            ps.setInt(6, excursie.getCodLocatie());
            return ps;
        }, holder);
        excursie.setIdExcursie(holder.getKey().intValue());
        logger.info("S-a adaugat excursia {}", excursie);
        return excursie;
    }

    public Excursie updateExcursie(Excursie excursie) {
        List<Excursie> findExcursii = jdbcTemplate.query(ExcursieQueries.FIND_EXCURSIE_BYID_SQL, new BeanPropertyRowMapper<>(Excursie.class), excursie.getIdExcursie());
        if (findExcursii.isEmpty()) {
            throw new ObjectNotFoundException("Nu exista nicio excursie cu acest id!");
        }
        logger.info("S-a updatat excursia  {}", excursie);
        jdbcTemplate.update(ExcursieQueries.UPDATE_EXCURSIE_SQL, excursie.getDenumire(), excursie.getPret(), excursie.getDurata(),
                excursie.getNrLocuri(), excursie.getCodAgentie(), excursie.getCodLocatie(), excursie.getIdExcursie());
        return excursie;
    }

    public List<Excursie> deleteExcursie(int id) {
        List<Excursie> findExcursii = jdbcTemplate.query(ExcursieQueries.FIND_EXCURSIE_BYID_SQL, new BeanPropertyRowMapper<>(Excursie.class), id);
        if (findExcursii.isEmpty()) {
            throw new ObjectNotFoundException("Nu exista nicio excursie cu acest id!");
        }
        logger.info("S-a sters excursia cu id-ul", id);
        int number = jdbcTemplate.update(ExcursieQueries.DELETE_EXCRUSIE_SQL, id);
        return findExcursii;
    }
}
