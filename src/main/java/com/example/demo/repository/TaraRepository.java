package com.example.demo.repository;

import com.example.demo.model.Locatie;
import com.example.demo.model.Tara;
import com.example.demo.queries.LocatieQueries;
import com.example.demo.queries.TaraQueries;
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
public class TaraRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(TaraRepository.class);

    public List<Tara> getTari() {
        List<Tara> tari = jdbcTemplate.query(TaraQueries.GET_TARI_SQL, new BeanPropertyRowMapper<>(Tara.class));
        logger.info("Tarile sunt preluate din repo {}", tari);
        return tari;
    }

    public Tara addTara(Tara tara) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(TaraQueries.ADD_TARA_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tara.getNume());
            return ps;
        }, holder);
        tara.setIdTara(holder.getKey().intValue());
        logger.info("S-a adaugat tara {}", tara);
        return tara;
    }

    public Tara updateTara(Tara tara) {
        List<Tara> findTari = jdbcTemplate.query(TaraQueries.FIND_TARA_BYID_SQL, new BeanPropertyRowMapper<>(Tara.class), tara.getIdTara());
        if (findTari.isEmpty()) {
            throw new ObjectNotFoundException("Nu exista nicio tara cu acest id!");
        }
        logger.info("S-a updatat tara  {}", tara);
        jdbcTemplate.update(TaraQueries.UPDATE_TARA_SQL, tara.getNume(), tara.getIdTara());
        return tara;
    }

    public List<Tara> deleteTara(int id) {
        List<Tara> findTari = jdbcTemplate.query(TaraQueries.FIND_TARA_BYID_SQL, new BeanPropertyRowMapper<>(Tara.class), id);
        if (findTari.isEmpty()) {
            throw new ObjectNotFoundException("Nu exista nicio tara cu acest id!");
        }
        logger.info("S-a sters tara cu id-ul", id);
        int number = jdbcTemplate.update(TaraQueries.DELETE_TARA_SQL, id);
        return findTari;
    }
}
