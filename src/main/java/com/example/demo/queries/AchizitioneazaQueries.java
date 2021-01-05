package com.example.demo.queries;

public class AchizitioneazaQueries {
    public final static String GET_ACHIZITI_SQL = "SELECT * FROM achizitioneaza";
    public final static String ADD_ACHIZITONEAZA_SQL = "INSERT INTO achizitioneaza(codTurist, codExcursie, dataStart, dataEnd, dataAchizitie, discount) " +
                                                        "values(?, ?, ?, ?, ?, ?)";
    public final static String UPDATE_ACHIZITONEAZA_SQL = "UPDATE achizitioneaza SET dataStart = ?, dataEnd = ?, " +
                                                    "dataAchizitie = ?, discount = ? WHERE codTurist = ? AND codExcursie = ?";
    public final static String DELETE_ACHIZITONEAZA_SQL = "DELETE FROM achizitioneaza WHERE codTurist = ? AND codExcursie = ?";
    public final static String FIND_ACHIZITONEAZA_BYIDS_SQL = "SELECT * FROM achizitioneaza WHERE codTurist = ? AND codExcursie = ?";
}
