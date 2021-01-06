package com.example.demo.service;

import com.example.demo.model.Turist;
import com.example.demo.queries.TuristQueries;
import com.example.demo.repository.TuristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuristService {

    @Autowired
    private TuristRepository turistRepository;

    public List<Turist> getTuristi() {

        return turistRepository.getTuristi();
    }

    public Turist addTurist(Turist turist) {
        return turistRepository.addTurist(turist);
    }

    public Turist updateTurist(Turist turist) {
        return turistRepository.updateTurist(turist);
    }

    public List<Turist> deleteTurist(int id) {
        return turistRepository.deleteTurist(id);
    }

    public List<Turist> getTuristByFirstName(String  nume) {
        return turistRepository.getTuristByFirstName(nume);
    }

    public List<Turist> orderTuristByName(String type) {
        return turistRepository.orderTuristByName(type);
    }
}
