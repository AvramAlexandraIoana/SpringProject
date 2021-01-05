package com.example.demo.model;

public class Excursie {
    private int idExcursie;
    private String denumire;
    private Double pret;
    private int durata;
    private int nrLocuri;
    private int codAgentie;
    private int codLocatie;

    public Excursie() {
    }

    public Excursie(int idExcursie, String denumire, Double pret, int durata, int nrLocuri, int codAgentie, int codLocatie) {
        this.idExcursie = idExcursie;
        this.denumire = denumire;
        this.pret = pret;
        this.durata = durata;
        this.nrLocuri = nrLocuri;
        this.codAgentie = codAgentie;
        this.codLocatie = codLocatie;
    }

    public int getIdExcursie() {
        return idExcursie;
    }

    public void setIdExcursie(int idExcursie) {
        this.idExcursie = idExcursie;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    public int getCodAgentie() {
        return codAgentie;
    }

    public void setCodAgentie(int codAgentie) {
        this.codAgentie = codAgentie;
    }

    public int getCodLocatie() {
        return codLocatie;
    }

    public void setCodLocatie(int codLocatie) {
        this.codLocatie = codLocatie;
    }

    @Override
    public String toString() {
        return "Excursie{" +
                "idExcursie=" + idExcursie +
                ", denumire='" + denumire + '\'' +
                ", pret=" + pret +
                ", durata=" + durata +
                ", nrLocuri=" + nrLocuri +
                ", codAgentie=" + codAgentie +
                ", codLocatie=" + codLocatie +
                '}';
    }
}
