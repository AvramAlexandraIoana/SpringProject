package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Turist {
    private int idTurist;

    @NotNull(message = "Numele nu poate fi null!")
    private String nume;

    @NotNull(message = "Prenumele nu poate fi null!")
    private String prenume;

    @NotNull(message = "Data nasterii nu poate fi null!")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataNasterii;

    public Turist() {
    }

    public Turist(int idTurist, String nume, String prenume, Date dataNasterii) {
        this.idTurist = idTurist;
        this.nume = nume;
        this.prenume = prenume;
        this.dataNasterii = dataNasterii;
    }

    public int getIdTurist() {
        return idTurist;
    }

    public void setIdTurist(int idTurist) {
        this.idTurist = idTurist;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Date getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(Date dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    @Override
    public String toString() {
        return "Turist{" +
                "idTurist=" + idTurist +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", dataNasterii=" + dataNasterii +
                '}';
    }
}
