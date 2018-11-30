package main.dao;

import main.ConnectionSingleton;
import main.model.Principio;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VprincipioDAO {
	public VprincipioDAO(){}

    private final String QUERY_principio = "select * from principi";
    
	public List<Principio> getAllPrincipio() {
	    List<Principio>  listPrincipio= new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
       
		try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_principio);
           while (resultSet.next()) {
        	   Principio newPrincipio=new Principio();
        	   newPrincipio.setNomePrincipio(resultSet.getString("nomePrincipio"));
        	   newPrincipio.setDomande(resultSet.getString("domande"));
        	   newPrincipio.setEsempi(resultSet.getString("esempi"));
        	   newPrincipio.setId(resultSet.getInt("id"));
        	   newPrincipio.setNomePrincipioIta(resultSet.getString("nomePrincipioIta"));
        	   newPrincipio.setSteps(resultSet.getString("steps"));
        	   listPrincipio.add(newPrincipio);
           	}
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
		
		return listPrincipio;
    }


	


	
	}
    
    


