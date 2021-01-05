package com.example.demo.service;


import com.example.demo.model.Tara;
import com.example.demo.repository.TaraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaraService {

    @Autowired
    private TaraRepository taraRepository;


    public List<Tara> getTari() {
        return taraRepository.getTari();
    }

    public Tara addTara(Tara tara) {
        return taraRepository.addTara(tara);
    }

    public Tara updateTara(Tara tara) {
        return taraRepository.updateTara(tara);
    }

    public List<Tara> deleteTara(int id) {
        return taraRepository.deleteTara(id);
    }
}
