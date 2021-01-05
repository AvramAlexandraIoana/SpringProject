package com.example.demo.queries;

public class TaraQueries {
    public final static String GET_TARI_SQL = "SELECT * FROM tara";
    public final static String ADD_TARA_SQL = "INSERT INTO tara(idTara, nume) values(null, ?)";
    public final static String UPDATE_TARA_SQL = "UPDATE tara SET nume = ?  WHERE idTara = ?";
    public final static String DELETE_TARA_SQL = "DELETE FROM tara WHERE idTara = ?";
    public final static String FIND_TARA_BYID_SQL = "SELECT * FROM tara WHERE idTara = ?";
}
