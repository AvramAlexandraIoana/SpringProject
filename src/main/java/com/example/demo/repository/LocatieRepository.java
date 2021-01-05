package com.example.demo.repository;

import com.example.demo.model.Locatie;
import com.example.demo.model.Turist;
import com.example.demo.queries.LocatieQueries;
import com.example.demo.queries.TuristQueries;
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
public class LocatieRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(LocatieRepository.class);

    public List<Locatie> getLocatii() {
        List<Locatie> locatii = jdbcTemplate.query(LocatieQueries.GET_LOCATII_SQL, new BeanPropertyRowMapper<>(Locatie.class));
        logger.info("Locatiile sunt preluate din repo {}", locatii);
        return locatii;
    }

    public Locatie addLocatie(Locatie locatie) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(LocatieQueries.ADD_LOCATIE_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, locatie.getAdresa());
            ps.setString(2, locatie.getOras());
            return ps;
        }, holder);
        locatie.setIdLocatie(holder.getKey().intValue());
        logger.info("S-a adaugat locatia {}", locatie);
        return locatie;
    }

    public Locatie updateLocatie(Locatie locatie) {
        List<Locatie> findLocatii = jdbcTemplate.query(LocatieQueries.FIND_LOCATIE_BYID_SQL, new BeanPropertyRowMapper<>(Locatie.class), locatie.getIdLocatie());
        if (findLocatii.isEmpty()) {
            throw new ObjectNotFoundException("Nu exista nicio locatie cu acest id!");
        }
        logger.info("S-a updatat locatia  {}", locatie);
        jdbcTemplate.update(LocatieQueries.UPDATE_LOCATIE_SQL, locatie.getAdresa(), locatie.getOras(), locatie.getIdLocatie());
        return locatie;
    }

    public List<Locatie> deleteLocatie(int id) {
        List<Locatie> findLocatii = jdbcTemplate.query(LocatieQueries.FIND_LOCATIE_BYID_SQL, new BeanPropertyRowMapper<>(Locatie.class), id);
        if (findLocatii.isEmpty()) {
            throw new ObjectNotFoundException("Nu exista nicio locatie cu acest id!");
        }
        logger.info("S-a sters locatia cu id-ul", id);
        int number = jdbcTemplate.update(LocatieQueries.DELETE_LOCATIE_SQL, id);
        return findLocatii;
    }
}
