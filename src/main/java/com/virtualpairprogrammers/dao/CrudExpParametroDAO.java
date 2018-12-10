package com.virtualpairprogrammers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.model.ExpParametro;
import com.virtualpairprogrammers.model.Principio;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

public class CrudExpParametroDAO {
	
	public CrudExpParametroDAO() {}

	String campo = "";
	
	private final String QUERY_INSERT = "INSERT INTO expar (commento) VALUES (?)";
	private final String QUERY_SELECTID = "select id from expar where commento = ?";
	private final String QUERY_INSERTDEPAR = "INSERT INTO depar (parId,exId) VALUES (?,?)";
	private final String QUERY_SELECTESP= "SELECT e.id , e.commento FROM parametri as p, depar as d, expar as e  WHERE p.Id=? and p.Id=d.parId and d.exId=e.id";
	
	
	public List<ExpParametro> selezionaExpParametro(String id){
		
		List<ExpParametro> listExpParametro= new ArrayList<ExpParametro>();
		 Connection connection = ConnectionSingleton.getInstance();
	        try {
	            PreparedStatement statement = connection.prepareStatement(QUERY_SELECTESP);
	            statement.setString(1, id);
	            ResultSet resultSet = statement.executeQuery();
	            while (resultSet.next()) {
	            	ExpParametro newExpParametro=new ExpParametro();
	            	newExpParametro.setId(resultSet.getInt("e.id"));
	            	newExpParametro.setCommento(resultSet.getString("e.commento"));
	            	listExpParametro.add(newExpParametro);
	            }
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
		return listExpParametro; 
		
	}
	
	public boolean insertEspParametro(String idParam, String commento) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			//id da togliere
			//preparedStatement.setInt(1, Principio.getId());
			preparedStatement.setString(1, commento);
            preparedStatement.execute();
            int idExpar= this.selezionaIdCommento(commento);
            int idParametro= Integer.parseInt(idParam);
            boolean inserimento= this.insertIdDepar(idParametro,idExpar);
            return inserimento;
		}
		catch (SQLException e){
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}		
		
	}
	
	public int selezionaIdCommento (String varCommento) {
		int idExp=-1;
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SELECTID);
			preparedStatement.setString(1, varCommento);
			ResultSet resultSet = preparedStatement.executeQuery();
			 while (resultSet.next()) {
				 String id= resultSet.getString("id");
				 idExp=Integer.parseInt(id);
			 }
	}
		catch (SQLException e) {
	         e.printStackTrace();
	     }
		return idExp;
	
	}
	
	public boolean insertIdDepar(int idParam, int expId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERTDEPAR);
			preparedStatement.setInt(1, idParam);
			preparedStatement.setInt(2, expId);
			preparedStatement.execute();
			return true;
		}
		
		catch (SQLException e){
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}		
	}
}
