package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.model.Principio;
import javax.servlet.http.HttpServletRequest;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VprincipioDAO {
	public VprincipioDAO(){}

    private final String QUERY_principio = "select * from principi";
    private final String QUERY_principioId = "select * from principi where id=?";
    
	public List<Principio> getAllPrincipio() {
	    List<Principio>  listPrincipio= new ArrayList<Principio>();
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

	public Principio getPrincipioID (String id) {
		
		List<Principio>  listPrincipio= new ArrayList<Principio>();
		Principio newPrincipio = new Principio();
	    Connection connection = ConnectionSingleton.getInstance();
	    try {
	        PreparedStatement statement = connection.prepareStatement(QUERY_principioId);
	        //ResultSet resultSet = statement.executeQuery(QUERY_MATRIX);
	        statement.setString(1, id);
	        //statement.setString(2, param2);
	        ResultSet resultSet = statement.executeQuery();
		  // ResultSet resultSet = statement.executeQuery(QUERY_parametroId);
	        while (resultSet.next()) {
			   newPrincipio.setNomePrincipio(resultSet.getString("nomePrincipio"));
	    	   newPrincipio.setNomePrincipioIta(resultSet.getString("nomePrincipioIta"));
	    	   newPrincipio.setDomande(resultSet.getString("domande"));
	    	   newPrincipio.setId(resultSet.getInt("id"));
	    	   newPrincipio.setSteps(resultSet.getString("steps"));
	    	   newPrincipio.setEsempi(resultSet.getString("esempi"));
		   }
		   
		   
		}
		
		 catch (SQLException e) {
	         e.printStackTrace();
	     }
			return newPrincipio;
	}
	


	
	}
    
    


