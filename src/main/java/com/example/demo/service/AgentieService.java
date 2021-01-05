package com.example.demo.service;


import com.example.demo.model.Agentie;
import com.example.demo.repository.AgentieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentieService {

    @Autowired
    private AgentieRepository agentieRepository;

    public List<Agentie> getAgentii() {
        return agentieRepository.getAgentii();
    }

    public Agentie addAgentie(Agentie agentie) {
        return agentieRepository.addAgentie(agentie);
    }

    public Agentie updateAgentie(Agentie agentie) {
        return agentieRepository.updateAgentie(agentie);
    }

    public List<Agentie> deleteAgentie(int id) {
        return agentieRepository.deleteAgentie(id);
    }
}
