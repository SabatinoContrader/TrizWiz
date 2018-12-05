package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.model.Principio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


public class MatrixDAO {

    //private final String QUERY_MATRIX = "select * from users where username = ? and password = ?";
	private final String QUERY_MATRIX = "SELECT p.id, p.nomePrincipio, p.nomePrincipioIta, p.domande, p.steps, p.esempi FROM matrix as a, principi as p WHERE a.paramID1= ? and a.paramID2= ? and a.principleID=p.id";


	public List<Principio> getAllMatrix(String param1, String param2) {

	    List<Principio>  listPrincipio= new ArrayList<Principio>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_MATRIX);
            //ResultSet resultSet = statement.executeQuery(QUERY_MATRIX);
            statement.setString(1, param1);
            statement.setString(2, param2);
            ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
         	   Principio newPrincipio=new Principio();
         	   newPrincipio.setNomePrincipio(resultSet.getString("p.nomePrincipio"));
         	   newPrincipio.setDomande(resultSet.getString("p.domande"));
         	   newPrincipio.setEsempi(resultSet.getString("p.esempi"));
         	   newPrincipio.setId(resultSet.getInt("p.id"));
         	   newPrincipio.setNomePrincipioIta(resultSet.getString("p.nomePrincipioIta"));
         	   newPrincipio.setSteps(resultSet.getString("p.steps"));
         	   listPrincipio.add(newPrincipio);
            	}
            //return statement.executeQuery().next();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
		
		return listPrincipio;
    }
}
    
    


