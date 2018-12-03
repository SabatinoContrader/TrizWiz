package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.controller.Request;
import main.model.Principio;


public class CrudPrincipiDAO {
	
	String campo = "";
	
	//private final String QUERY_ALL = "SELECT * FROM sympthom";
	private final String QUERY_INSERT = "INSERT INTO principi (nomePrincipio,nomePrincipioIta,domande,steps,esempi) VALUES (?,?,?,?,?)";
	//private final String QUERY_DELETE = "delete from sympthom where idSympthom = ?";
	
	public CrudPrincipiDAO() {		
	}
	
	/*public List<Principio> getAllPrincipio(){		
		List<Principio> allPrincipio = new ArrayList<Principio>();
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Sintomo newSintomo = new Sintomo();
				newSintomo.setIdSintomo(resultSet.getInt("idSympthom"));
				newSintomo.setTipoSintomo(resultSet.getString("sympthom_name"));
				newSintomo.setDescrizione(resultSet.getString("sympthom_desc"));
				allSintomi.add(newSintomo);
				
			}
				
		}catch (SQLException e){
			GestoreEccezioni.getInstance().gestisciEccezione(e);
            //System.out.println("Errore nella ricerca dei prodotti!!");
			}
			
	    return allSintomi;
	    
	}*/
	
	public boolean insertPrincipio(Principio Principio) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
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
/*
	public boolean updateSypthom(Request request) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			campo=(String)request.get("campo");
        	PreparedStatement preparedStatement = connection.prepareStatement("update sympthom set " + campo + "=? where idsympthom =?");
            preparedStatement.setString(1, (String)request.get("newCampo"));
            preparedStatement.setInt(2, (Integer)request.get("idSintomo"));
            preparedStatement.execute();
            return true;
		}
		catch(SQLException e){
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}	
	}
	
	public boolean DeleteSintomo(int idSintomo) {
    	Connection connection = ConnectionSingleton.getInstance();
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1,idSintomo);
            preparedStatement.execute();
            return true;
    }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }	
    }
	*/
	
				
	}

