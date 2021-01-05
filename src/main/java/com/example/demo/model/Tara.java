package com.example.demo.model;

public class Tara {
    private int idTara;
    private String nume;


    public Tara() {
    }

    public Tara(int idTara, String nume) {
        this.idTara = idTara;
        this.nume = nume;
    }

    public int getIdTara() {
        return idTara;
    }

    public void setIdTara(int idTara) {
        this.idTara = idTara;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "Tara{" +
                "idTara=" + idTara +
                ", nume='" + nume + '\'' +
                '}';
    }
}
