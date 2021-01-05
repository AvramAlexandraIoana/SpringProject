package com.example.demo.queries;

public class LocatieQueries {
    public final static String GET_LOCATII_SQL = "SELECT * FROM locatie";
    public final static String ADD_LOCATIE_SQL = "INSERT INTO locatie(idLocatie, adresa, oras) values(null, ?, ?)";
    public final static String UPDATE_LOCATIE_SQL = "UPDATE locatie SET adresa = ?, oras = ? WHERE idLocatie = ?";
    public final static String DELETE_LOCATIE_SQL = "DELETE FROM locatie WHERE idLocatie = ?";
    public final static String FIND_LOCATIE_BYID_SQL = "SELECT * FROM locatie WHERE idLocatie = ?";
}
