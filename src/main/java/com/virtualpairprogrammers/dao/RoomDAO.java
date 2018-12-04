package com.virtualpairprogrammers.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.virtualpairprogrammers.model.Customer;
import com.virtualpairprogrammers.model.Room;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import java.sql.PreparedStatement;


public class RoomDAO {

		String param="";
		private static final String ALL_ROOM = "select * from room";
		private static final String UPDATE_ROOM = "update amebadevicesdb.room set nome=? , descrizione=?, idfloor=? where id=?";
		private static final String INSERIMENTO_QUERY = "insert into room (nome, descrizione, idfloor) values (?,?,?)";
		private static final String DELETE = "delete from amebadevicesdb.room where id = ?";
		private static final String SEARCH_BY_FLOOR = "select * from room where idfloor = ?";
		private static final String QUERY_SEARCH  ="select * from amebadevicesdb.room where id=?";
		public RoomDAO() {

		}



		public boolean insertRoom(Room f) {

			String nomeRoom = f.getNomeRoom();
			String descrizione = f.getDescrizione();
			String floorId= f.getIdFloor();
			Connection c = ConnectionSingleton.getInstance();

			try {
				PreparedStatement ps = c.prepareStatement(INSERIMENTO_QUERY);
				ps.setString(1, nomeRoom);
				ps.setString(2, descrizione);
				ps.setInt(3,Integer.parseInt(floorId));
				if (ps.execute()) return true;
				
				return false;
			} catch (SQLException e) {
				return false;

			}
		}
		
		
		public List<Room> getAllByFloor(int floorId) {

			List <Room> lista = new ArrayList<>();
			Connection c = ConnectionSingleton.getInstance();
			try {

				PreparedStatement ps = c.prepareStatement(SEARCH_BY_FLOOR);
				ps.setInt(1, floorId);

		        ResultSet myResult = ps.executeQuery();

				while (myResult.next()) {

					Room newRoom = new Room();
					newRoom.setId(myResult.getInt(1));
					newRoom.setNomeRoom(myResult.getString(2));
					newRoom.setDescrizione(myResult.getString(3));
					newRoom.setIdFloor(String.valueOf(myResult.getInt(4)));
					lista.add(newRoom);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return lista;
		}


		public Room searchRoom(int id) {
			Connection connection=ConnectionSingleton.getInstance();
			Room room= null;
			try {
				PreparedStatement preparedStatement=connection.prepareStatement(QUERY_SEARCH);
				preparedStatement.setInt(1, id);
				ResultSet resultSet=preparedStatement.executeQuery();
				if(resultSet.next()) {
		               String nome = resultSet.getString("nome");
		               String descrizione = resultSet.getString("descrizione");
		               room=new Room(nome,descrizione);
		              // room.setId(id);
				}
			} catch (SQLException e) {
				GestoreEccezioni.getInstance().gestisciEccezione(e);
			}
			return room;
		}
		

		public void update (Room f) {
			Connection c = ConnectionSingleton.getInstance();

			try {

				PreparedStatement ps = c.prepareStatement(UPDATE_ROOM);
				ps.setString(1, f.getNomeRoom());
				ps.setString(2, f.getDescrizione());
				ps.setInt(3, Integer.parseInt(f.getIdFloor()));
				ps.setInt(4, Integer.parseInt(f.getId()));
				ps.execute();
				
			} catch (SQLException e) {

				e.printStackTrace();

			}

		}

		

		

		public void delete (int id) {
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

