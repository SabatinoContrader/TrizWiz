package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Asset;
import main.model.User;
import main.model.UserAsset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserAssetDAO {

    private final String QUERY_INSUSERASS = "insert into userasset(iduser,idasset,orainizio,orafine) values (?,?,?,?) ";
    private final String QUERY_ALLUSERASS = "select * from userasset";
    private final String QUERY_ALLSTORICO = "select * from storico";
    private final String QUERY_INSUSERASSS = "insert into storico(iduser,idasset,orainizio,orafine) values (?,?,?,?) ";
    private final String QUERY_DELETE = "delete from userasset where iduser=? and idasset=? and orainizio=?";
    private final String QUERY_ALLUSERASSN = "select b.iduser,username,password,nome,cognome,telefono,mail,partitaiva,ruolo from userasset as o right join user as b on o.iduser=b.iduser where o.iduser is null";
    
   
    
    public boolean deleteUserAsset(int idUser, int idAsset, String idData) {
    	 Connection connection = ConnectionSingleton.getInstance();
         try {
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
             
             preparedStatement.setInt(1, idUser);
             preparedStatement.setInt(2, idAsset);
             preparedStatement.setString(3, idData);
             preparedStatement.execute();
             return true;
         }
         catch (SQLException e) {
             GestoreEccezioni.getInstance().gestisciEccezione(e);
             return false;
         }
    }
    
    
    public List<User> getAllUsersN () {
        List<User> users = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALLUSERASSN);
           while (resultSet.next()) {
        	   int id = resultSet.getInt("iduser");
        	   String username = resultSet.getString("username");
        	   String password = resultSet.getString("password");
        	   String nome = resultSet.getString("nome");
        	   String cognome = resultSet.getString("cognome");
        	   String telefono = resultSet.getString("telefono");
        	   String mail = resultSet.getString("mail");
        	   String partitaiva = resultSet.getString("partitaiva");
        	   String ruolo = resultSet.getString("ruolo");
               users.add(new User(id,username,password,nome,cognome,telefono,mail,partitaiva,ruolo));
           }
           System.out.println("TEST");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    
    
    public List<UserAsset> getAllUsersAssets () {
        List<UserAsset> userassets = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALLUSERASS);
           while (resultSet.next()) {
        	   int iduser = resultSet.getInt("iduser");
        	   int idasset = resultSet.getInt("idasset");
        	   String orainizio = resultSet.getString("orainizio");
               String orafine = resultSet.getString("orafine");
               userassets.add(new UserAsset(iduser,idasset,orainizio,orafine));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return userassets;
    }
    
    public List<UserAsset> getAllStorico () {
        List<UserAsset> userassets = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALLSTORICO);
           while (resultSet.next()) {
        	   int iduser = resultSet.getInt("iduser");
        	   int idasset = resultSet.getInt("idasset");
        	   String orainizio = resultSet.getString("orainizio");
               String orafine = resultSet.getString("orafine");
               userassets.add(new UserAsset(iduser,idasset,orainizio,orafine));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return userassets;
    }
    
    public boolean insertUserAsset(UserAsset userAsset) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSUSERASS);
            preparedStatement.setInt(1, userAsset.getIduser());
            preparedStatement.setInt(2, userAsset.getIdasset());
            preparedStatement.setString(3, userAsset.getOrainizio());
            preparedStatement.setString(4, userAsset.getOrafine());
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    
    public boolean insertStorico(UserAsset userasset) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSUSERASSS);
            preparedStatement.setInt(1, userasset.getIduser());
            preparedStatement.setInt(2, userasset.getIdasset());
            preparedStatement.setString(3, userasset.getOrainizio());
            preparedStatement.setString(4, userasset.getOrafine());   
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
}
