package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

public class Achizitioneaza {

    @Range(min = 1, message= "Id-ul turistului nu poate fi null!")
    private int codTurist;

    @Range(min = 1, message= "Id-ul excursiei nu poate fi null!")
    private int codExcursie;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataStart;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataEnd;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataAchizitie;

    @Range(min = 0, message= "Discount-ul trebuie sa fie mai mare decat 0!")
    private Double discount;

    public Achizitioneaza() {
    }

    public Achizitioneaza(int codTurist, int codExcursie, Date dataStart, Date dataEnd, Date dataAchizitie, Double discount) {
        this.codTurist = codTurist;
        this.codExcursie = codExcursie;
        this.dataStart = dataStart;
        this.dataEnd = dataEnd;
        this.dataAchizitie = dataAchizitie;
        this.discount = discount;
    }

    public int getCodTurist() {
        return codTurist;
    }

    public void setCodTurist(int codTurist) {
        this.codTurist = codTurist;
    }

    public int getCodExcursie() {
        return codExcursie;
    }

    public void setCodExcursie(int codExcursie) {
        this.codExcursie = codExcursie;
    }

    public Date getDataStart() {
        return dataStart;
    }

    public void setDataStart(Date dataStart) {
        this.dataStart = dataStart;
    }

    public Date getDataEnd() {
        return dataEnd;
    }

    public void setDataEnd(Date dataEnd) {
        this.dataEnd = dataEnd;
    }

    public Date getDataAchizitie() {
        return dataAchizitie;
    }

    public void setDataAchizitie(Date dataAchizitie) {
        this.dataAchizitie = dataAchizitie;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Achizitioneaza{" +
                "codTurist=" + codTurist +
                ", codExcursie=" + codExcursie +
                ", dataStart=" + dataStart +
                ", dataEnd=" + dataEnd +
                ", dataAchizitie=" + dataAchizitie +
                ", discount=" + discount +
                '}';
    }
}
