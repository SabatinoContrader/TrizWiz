package com.AmebaDevices.dto;

import com.AmebaDevices.model.ItemType;

public class ThingDTO {

	private long id;
	private double prezzo;
	private int numUscite; //potenze di 2
	private BuildingDTO building;
	
	public ThingDTO() {
	}
	public ThingDTO(long id, double prezzo, int numUscite, BuildingDTO building) {
		super();
		this.id = id;
		this.prezzo = prezzo;
		this.numUscite = numUscite;
		this.building = building;
	}
	public ThingDTO( double prezzo, int numUscite) {
		this.prezzo = prezzo;
		this.numUscite = numUscite;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public int getNumUscite() {
		return numUscite;
	}
	public void setNumUscite(int numUscite) {
		this.numUscite = numUscite;
	}
	public BuildingDTO getBuilding() {
		return building;
	}
	public void setBuilding(BuildingDTO building) {
		this.building = building;
	}
	
	
	
	
}
