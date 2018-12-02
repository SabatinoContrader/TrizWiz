package main.dao;

import main.ConnectionSingleton;
import main.model.Parametro;
import main.model.Principio;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VparametroDAO {
	public VparametroDAO(){}

    private final String QUERY_parametro = "select * from parametri";
    
	public List<Parametro> getAllParametro() {
	    List<Parametro>  listParametro= new ArrayList<>();
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


	


	
	}