package com.example.demo.model;

import javax.validation.constraints.NotNull;

public class Locatie {
    private int idLocatie;

    @NotNull(message = "Adresa nu poate fi null!")
    private String adresa;

    @NotNull(message = "Orasul nu poate fi null!")
    private String oras;

    public Locatie() {
    }

    public Locatie(int idLocatie, String adresa, String oras) {
        this.idLocatie = idLocatie;
        this.adresa = adresa;
        this.oras = oras;
    }

    public int getIdLocatie() {
        return idLocatie;
    }

    public void setIdLocatie(int idLocatie) {
        this.idLocatie = idLocatie;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    @Override
    public String toString() {
        return "Locatie{" +
                "idLocatie=" + idLocatie +
                ", adresa='" + adresa + '\'' +
                ", oras='" + oras + '\'' +
                '}';
    }
}
