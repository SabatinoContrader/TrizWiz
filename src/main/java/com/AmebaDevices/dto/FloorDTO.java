package com.AmebaDevices.dto;


public class FloorDTO {
	private long id;
	private String nomeFloor;
	private String descrizione;
	private BuildingDTO building;

	public FloorDTO() {
	}

	public FloorDTO(long id, String nomeFloor, String descrizione, BuildingDTO building) {
		super();
		this.id = id;
		this.nomeFloor = nomeFloor;
		this.descrizione = descrizione;
		this.building = building;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeFloor() {
		return nomeFloor;
	}

	public void setNomeFloor(String nomeFloor) {
		this.nomeFloor = nomeFloor;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public BuildingDTO getBuilding() {
		return building;
	}

	public void setBuilding(BuildingDTO building) {
		this.building = building;
	}

}
