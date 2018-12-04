package com.virtualpairprogrammers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.model.Floor;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;


public class FloorDAO {
	
	private static final String ALL_BY_BUILDING = "select * from floor where idbuilding = ?";
	private static final String UPDATE_FLOOR = "update floor set nome = ?, descrizione = ?, idbuilding = ? where id = ?";
	private static final String INSERT_QUERY = "insert into floor (nome, descrizione, idbuilding) values (?,?,?)";
	private static final String DELETE = "delete from floor where id = ?";
	private static final String FIND_BY_PRIMARYKEY = "select * from floor where id = ?";
	
	public FloorDAO() {
		
	}

	public boolean insertFloor(Floor f) {
		String nomeFloor = f.getNomeFloor();
		String descrizione = f.getDescrizione();
		String buildingId = f.getIdBuilding();
		Connection c = ConnectionSingleton.getInstance();
		try {
			PreparedStatement ps = c.prepareStatement(INSERT_QUERY);
			ps.setString(1, nomeFloor);
			ps.setString(2, descrizione);
			ps.setInt(3, Integer.parseInt(buildingId));
			if (ps.execute()) return true;
			return false;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public List<Floor> getAllByBuilding(int buildingId){
		List <Floor> toRet = new ArrayList<>();
		Connection c = ConnectionSingleton.getInstance();
		try {
			PreparedStatement ps = c.prepareStatement(ALL_BY_BUILDING);
			ps.setInt(1, buildingId);
			ResultSet myResult = ps.executeQuery();
			while (myResult.next()) {
				Floor newFloor = new Floor();
				newFloor.setId(String.valueOf(myResult.getInt(1)));
				newFloor.setNomeFloor(myResult.getString(2));
				newFloor.setDescrizione(myResult.getString(3));
				newFloor.setIdBuilding(String.valueOf(myResult.getInt(4)));
				toRet.add(newFloor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toRet;
		
	}
	
	public void update (Floor f) {
		Connection c = ConnectionSingleton.getInstance();
		try {
			PreparedStatement ps = c.prepareStatement(UPDATE_FLOOR);
			ps.setString(1, f.getNomeFloor());
			ps.setString(2, f.getDescrizione());
			ps.setInt(3, Integer.parseInt(f.getIdBuilding()));
			ps.setInt(4, Integer.parseInt(f.getId()));
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Floor findByPrimaryKey(int id){
		Connection c = ConnectionSingleton.getInstance();
		try {
			PreparedStatement ps = c.prepareStatement(ALL_BY_BUILDING);
			ps.setInt(1, id);
			ResultSet myResult = ps.executeQuery();
			if (myResult.next()) {
				Floor newFloor = new Floor();
				newFloor.setId(String.valueOf(myResult.getInt(1)));
				newFloor.setNomeFloor(myResult.getString(2));
				newFloor.setDescrizione(myResult.getString(3));
				newFloor.setIdBuilding(String.valueOf(myResult.getInt(4)));
				return newFloor;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void delete (Floor f) {
		Connection connection=ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(DELETE);
			preparedStatement.setInt(1, Integer.parseInt(f.getId()));
			preparedStatement.execute();
			
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
		}
	}
	
	public void deleteById (int id) {
		Connection connection=ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(DELETE);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
		}
	}

}
