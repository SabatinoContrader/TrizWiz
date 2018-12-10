package com.AmebaDevices.dto;

import com.AmebaDevices.model.Floor;

public class RoomDTO {
	
	private long id;
	private String nomeRoom;
	private String descrizione;
	private FloorDTO floor;
	
	public RoomDTO() {
	}
	
	public RoomDTO(long id, String nomeRoom, String descrizione, FloorDTO floor) {
		super();
		this.id = id;
		this.nomeRoom = nomeRoom;
		this.descrizione = descrizione;
		this.floor = floor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeRoom() {
		return nomeRoom;
	}

	public void setNomeRoom(String nomeRoom) {
		this.nomeRoom = nomeRoom;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public FloorDTO getFloor() {
		return floor;
	}

	public void setFloor(FloorDTO floor) {
		this.floor = floor;
	}
	
	
	
	

}
