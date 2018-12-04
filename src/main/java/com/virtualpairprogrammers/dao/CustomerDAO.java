package com.virtualpairprogrammers.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.model.Customer;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

public class CustomerDAO {

	private final String QUERY_INSERT="insert into amebadevicesdb.user(nome,cognome,datanascita,email,username,password,user_role) values(?,?,?,?,?,?,2)";
	private final String QUERY_READ="select * from amebadevicesdb.user where user_role=2";
	private final String QUERY_SEARCH="select * from amebadevicesdb.user where id=?";
	private final String QUERY_UPDATE="update amebadevicesdb.user set nome=?,cognome=?,datanascita=?,email=?,username=?,password=? where id=?";
	private final String QUERY_DELETE="delete from amebadevicesdb.user where id=?";
	
	public CustomerDAO() {}
	
	public boolean insertCustomer(Customer customer) {
		Connection connection=ConnectionSingleton.getInstance();
		
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, customer.getNome());
			preparedStatement.setString(2, customer.getCognome());
			preparedStatement.setString(3,customer.getDataNascita());
			preparedStatement.setString(4,customer.getEmail());
			preparedStatement.setString(5, customer.getUsername());
			preparedStatement.setString(6,customer.getPassword());
			preparedStatement.execute();
			return true;
			
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
	
	public List<Customer> readAll(){
		Connection connection=ConnectionSingleton.getInstance();
		List<Customer> customers= new ArrayList<>();
		  try {
	           Statement statement = connection.createStatement();
	           ResultSet resultSet = statement.executeQuery(QUERY_READ);
	           while (resultSet.next()) {
	        	   int id= resultSet.getInt("id");
	               String nome = resultSet.getString("nome");
	               String cognome = resultSet.getString("cognome");
	               String datanascita=resultSet.getString("datanascita");
	               String email=resultSet.getString("email");
	               String username= resultSet.getString("username");
	               String password= resultSet.getString("password");
	               Customer customer=new Customer(nome,cognome,datanascita,email,username,password);
	               customer.setId(id);
	               customers.add(customer);
	           }
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
		return customers;
		}
	
	public Customer searchCustomer(int id) {
		Connection connection=ConnectionSingleton.getInstance();
		Customer customer= null;
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(QUERY_SEARCH);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
	               String nome = resultSet.getString("nome");
	               String cognome = resultSet.getString("cognome");
	               String datanascita=resultSet.getString("datanascita");  
	               String email=resultSet.getString("email");
	               String username= resultSet.getString("username");
	               String password= resultSet.getString("password");
	               customer=new Customer(nome,cognome,datanascita,email,username,password);
	               customer.setId(id);
			}
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
		}
		return customer;
	}
	
	public void updateCustomer( Customer customer) {
		Connection connection=ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, customer.getNome());
			preparedStatement.setString(2, customer.getCognome());
			preparedStatement.setString(3,customer.getDataNascita());
			preparedStatement.setString(4, customer.getEmail());
			preparedStatement.setString(5, customer.getUsername());
			preparedStatement.setString(6,customer.getPassword());
			preparedStatement.setInt(7, Integer.parseInt(customer.getId()));
			preparedStatement.execute();
			
			
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
		
		}
	}
	
	public void deleteCustomer(int id) {
		Connection connection=ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
		}
	}
	
	}
	
	

