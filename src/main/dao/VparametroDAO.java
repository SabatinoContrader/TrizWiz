package main.dao;

import main.ConnectionSingleton;
import main.model.Parametro;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VparametroDAO {
	public VparametroDAO(){}

    private final String QUERY_parametro = "select * from parametri";
    private final String QUERY_parametroId = "select * from parametri where id=?";
    
	public List<Parametro> getAllParametro() {
	    List<Parametro>  listParametro= new ArrayList<Parametro>();
        Connection connection = ConnectionSingleton.getInstance();
       
		try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_parametro);
           while (resultSet.next()) {
        	   Parametro newParametro=new Parametro();
        	   newParametro.setNomeParametro(resultSet.getString("nomeParametro"));
        	   newParametro.setDescrizione(resultSet.getString("descrizione"));
        	   newParametro.setDescrizioneIta(resultSet.getString("descrizioneIta"));
        	   newParametro.setId(resultSet.getInt("id"));
        	   newParametro.setNomeParametroIta(resultSet.getString("nomeParametroIta"));
        	   newParametro.setIcona(resultSet.getString("icona"));
        	   listParametro.add(newParametro);
           	}
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
		
		return listParametro;
    }
	
	public Parametro getParametroID (String id) {
		
		List<Parametro>  listParametro= new ArrayList<Parametro>();
		Parametro newParametro = new Parametro();
	    Connection connection = ConnectionSingleton.getInstance();
	    try {
	        PreparedStatement statement = connection.prepareStatement(QUERY_parametroId);
	        //ResultSet resultSet = statement.executeQuery(QUERY_MATRIX);
	        statement.setString(1, id);
	        //statement.setString(2, param2);
	        ResultSet resultSet = statement.executeQuery();
		  // ResultSet resultSet = statement.executeQuery(QUERY_parametroId);
	        while (resultSet.next()) {
			   newParametro.setNomeParametro(resultSet.getString("nomeParametro"));
	    	   newParametro.setDescrizione(resultSet.getString("descrizione"));
	    	   newParametro.setDescrizioneIta(resultSet.getString("descrizioneIta"));
	    	   newParametro.setId(resultSet.getInt("id"));
	    	   newParametro.setNomeParametroIta(resultSet.getString("nomeParametroIta"));
	    	   newParametro.setIcona(resultSet.getString("icona"));
		   }
		   
		   
		}
		
		 catch (SQLException e) {
	         e.printStackTrace();
	     }
			return newParametro;
	}
	
	}