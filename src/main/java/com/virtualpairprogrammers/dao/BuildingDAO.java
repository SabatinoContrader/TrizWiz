package com.virtualpairprogrammers.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.model.Building;
import com.virtualpairprogrammers.utils.ConnectionSingleton;

public class BuildingDAO {
	
	/*private final String query_join="SELECT indirizzo, interno, cap, citta\r\n" + 
			"FROM user AS u\r\n" + 
			"INNER JOIN proprieta AS p ON u.id = p.iduser\r\n" + 
			"INNER JOIN building AS b ON p.idbuilding = b.id\r\n" + 
			"WHERE u.username = ?";*/
	
	private final String userIdFromUsername = "select id from user where username = ? and user_role = 2";

	private final String propertiesIdOfAnUser = "select idbuilding from proprieta where iduser = ?";

	private final String getBuildingIdFrombuildingData = "select id from building where indirizzo = ? and interno = ? and citta = ? and cap = ?";

	private final String insertIntoProprieta = "insert into proprieta (iduser, idbuilding) values (?,?)";

	private final String insertQuery = "insert into building(indirizzo, citta, cap, interno) values(?,?,?,?)";

	private final static String findById = "select * from building where id = ?";

	private final String deleteById = "delete from building where id = ?";

	private final String update = "update building set indirizzo = ?, citta = ?, cap = ?, interno = ? where id = ?";

	private final String deletePropr = "delete from proprieta where idbuilding = ?";

	public boolean insert(Building myBuilding, String ownerName) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, myBuilding.getIndirizzo());
			statement.setString(2, myBuilding.getCitta());
			statement.setString(3, myBuilding.getCap());
			statement.setString(4, myBuilding.getInterno());
			statement.execute();
			PreparedStatement secondStatement = connection.prepareStatement(userIdFromUsername);
			secondStatement.setString(1, ownerName);
			ResultSet secondResult = secondStatement.executeQuery();
			int userId = 0;
			if (secondResult.next()) {
				// ho recuperato l'id dell'utente
				userId = secondResult.getInt(1);
			}
			int buildingId = 0;
			if (userId != 0) {
				PreparedStatement thirdStatement = connection.prepareStatement(getBuildingIdFrombuildingData);

				thirdStatement.setString(1, myBuilding.getIndirizzo());
				thirdStatement.setString(2, myBuilding.getInterno());
				thirdStatement.setString(3, myBuilding.getCitta());
				thirdStatement.setString(4, myBuilding.getCap());

				ResultSet thirdResult = thirdStatement.executeQuery();
				if (thirdResult.next()) {

					buildingId = thirdResult.getInt(1);
				}
			}
			if (userId != 0 && buildingId != 0) {
				PreparedStatement finalStatement = connection.prepareStatement(insertIntoProprieta);
				finalStatement.setInt(1, userId);
				finalStatement.setInt(2, buildingId);
				finalStatement.execute();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return false;
	}

	public List<Building> getAllByUser(String owner) {
		List<Building> toReturn = new ArrayList<>();
		int id;
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement statement = connection.prepareStatement(userIdFromUsername);
			statement.setString(1, owner);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				// ho recuperato l'id dell'user di cui voglio conoscere tutti i Buildings
				id = resultSet.getInt(1);
				PreparedStatement secondStep = connection.prepareStatement(propertiesIdOfAnUser);
				secondStep.setInt(1, id);
				List<Integer> propertiesId = new ArrayList<>();
				ResultSet secondStepResult = secondStep.executeQuery();
				while (secondStepResult.next()) {
					propertiesId.add(secondStepResult.getInt(1));
				}
				// ora ho recuperato gli id di tutte le proprieta del mio utente;
				for (int i = 0; i < propertiesId.size(); i++) {
					toReturn.add(BuildingDAO.findByPrimaryKey(propertiesId.get(i)));
					// Qui mi costruisco la lista di buildings da tirare fuori
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toReturn;

	}

	public static Building findByPrimaryKey(Integer id) {
		Building myBuilding = null;
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement statement = connection.prepareStatement(findById);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				myBuilding = new Building();
				myBuilding.setBuildingId(id);
				myBuilding.setIndirizzo(resultSet.getString(2));
				myBuilding.setInterno(resultSet.getString(3));
				myBuilding.setCitta(resultSet.getString(4));
				myBuilding.setCap(resultSet.getString(5));
				

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return myBuilding;
	}

	public boolean delete(Building toDestroy, String owner) {
		int buildingId = 0;
		Connection connection = ConnectionSingleton.getInstance();
		PreparedStatement firstStep;
		try {
			firstStep = connection.prepareStatement(getBuildingIdFrombuildingData);
			firstStep.setString(1, toDestroy.getIndirizzo());
			firstStep.setString(2, toDestroy.getInterno());
			firstStep.setString(3, toDestroy.getCitta());
			firstStep.setString(4, toDestroy.getCap());

			ResultSet res = firstStep.executeQuery();
			if (res.next()) {
				buildingId = res.getInt(1);
				PreparedStatement second = connection.prepareStatement(deletePropr);
				second.setInt(1, buildingId);
				if (!second.execute()) {
					PreparedStatement statement = connection.prepareStatement(deleteById);
					statement.setInt(1, buildingId);
					statement.execute();
				}
				return true;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Building building, Building newValues, String username) {
		int buildingId = building.getBuildingId();
		Connection connection = ConnectionSingleton.getInstance();
		PreparedStatement firstStep;
		try {
			if (buildingId == 0) {
			firstStep = connection.prepareStatement(getBuildingIdFrombuildingData);
			firstStep.setString(1, building.getIndirizzo());
			firstStep.setString(2, building.getInterno());
			firstStep.setString(3, building.getCitta());
			firstStep.setString(4, building.getCap());
			ResultSet res = firstStep.executeQuery();
			if (res.next()) {
				buildingId = res.getInt(1);
			}
			}
				PreparedStatement statement = connection.prepareStatement(update);
				statement.setString(1, newValues.getIndirizzo());
				statement.setString(2, newValues.getCitta());
				statement.setString(3, newValues.getCap());
				statement.setString(4, newValues.getInterno());
				System.out.println("----------->"+buildingId);
				statement.setInt(5, buildingId);
				statement.execute();
				return true;


		} catch (SQLException e) {
			return false;
		}

	}

}
