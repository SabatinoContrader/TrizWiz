package com.AmebaDevices.converter;

import com.AmebaDevices.dto.RoomDTO;
import com.AmebaDevices.model.Room;

public class RoomConverter {

	public static RoomDTO convertToDto(Room r) {
		RoomDTO room = new RoomDTO();
		room.setId(r.getId());
		room.setDescrizione(r.getDescrizione());
		room.setFloor(FloorConverter.convertToDto(r.getFloor()));
		room.setNomeRoom(r.getNomeRoom());
		return room;
	}

	public static Room convertToRoom(RoomDTO r) {
		Room room = new Room();
		room.setId((r.getId()));
		room.setDescrizione(r.getDescrizione());
		room.setFloor(FloorConverter.convertToFloor(r.getFloor()));
		room.setNomeRoom(r.getNomeRoom());
		return room;
	}

}
