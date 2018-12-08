
	package com.virtualpairprogrammers.dao;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.*;

	import com.virtualpairprogrammers.utils.ConnectionSingleton;
	import com.virtualpairprogrammers.utils.GestoreEccezioni;
	import com.virtualpairprogrammers.model.SottoCategorie;
	import javax.servlet.http.HttpServletRequest;

public class CrudSottoCategorieDAO {			
			String campo = "";
			
		////////////////////// cambiare le query
		    private final String QUERY_CategorieStandard = "select * from sottoCategorie";
			private final String QUERY_INSERT = "INSERT INTO SottoCategorie (descrizione,idStandard,descrizioneIta) VALUES (?,?,?)";
			private final String QUERY_DELETE = "delete from SottoCategorie where id = ?";
			
			
			public CrudSottoCategorieDAO() {		
			}
			
			
			public List<SottoCategorie> getAllSottoCategorie() {
			    List<SottoCategorie>  listSottoCategorie= new ArrayList<SottoCategorie>();
		        Connection connection = ConnectionSingleton.getInstance();
		       
				try {
		           Statement statement = connection.createStatement();
		           ResultSet resultSet = statement.executeQuery(QUERY_CategorieStandard);
		           while (resultSet.next()) {
		        	   SottoCategorie newSottoCategorie=new SottoCategorie();
		        	   //// sistemare campi
		        	   newSottoCategorie.setId(resultSet.getInt("id"));
		        	   //newCategorieStandard.setId(resultSet.getString("id"));
		        	   newSottoCategorie.setDescrizione(resultSet.getString("descrizione"));
		        	   newSottoCategorie.setIdStandard(resultSet.getInt("idStandard"));
		        	   newSottoCategorie.setDescrizioneIta(resultSet.getString("descrizioneIta"));
		        	   listSottoCategorie.add(newSottoCategorie);
		           	}
		        }
		        catch (SQLException e) {
		            e.printStackTrace();
		        }
				
				return listSottoCategorie;
		    }
			
			public boolean insertSottoCategorie(SottoCategorie SottoCategorie) {
				Connection connection = ConnectionSingleton.getInstance();
				try {
					PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
					//preparedStatement.setInt(1, Principio.getId());
					preparedStatement.setString(1, SottoCategorie.getDescrizione());
					preparedStatement.setInt(2, SottoCategorie.getIdStandard());
		            preparedStatement.setString(3, SottoCategorie.getDescrizioneIta());
		            
		            preparedStatement.execute();
		            return true;
				}
				catch (SQLException e){
					GestoreEccezioni.getInstance().gestisciEccezione(e);
					return false;
				}		
				
			}

			public boolean updateSottoCategorie(SottoCategorie SottoCategorie) {
				Connection connection = ConnectionSingleton.getInstance();
				try {
		        	PreparedStatement preparedStatement = connection.prepareStatement("update sottoCategorie set descrizione =?, idStandard=?, descrizioneIta=?  where id =?");
					preparedStatement.setString(1, SottoCategorie.getDescrizione());
					preparedStatement.setInt(2, SottoCategorie.getIdStandard());
					preparedStatement.setString(3, SottoCategorie.getDescrizioneIta());
					preparedStatement.setInt(4, SottoCategorie.getId());
		            preparedStatement.execute();
		            return true;
				}
				catch(SQLException e){
					GestoreEccezioni.getInstance().gestisciEccezione(e);
					return false;
				}	
			}
			
			public boolean deleteSottoCategorie(int id) {
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