package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.controller.Request;
import main.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	
	String param="";
	
	private final String QUERY_ALL = "select * from user";
    private final String QUERY_INSERT = "insert into user (iduser, username, password, nome, cognome, telefono, mail, partitaiva, ruolo) values (?,?,?,?,?,?,?,?,?)";
    private final String QUERY_DELETE = "delete from user where iduser=?";
    private final String QUERY_CLIENTI = "select * from user where ruolo='cliente'";
    private final String QUERY_CLIENTIASS= "select distinct u.iduser,username,nome,cognome,partitaiva from user as u join userasset as us on u.iduser=us.iduser where ruolo='cliente'";
    //private final String QUERY_UPDATE = "update user set "+param+"=? where idutente=?";
    
    public UserDAO() {

    }
    public List<User> getAllClienti () {
        List<User> listUsers = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_CLIENTI);
           while (resultSet.next()) {
        	   int idutente = resultSet.getInt("iduser");
        	   String username = resultSet.getString("username");
        	   String password = resultSet.getString("password");
        	   String nome = resultSet.getString("nome");
        	   String cognome = resultSet.getString("cognome");
        	   String telefono = resultSet.getString("telefono");
        	   String mail = resultSet.getString("mail");
        	   String partitaiva = resultSet.getString("partitaiva");
        	   String ruolo = resultSet.getString("ruolo");
        	   listUsers.add(new User(idutente, username, password,nome,cognome,telefono,mail,partitaiva,ruolo));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listUsers;
    }
    
    public List<User> getAllClientiAss () {
        List<User> listUsers = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_CLIENTIASS);
           while (resultSet.next()) {
        	   int idutente = resultSet.getInt("iduser");
        	   String username = resultSet.getString("username");
        	   String nome = resultSet.getString("nome");
        	   String cognome = resultSet.getString("cognome");
        	   String partitaiva = resultSet.getString("partitaiva");
        	   listUsers.add(new User(idutente, username,nome,cognome,partitaiva));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listUsers;
    }
    
    public List<User> getAllUsers () {
        List<User> listUsers = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
        	   int idutente = resultSet.getInt("iduser");
        	   String username = resultSet.getString("username");
        	   String password = resultSet.getString("password");
        	   String nome = resultSet.getString("nome");
        	   String cognome = resultSet.getString("cognome");
        	   String telefono = resultSet.getString("telefono");
        	   String mail = resultSet.getString("mail");
        	   String partitaiva = resultSet.getString("partitaiva");
        	   String ruolo = resultSet.getString("ruolo");
        	   listUsers.add(new User(idutente, username, password,nome,cognome,telefono,mail,partitaiva,ruolo));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listUsers;
    }

    public boolean insertUser(User user) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, user.getIdutente());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getNome());
            preparedStatement.setString(5, user.getCognome());
            preparedStatement.setString(6, user.getTelefono());
            preparedStatement.setString(7, user.getMail());
            preparedStatement.setString(8, user.getPartitaiva());
            preparedStatement.setString(9, user.getRuolo());
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    
    public boolean deleteUser(int idUser) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, idUser);
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
        	if(e instanceof SQLIntegrityConstraintViolationException) {
        		System.out.println("Impossibile eliminare utente in quanto associato ad un asset");
        		return false;
        	}
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    
    public boolean udpateUser(Request request) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            param=(String)request.get("campo");
        	PreparedStatement preparedStatement = connection.prepareStatement("update user set "+param+"=? where iduser=?");
            preparedStatement.setString(1, (String)request.get("newData"));
            preparedStatement.setInt(2, (Integer)request.get("idUtente"));
            preparedStatement.execute();
            return true;
            
        }
            
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
            }
    }
    
}
