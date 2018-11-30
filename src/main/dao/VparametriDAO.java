package main.dao;

import main.ConnectionSingleton;
import main.model.Parametri;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VparametriDAO {

    private final String QUERY_par = "select * from parametri";
    
	public List<Parametri> getAllParametri() {
	    List<Parametri>  listParametri= new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
       
		try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_par);
           while (resultSet.next()) {
        	   //creo l'oggetto parametri
        	   int id = resultSet.getInt("id");
        	   String nomeParametro = resultSet.getString("nomeParametro");
        	   String descrizione= resultSet.getString("descrizione");
        	   String nomeParametroIta= resultSet.getString("nomeParametroIta");
        	   String descrizioneIta= resultSet.getString("descrizioneIta");
        	   String icona= resultSet.getString("icona");
        	   listParametri.addAll((Collection<? extends Parametri>) new Parametri(id,nomeParametro,descrizione,nomeParametroIta,descrizioneIta,icona));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
		
		return listParametri;
    }


	


	
	}
    
    


