package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.model.Parametro;
import com.virtualpairprogrammers.model.Principio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class VparametroDAO {
	public VparametroDAO(){}

    private final String QUERY_parametro = "select * from parametri";
    private final String QUERY_parametroId = "select * from parametri where id=?";
    private final String QUERY_DELETE="DELETE from parametri where id = ?";
    private final String QUERY_INSERT = "INSERT INTO parametri (nomeParametro,descrizione,nomeParametroIta,descrizioneIta,icona) VALUES (?,?,?,?,?)";
    
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
	
	public boolean updateParametri(Parametro Parametro) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			//simile all'insert
			//campo=(String)request.get("campo");
        	PreparedStatement preparedStatement = connection.prepareStatement("update parametri set nomeParametro =?, nomeParametroIta=?, descrizione=?, descrizioneIta=?, icona=?  where id =?");

			preparedStatement.setInt(6, Parametro.getId());
			preparedStatement.setString(1, Parametro.getNomeParametro());
            preparedStatement.setString(2, Parametro.getNomeParametroIta());
            preparedStatement.setString(3, Parametro.getDescrizione());
            preparedStatement.setString(4, Parametro.getDescrizioneIta());
            preparedStatement.setString(5, Parametro.getIcona());
        	//preparedStatement.setString(1, (String)request.get("nomePrincipio"));
            //preparedStatement.setInt(2, (Integer)request.get("id"));
            preparedStatement.execute();
            return true;
		}
		catch(SQLException e){
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}	
	}
	
	
	public boolean deleteParametro (int idParametro) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
		
			preparedStatement.setInt(1,idParametro);
			preparedStatement.execute();
			return true;
		}
			catch (SQLException e){
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
			}
	}

	public boolean insertParametro(Parametro parametro) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			//preparedStatement.setInt(1, Principio.getId());
			preparedStatement.setString(1, parametro.getNomeParametro());
            preparedStatement.setString(2, parametro.getDescrizione());
            preparedStatement.setString(3, parametro.getNomeParametroIta());
            preparedStatement.setString(4, parametro.getDescrizioneIta());
            preparedStatement.setString(5, parametro.getIcona());
            preparedStatement.execute();
            return true;
		}
		catch (SQLException e){
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}		
		
	}
	
	}