package com.virtualpairprogrammers.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.model.CategorieStandard;
import javax.servlet.http.HttpServletRequest;


public class CrudCategorieStandardDAO {
		
		String campo = "";
		

	////////////////////// cambiare le query
	    private final String QUERY_CategorieStandard = "select * from CategorieStandard";
		private final String QUERY_INSERT = "INSERT INTO CategorieStandard (nome,nomeIng) VALUES (?,?)";
		private final String QUERY_DELETE = "delete from CategorieStandard where id = ?";
		
		
		public CrudCategorieStandardDAO() {		
		}
		
		public List<CategorieStandard> getAllCategorieStandard() {
		    List<CategorieStandard>  listCategorieStandard= new ArrayList<CategorieStandard>();
	        Connection connection = ConnectionSingleton.getInstance();
	       
			try {
	           Statement statement = connection.createStatement();
	           ResultSet resultSet = statement.executeQuery(QUERY_CategorieStandard);
	           while (resultSet.next()) {
	        	   CategorieStandard newCategorieStandard=new CategorieStandard();
	        	   //// sistemare campi
	        	   newCategorieStandard.setId(resultSet.getInt("id"));
	        	   //newCategorieStandard.setId(resultSet.getString("id"));
	        	   newCategorieStandard.setNome(resultSet.getString("nome"));
	        	   newCategorieStandard.setNomeIng(resultSet.getString("nomeIng"));
	        	   listCategorieStandard.add(newCategorieStandard);
	           	}
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
			
			return listCategorieStandard;
	    }
		
		public boolean insertCategorieStandard(CategorieStandard CategorieStandard) {
			Connection connection = ConnectionSingleton.getInstance();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
				//preparedStatement.setInt(1, Principio.getId());
				preparedStatement.setString(1, CategorieStandard.getNome());
	            preparedStatement.setString(2, CategorieStandard.getNomeIng());
	  
	            preparedStatement.execute();
	            return true;
			}
			catch (SQLException e){
				GestoreEccezioni.getInstance().gestisciEccezione(e);
				return false;
			}		
			
		}

		public boolean updateCategorieStandard(CategorieStandard CategorieStandard) {
			Connection connection = ConnectionSingleton.getInstance();
			try {
	        	PreparedStatement preparedStatement = connection.prepareStatement("update categorieStandard set nome =?, nomeIng=?  where id =?");
				preparedStatement.setString(1, CategorieStandard.getNome());
				preparedStatement.setString(2, CategorieStandard.getNomeIng());
				preparedStatement.setInt(3, CategorieStandard.getId());
	            preparedStatement.execute();
	            return true;
			}
			catch(SQLException e){
				GestoreEccezioni.getInstance().gestisciEccezione(e);
				return false;
			}	
		}
		
		public boolean deleteCategorieStandard(int id) {
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

