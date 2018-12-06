package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginDAO {

    private final String QUERY_LOGIN = "select * from utente where username = ? and password = ?";
    private final String QUERY_LOGIN_RUOLO = "select * from utente where username = ? and password = ? and ruolo = ?";

    public boolean login (String username, String password) {

        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeQuery();
            return true;
            
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    	
    }
    
/*    public boolean login (String username, String password, String ruolo) {

        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN_RUOLO);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, ruolo);
            statement.executeQuery();
            return true;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }*/
}
