package com.virtualpairprogrammers.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.model.Building;
import com.virtualpairprogrammers.model.Room;
import com.virtualpairprogrammers.model.Thing;
import com.virtualpairprogrammers.utils.ConnectionSingleton;

public class ThingDAO {
	private static final String INSERT_QUERY = "insert into thing (nome, numUscite) values (?,?)";
	private static final String DELETE_QUERY = "delete from thing where id = ?";
	private final String QUERY_READ = "select * from thing";
	private static final String UPDATE_THING = "update amebadevicesdb.thing set numUscite=? , nome=? where id=?";
	
	public List<Thing> getAllItem () {
        List<Thing> items = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_READ);
           while (resultSet.next()) {
        	   int id= resultSet.getInt("id");
               int numUscite = resultSet.getInt("numUscite");
               String nome = resultSet.getString("nome");
               Thing item= new Thing(numUscite,nome);
               item.setId(String.valueOf(id));
               items.add(item);
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

	public void create(Thing t) {
		Connection c = ConnectionSingleton.getInstance();
		try {
			PreparedStatement ps = c.prepareStatement(INSERT_QUERY);
			ps.setString(1, t.getNome());
			ps.setInt(2, t.getNumUscite());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public void delete(int id) {
		Connection c = ConnectionSingleton.getInstance();
		try {
			PreparedStatement ps = c.prepareStatement(DELETE_QUERY);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update (Thing newThing ) {
		Connection c = ConnectionSingleton.getInstance();

		try {

			PreparedStatement ps = c.prepareStatement(UPDATE_THING);
			ps.setString(1, newThing.getId());
			ps.setInt(2, newThing.getNumUscite());
			ps.setString(3, newThing.getNome());
			ps.execute();
			
		} catch (SQLException e) {

			e.printStackTrace();

		}

	}


}
