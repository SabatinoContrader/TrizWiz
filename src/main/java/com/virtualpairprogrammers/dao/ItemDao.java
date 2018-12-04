package com.virtualpairprogrammers.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

import com.virtualpairprogrammers.model.Item;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

public class ItemDao {
	//private static final String QUERY_SEARCH_BY_ROOM = null;
	private final String QUERY_INSERT="insert into amebadevicesdb.itemtype(categoria,marca,modello, descrizione) values(?,?,?,?)";
	private final String QUERY_READ = "select * from amebadevicesdb.itemtype";
	private final String QUERY_SEARCH="select * from amebadevicesdb.itemtype where id=?";
	private final String QUERY_DELETE="delete from amebadevicesdb.itemtype where id=?";
	//private final String QUERY_SELECT_COLLEGAMENTO = "select item from collegamento where building = ?";
	
	public ItemDao() {
		
	}
	
	public List<Item> getAllItem () {
        List<Item> items = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_READ);
           while (resultSet.next()) {
        	   String id= Integer.toString(resultSet.getInt("id"));
               String categoria = resultSet.getString("categoria");
               String marca = resultSet.getString("marca");
               String modello = resultSet.getString("modello");
               String descrizione = resultSet.getString("descrizione");
               Item item= new Item(id, categoria, marca, modello, descrizione);
               items.add(item);
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
	
	public boolean insertItem(Item item) {
		Connection connection= ConnectionSingleton.getInstance();
        try {
        	
        	String categoria = item.getCategoria();
        	String marca = item.getMarca();
        	String modello = item.getModello();
        	String descrizione = item.getDescrizione();
      
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            
            preparedStatement.setString(1, categoria);
            preparedStatement.setString(2, marca);
            preparedStatement.setString(3, modello);
            preparedStatement.setString(4, descrizione);
            
            return preparedStatement.execute();            
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
	
	public Item searchItem (String id) {
		Connection connection= ConnectionSingleton.getInstance();
		Item item = null;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SEARCH);
            
            preparedStatement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet= preparedStatement.executeQuery();
            
            if(resultSet.next()) {
            	String categoria= resultSet.getString("categoria");
            	String marca= resultSet.getString("marca");
            	String modello= resultSet.getString("modello");
            	String descrizione = resultSet.getString("descrizione");
            	
            	item= new Item(id, categoria, marca, modello, descrizione);
            } else {
            	item = null;
            }
		} catch(SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
            
		}
		return item;
	}
	
	private String prapareUpdateQuery(List<String> itemFields) {
		StringJoiner joiner = new StringJoiner(", ", "update amebadevicesdb.itemtype set ", " where id=?");
		List<String> fields = Arrays.asList("categoria=?", "marca=?", "modello=?", "descrizione=?");
		
		int i = 0;
		while (i < itemFields.size()) {
			if(!itemFields.get(i).isEmpty()) {
				joiner.add(fields.get(i));
			}
		i++;
		}
		
        return joiner.toString();        
	}
	
	private PreparedStatement prepareUpdateStatement
	(
			PreparedStatement preparedStatement,
			List<String> fields,
			int id
	) {
		Iterator<String> fieldsIterator = fields.iterator();
		
		int i = 0;
		while (fieldsIterator.hasNext()) {
			try {
				String field = fieldsIterator.next();
				if(!field.isEmpty()) {
					preparedStatement.setString(i + 1, field);
					i++;
				}	
			} catch (SQLException e) {
				GestoreEccezioni.getInstance().gestisciEccezione(e);
			}
		}
		
		try {
			preparedStatement.setInt(++i, id);
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
		}
		return preparedStatement;
	}

	
	public void updateItem(Item item) {
		Connection connection= ConnectionSingleton.getInstance();
        try {
        	List<String> ItemFields = Arrays.asList(item.getCategoria(), item.getMarca(), item.getModello(), item.getDescrizione());
        	int itemId = Integer.parseInt(item.getId());
      
            String updateQuery = this.prapareUpdateQuery(ItemFields);
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement = this.prepareUpdateStatement(preparedStatement, ItemFields, itemId);
            preparedStatement.execute();    
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            
        }

	}
	
	public void deleteItem(String id) {
		Connection connection= ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            
            preparedStatement.setInt(1,Integer.parseInt(id));
            preparedStatement.execute();

		} catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
		}
	}

	/*
	public List<Item> getByBuilding(int buildingId) {
		Connection connection = ConnectionSingleton.getInstance();
		List <Item> toReturn = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(QUERY_SELECT_COLLEGAMENTO);
			ps.setInt(1, buildingId);
			ResultSet rs = ps.executeQuery();
			List <Integer> ids = new ArrayList<>();
			while(rs.next()) {
				ids.add(rs.getInt(1));
			}
			PreparedStatement secondStep = connection.prepareStatement(QUERY_SEARCH);
			ResultSet secondResult = secondStep.executeQuery();
					while(secondResult.next()) {
						Item tmp = new Item();
						tmp.setId(Integer.toString(secondResult.getInt(1)));
						tmp.setMarca(secondResult.getString(2));
						tmp.setModello(secondResult.getString(3));
						tmp.setCategoria(secondResult.getString(4));
						toReturn.add(tmp);
					}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
		
	}
	
	*/
}