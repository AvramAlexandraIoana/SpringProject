package com.example.demo.queries;

public class AgentieQueries {
    public final static String GET_AGENTII_SQL = "SELECT * FROM agentie";
    public final static String ADD_AGENTIE_SQL = "INSERT INTO agentie(idAgentie, denumire, idLocatie) values(null, ?, ?)";
    public final static String UPDATE_AGENTIE_SQL = "UPDATE agentie SET denumire = ?, codLocatie = ? WHERE idAgentie = ?";
    public final static String DELETE_AGENTIE_SQL = "DELETE FROM agentie WHERE idAgentie = ?";
    public final static String FIND_AGENTIE_BYID_SQL = "SELECT * FROM agentie WHERE idAgentie = ?";
}
