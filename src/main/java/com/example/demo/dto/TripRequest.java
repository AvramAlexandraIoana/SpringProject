package com.example.demo.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TripRequest {
    @NotBlank(message = "Numele nu poate fi gol!")
    @NotNull(message = "Numele nu poate fi null!")
    private String name;

    @NotNull(message = "Price nu poate fi null!")
    @Range(min = 1, message= "Pretul trebuie sa fie mai mare decat 0!")
    private Double price;

    @NotNull(message = "Numarul de locuri  nu poate fi null!")
    @Range(min = 1, message= "Numarul de locuri trebuie sa fie mai mare decat 0!")
    private int numberOfSeats;

    @NotNull(message = "Durata nu poate fi null!")
    @Range(min = 1, message= "Durata trebuie sa fie mai mare decat 0!")
    private int duration;

    @NotNull(message = "Id-ul agentiei nu poate fi null!")
    @Range(min = 1, message= "Id-ul agentiei trebuie sa fie mai mare decat 0!")
    private int agencyId;

    @NotNull(message = "Id-ul locatiei nu poate fi null!")
    @Range(min = 1, message= "Id-ul locatiei trebuie sa fie mai mare decat 0!")
    private int locationId;

    public TripRequest() {
    }

    public TripRequest(String name,  int numberOfSeats, int duration, int agencyId, int locationId) {
        this.name = name;
        this.price = price;
        this.numberOfSeats = numberOfSeats;
        this.duration = duration;
        this.agencyId = agencyId;
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "TripRequest{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", numberOfSeats=" + numberOfSeats +
                ", duration=" + duration +
                ", agencyId=" + agencyId +
                ", locationId=" + locationId +
                '}';
    }
}
