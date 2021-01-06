package com.example.demo.queries;

public class TuristQueries {
    public final static String GET_TURISTI_SQL = "SELECT * FROM turist";
    public final static String ADD_TURIST_SQL = "INSERT INTO turist(idTurist, nume, prenume, dataNasterii) values(null, ?, ?, ?)";
    public final static String UPDATE_TURIST_SQL = "UPDATE turist SET nume = ?, prenume = ?, dataNasterii = ? WHERE idTurist = ?";
    public final static String DELETE_TURIST_SQL = "DELETE FROM turist WHERE idTurist = ?";
    public final static String GET_TURIST_BYFIRSTNAME_SQL = "SELECT * FROM turist WHERE nume = ?";
    public final static String FIND_TURIST_BYID_SQL = "SELECT * FROM turist WHERE idTurist = ?";
    public final static String ORDER_TURIST_ASC_SQL = "SELECT * FROM turist ORDER BY nume ASC";
    public final static String ORDER_TURIST_DESC_SQL = "SELECT * FROM turist ORDER BY nume DESC";


}
