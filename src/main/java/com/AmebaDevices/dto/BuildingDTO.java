package com.AmebaDevices.dto;

public class BuildingDTO {

	private long id;
	private String address;
	private String city;
	private String cap;
	private long interno;
	private CustomerDTO owner;
	private CustomerDTO installer;

	public BuildingDTO() {
	}

	public BuildingDTO(long buildingId, String indirizzo, String citta, String cap, long interno, CustomerDTO owner, CustomerDTO installer) {
		super();
		this.id = buildingId;
		this.address = indirizzo;
		this.city = citta;
		this.cap = cap;
		this.interno = interno;
		this.owner=owner;
		this.installer = installer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public long getInterno() {
		return interno;
	}

	public void setInterno(long interno) {
		this.interno = interno;
	}

	public CustomerDTO getOwner() {
		return owner;
	}

	public void setOwner(CustomerDTO owner) {
		this.owner = owner;
	}

	public CustomerDTO getInstaller() {
		return installer;
	}

	public void setInstaller(CustomerDTO installer) {
		this.installer = installer;
	}
	
	

	
}
