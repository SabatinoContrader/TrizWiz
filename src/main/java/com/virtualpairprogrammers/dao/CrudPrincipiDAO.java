package com.virtualpairprogrammers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.model.Principio;
import javax.servlet.http.HttpServletRequest;


public class CrudPrincipiDAO {
	
	String campo = "";
	
	//private final String QUERY_ALL = "SELECT * FROM sympthom";

    private final String QUERY_principio = "select * from principi";
	private final String QUERY_INSERT = "INSERT INTO principi (nomePrincipio,nomePrincipioIta,domande,steps,esempi) VALUES (?,?,?,?,?)";
	private final String QUERY_DELETE = "delete from principi where id = ?";
	
	
	public CrudPrincipiDAO() {		
	}
	
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
	
	public boolean insertPrincipio(Principio Principio) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			//id da togliere
			//preparedStatement.setInt(1, Principio.getId());
			preparedStatement.setString(1, Principio.getNomePrincipio());
            preparedStatement.setString(2, Principio.getNomePrincipioIta());
            preparedStatement.setString(3, Principio.getDomande());
            preparedStatement.setString(4, Principio.getSteps());
            preparedStatement.setString(5, Principio.getEsempi());
            preparedStatement.execute();
            return true;
		}
		catch (SQLException e){
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}		
		
	}

	public boolean updatePrincipi(Principio Principio) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			//simile all'insert
			//campo=(String)request.get("campo");
        	PreparedStatement preparedStatement = connection.prepareStatement("update principi set nomePrincipio =?, nomePrincipioIta=?, domande=? , steps=?, esempi=?  where id =?");

			preparedStatement.setInt(6, Principio.getId());
			preparedStatement.setString(1, Principio.getNomePrincipio());
            preparedStatement.setString(2, Principio.getNomePrincipioIta());
            preparedStatement.setString(3, Principio.getDomande());
            preparedStatement.setString(4, Principio.getSteps());
            preparedStatement.setString(5, Principio.getEsempi());
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
	
	public boolean deletePrincipio(int id) {
    	Connection connection = ConnectionSingleton.getInstance();
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            return true;
    }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }	
    }

	
				
	}

