package com.example.demo.service;

import com.example.demo.model.Locatie;
import com.example.demo.repository.LocatieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocatieService {

    @Autowired
    private LocatieRepository locatieRepository;

    public List<Locatie> getLocatii() {
        return locatieRepository.getLocatii();
    }

    public Locatie addLocatie(Locatie locatie) {
        return locatieRepository.addLocatie(locatie);
    }

    public Locatie updateLocatie(Locatie locatie) {
        return locatieRepository.updateLocatie(locatie);
    }

    public List<Locatie> deleteLocatie(int id) {
        return locatieRepository.deleteLocatie(id);
    }
}
