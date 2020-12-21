package com.example.demo.queries;

public class TouristQueries {

    public final static String GET_TOURIST_SQL = "SELECT * FROM tourists";
    public final static String ADD_TOURIST_SQL = "INSERT INTO tourists(touristId, firstName, lastName, dateOfBirth, createdOn) values(null, ?, ?, ?, ?)";
    public final static String DELETE_TOURIST_SQL = "DELETE FROM tourists WHERE touristId = ?";
    public final static String GET_TOURIST_BYFIRSTNAME_SQL = "SELECT * FROM tourists WHERE firstName = ?";

}
