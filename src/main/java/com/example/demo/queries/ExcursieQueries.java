package com.example.demo.queries;

public class ExcursieQueries {
    public final static String GET_EXCURSII_SQL = "SELECT * FROM excursie";
    public final static String ADD_EXCURSIE_SQL = "INSERT INTO excursie(idExcursie, denumire, pret, durata, nrLocuri, codAgentie, codLocatie) " +
                                                     "values(null, ?, ?, ?, ?, ?, ?)";
    public final static String UPDATE_EXCURSIE_SQL = "UPDATE excursie SET denumire = ?, pret = ?, durata = ?, nrLocuri = ?, " +
            "codAgentie = ?, codLocatie = ? WHERE idExcursie = ?";
    public final static String DELETE_EXCRUSIE_SQL = "DELETE FROM excursie WHERE idExcursie = ?";
    public final static String FIND_EXCURSIE_BYID_SQL = "SELECT * FROM excursie WHERE idExcursie = ?";
}
