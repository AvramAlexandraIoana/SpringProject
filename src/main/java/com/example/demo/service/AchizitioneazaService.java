package com.example.demo.service;

import com.example.demo.model.Achizitioneaza;
import com.example.demo.repository.AchizitioneazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AchizitioneazaService {

    @Autowired
    private AchizitioneazaRepository achizitioneazaRepository;

    public List<Achizitioneaza> getAchizitii() {
        return achizitioneazaRepository.getAchizitii();
    }

    public Achizitioneaza addAchizitie(Achizitioneaza achizitioneaza) {
        achizitioneaza.setDataAchizitie(new Date());
        return achizitioneazaRepository.addAchizitie(achizitioneaza);
    }

    public Achizitioneaza updateAchizitie(Achizitioneaza achizitioneaza) {
        return  achizitioneazaRepository.updateAchizitie(achizitioneaza);
    }

    public List<Achizitioneaza> deleteAchizitie(int idTurist, int idExcursie) {
        return achizitioneazaRepository.deleteAchizitie(idTurist, idExcursie);
    }

}
