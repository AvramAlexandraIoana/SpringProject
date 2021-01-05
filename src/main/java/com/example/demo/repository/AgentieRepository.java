package com.example.demo.repository;


import com.example.demo.model.Agentie;
import com.example.demo.model.Locatie;
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
import java.util.List;

@Repository
public class AgentieRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(AgentieRepository.class);

    public List<Agentie> getAgentii() {
        List<Agentie> agentii = jdbcTemplate.query(AgentieQueries.GET_AGENTII_SQL, new BeanPropertyRowMapper<>(Agentie.class));
        logger.info("Agentiile sunt preluate din repo {}", agentii);
        return agentii;
    }

    public Agentie addAgentie(Agentie agentie) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(AgentieQueries.ADD_AGENTIE_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, agentie.getDenumire());
            ps.setInt(2, agentie.getIdLocatie());
            return ps;
        }, holder);
        agentie.setIdAgentie(holder.getKey().intValue());
        logger.info("S-a adaugat agentia {}", agentie);
        return agentie;
    }

    public Agentie updateAgentie(Agentie agentie) {
        List<Agentie> findAgentii = jdbcTemplate.query(AgentieQueries.FIND_AGENTIE_BYID_SQL, new BeanPropertyRowMapper<>(Agentie.class), agentie.getIdAgentie());
        if (findAgentii.isEmpty()) {
            throw new ObjectNotFoundException("Nu exista nicio locatie cu acest id!");
        }
        logger.info("S-a updatat agentia  {}", agentie);
        jdbcTemplate.update(AgentieQueries.UPDATE_AGENTIE_SQL, agentie.getDenumire(), agentie.getIdLocatie(), agentie.getIdAgentie());
        return agentie;
    }

    public List<Agentie> deleteAgentie(int id) {
        List<Agentie> findAgentii = jdbcTemplate.query(AgentieQueries.FIND_AGENTIE_BYID_SQL, new BeanPropertyRowMapper<>(Agentie.class), id);
        if (findAgentii.isEmpty()) {
            throw new ObjectNotFoundException("Nu exista nicio locatie cu acest id!");
        }
        logger.info("S-a sters agentia cu id-ul", id);
        int number = jdbcTemplate.update(LocatieQueries.DELETE_LOCATIE_SQL, id);
        return findAgentii;
    }
}
