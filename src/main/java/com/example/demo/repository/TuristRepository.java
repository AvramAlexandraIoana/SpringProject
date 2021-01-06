package com.example.demo.repository;

import com.example.demo.model.Turist;
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

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TuristRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(TuristRepository.class);


    public List<Turist> getTuristi() {
        List<Turist> turistList = jdbcTemplate.query(TuristQueries.GET_TURISTI_SQL, new BeanPropertyRowMapper<>(Turist.class));
        logger.info("Turistii sunt preluati din repo {}", turistList);
        return turistList;
    }

    public Turist addTurist(Turist turist) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(TuristQueries.ADD_TURIST_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, turist.getNume());
            ps.setString(2, turist.getPrenume());
            ps.setDate(3, new java.sql.Date(turist.getDataNasterii().getTime()));
            return ps;
        }, holder);
        turist.setIdTurist(holder.getKey().intValue());
        logger.info("S-a adaugat turistul {}", turist);
        return turist;
    }

    public Turist updateTurist(Turist turist) {
        List<Turist> findTuristList = jdbcTemplate.query(TuristQueries.FIND_TURIST_BYID_SQL, new BeanPropertyRowMapper<>(Turist.class), turist.getIdTurist());
        if (findTuristList.isEmpty()) {
            throw new ObjectNotFoundException("Nu exista niciun turist cu acest id!");
        }
        logger.info("S-a updatat turistul {}", turist);
        jdbcTemplate.update(TuristQueries.UPDATE_TURIST_SQL, turist.getNume(), turist.getPrenume(), turist.getDataNasterii(), turist.getIdTurist());
        return turist;
    }

    public List<Turist> deleteTurist(int id) {
        List<Turist> findTuristList = jdbcTemplate.query(TuristQueries.FIND_TURIST_BYID_SQL, new BeanPropertyRowMapper<>(Turist.class), id);
        if (findTuristList.isEmpty()) {
            throw new ObjectNotFoundException("Nu exista niciun turist cu acest id!");
        }
        logger.info("S-a sters turistul cu id-ul", id);
        int number = jdbcTemplate.update(TuristQueries.DELETE_TURIST_SQL, id);
        return findTuristList;
    }

    public List<Turist> getTuristByFirstName(String  nume) {
        List<Turist> findTuristList = jdbcTemplate.query(TuristQueries.GET_TURIST_BYFIRSTNAME_SQL, new BeanPropertyRowMapper<>(Turist.class), nume);
        if (findTuristList.isEmpty()) {
            throw new ObjectNotFoundException("Nu exista turisti cu acest nume!");
        }
        logger.info("Sunt preluati turistii cu numele", nume);
        return findTuristList;
    }

    public List<Turist> orderTuristByName(String type) {
        List<Turist> turistList = (type.equals("asc")) ? jdbcTemplate.query(TuristQueries.ORDER_TURIST_ASC_SQL, new BeanPropertyRowMapper<>(Turist.class))
                                                : jdbcTemplate.query(TuristQueries.ORDER_TURIST_DESC_SQL, new BeanPropertyRowMapper<>(Turist.class));
        logger.info("Sunt preluati din repo turistii ordonati " + type + " dupa nume {}", turistList);
        return turistList;
    }
}
