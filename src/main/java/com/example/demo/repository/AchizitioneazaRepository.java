package com.example.demo.repository;


import com.example.demo.model.Achizitioneaza;
import com.example.demo.model.Agentie;
import com.example.demo.queries.AchizitioneazaQueries;
import com.example.demo.queries.AgentieQueries;
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
import java.util.Date;
import java.util.List;

@Repository
public class AchizitioneazaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(AchizitioneazaRepository.class);

    public List<Achizitioneaza> getAchizitii() {
        List<Achizitioneaza> achizitioneazaList = jdbcTemplate.query(AchizitioneazaQueries.GET_ACHIZITI_SQL, new BeanPropertyRowMapper<>(Achizitioneaza.class));
        logger.info("Achizitiile sunt preluate din repo {}", achizitioneazaList);
        return achizitioneazaList;
    }

    public Achizitioneaza addAchizitie(Achizitioneaza achizitioneaza) {
        jdbcTemplate.update(AchizitioneazaQueries.ADD_ACHIZITONEAZA_SQL, achizitioneaza.getCodTurist(), achizitioneaza.getCodExcursie(),
                            achizitioneaza.getDataStart(), achizitioneaza.getDataEnd(), achizitioneaza.getDataAchizitie(), achizitioneaza.getDiscount());
        logger.info("S-a adaugat achizitia {}", achizitioneaza);
        return achizitioneaza;
    }

    public Achizitioneaza updateAchizitie(Achizitioneaza achizitioneaza) {
        List<Achizitioneaza> achizitioneazaList = jdbcTemplate.query(AchizitioneazaQueries.FIND_ACHIZITONEAZA_BYIDS_SQL, new BeanPropertyRowMapper<>(Achizitioneaza.class),
                                                    achizitioneaza.getCodTurist(), achizitioneaza.getCodExcursie());
        if (achizitioneazaList.isEmpty()) {
            throw new ObjectNotFoundException("Nu exista nicio achizitie cu aceste id-uri!");
        }
        logger.info("S-a updatat achizitia  {}", achizitioneaza);
        jdbcTemplate.update(AchizitioneazaQueries.UPDATE_ACHIZITONEAZA_SQL, achizitioneaza.getDataStart(), achizitioneaza.getDataEnd(), achizitioneaza.getDataAchizitie(), achizitioneaza.getDiscount(),
                                                    achizitioneaza.getCodTurist(), achizitioneaza.getCodExcursie());
        return achizitioneaza;
    }

    public List<Achizitioneaza> deleteAchizitie(int idTurist, int idExcursie) {
        List<Achizitioneaza> achizitioneazaList = jdbcTemplate.query(AchizitioneazaQueries.FIND_ACHIZITONEAZA_BYIDS_SQL, new BeanPropertyRowMapper<>(Achizitioneaza.class), idTurist, idExcursie);
        if (achizitioneazaList.isEmpty()) {
            throw new ObjectNotFoundException("Nu exista nicio achizitie cu aceste id-uri!");
        }
        logger.info("S-a sters achizitia cu id-urile", idTurist, idExcursie);
        int number = jdbcTemplate.update(AchizitioneazaQueries.DELETE_ACHIZITONEAZA_SQL, idTurist, idExcursie);
        return achizitioneazaList;
    }
}
