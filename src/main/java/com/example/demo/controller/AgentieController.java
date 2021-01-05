package com.example.demo.controller;


import com.example.demo.model.Agentie;
import com.example.demo.service.AgentieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/agentie")
public class AgentieController {

    @Autowired
    private AgentieService agentieService;

    @GetMapping("/get")
    public ResponseEntity<List<Agentie>> getAgentii() {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                        .body(agentieService.getAgentii());
    }

    @PostMapping("/add")
    public ResponseEntity<Agentie> addAgentie(@RequestBody @Valid Agentie agentie) {
        return ResponseEntity.created(UriComponentsBuilder.
                fromHttpUrl(ServletUriComponentsBuilder.
                        fromCurrentRequestUri().
                        toUriString())
                .path("").query("denumire={denumire}").build(agentie.getDenumire()))
                .body(agentieService.addAgentie(agentie));
    }

    @PutMapping("/update")
    public ResponseEntity<Agentie> updateAgentie(@RequestBody @Valid Agentie agentie) {
        return  ResponseEntity.status(HttpStatus.OK)
                .body(agentieService.updateAgentie(agentie));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<List<Agentie>> deleteAgentie(@RequestParam int id) {
        return  ResponseEntity.status(HttpStatus.OK)
                .body(agentieService.deleteAgentie(id));
    }
}
