package com.AmebaDevices.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.converter.FloorConverter;
import com.AmebaDevices.converter.RoomConverter;
import com.AmebaDevices.dao.RoomDAO;
import com.AmebaDevices.dto.FloorDTO;
import com.AmebaDevices.dto.RoomDTO;
import com.AmebaDevices.model.Room;

@Service
public class RoomService {

	private RoomDAO roomdao;

	@Autowired
	public RoomService(RoomDAO roomdao) {
		this.roomdao = roomdao;
	}

	public void delete(long id) {
		Room c = roomdao.findOne(id);
		roomdao.delete(c);

	}

	public RoomDTO insertRoom(RoomDTO f) {
		return RoomConverter.convertToDto(this.roomdao.save(RoomConverter.convertToRoom(f)));
	}

	public void update(RoomDTO f) {
		if (roomdao.findOne(f.getId()) != null)
			this.roomdao.save(RoomConverter.convertToRoom(f));

	}

	public List<RoomDTO> getAllByFloor(FloorDTO f) {
		List<Room> rooms = (List<Room>) roomdao.findByFloor(FloorConverter.convertToFloor(f));
		List<RoomDTO> toReturn= new ArrayList<>();
		rooms.forEach(r->toReturn.add(RoomConverter.convertToDto(r)));
		return toReturn;

	}

	public RoomDTO findByPrimaryKey(long id) {
		return RoomConverter.convertToDto(this.roomdao.findOne(id));
	}

}