package com.example.demo.model;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Agentie {
    private int idAgentie;

    @NotNull(message = "Denumirea nu poate fi null!")
    private String denumire;

    @Range(min = 1, message= "Id-ul locatiei nu poate fi null!")
    private int idLocatie;

    public Agentie() {
    }

    public Agentie(int idAgentie, String denumire, int idLocatie) {
        this.idAgentie = idAgentie;
        this.denumire = denumire;
        this.idLocatie = idLocatie;
    }

    public int getIdAgentie() {
        return idAgentie;
    }

    public void setIdAgentie(int idAgentie) {
        this.idAgentie = idAgentie;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getIdLocatie() {
        return idLocatie;
    }

    public void setIdLocatie(int idLocatie) {
        this.idLocatie = idLocatie;
    }

    @Override
    public String toString() {
        return "Agentie{" +
                "idAgentie=" + idAgentie +
                ", denumire='" + denumire + '\'' +
                ", idLocatie=" + idLocatie +
                '}';
    }
}
