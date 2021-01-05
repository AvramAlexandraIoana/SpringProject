package com.example.demo.service;

import com.example.demo.model.Excursie;
import com.example.demo.repository.ExcursieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExcursieService {

    @Autowired
    private ExcursieRepository excursieRepository;

    public List<Excursie> getExcursii() {
        return excursieRepository.getExcursii();
    }

    public Excursie addExcursie(Excursie excursie) {
        return excursieRepository.addExcursie(excursie);
    }

    public Excursie updateExcursie(Excursie excursie) {
        return excursieRepository.updateExcursie(excursie);
    }

    public List<Excursie> deleteExcursie(int id) {
        return excursieRepository.deleteExcursie(id);
    }
}
