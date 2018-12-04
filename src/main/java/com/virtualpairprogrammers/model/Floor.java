package com.virtualpairprogrammers.model;

import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Element;

import com.virtualpairprogrammers.service.FloorService;
import com.virtualpairprogrammers.service.RoomService;

public class Floor implements Buildable {

	private String id;
	private String nomeFloor;
	private String descrizione;
	private String idBuilding; // l'id del building associato al floor

	public Floor() {
	}

	public Floor(String nomeFloor, String descrizione) {
		this.nomeFloor = nomeFloor;
		this.descrizione = descrizione;
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

	public String getIdBuilding() {
		return idBuilding;
	}

	public void setIdBuilding(String idBuilding) {
		this.idBuilding = idBuilding;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public Element getElement() {
		Element toReturn =new Element(this.getClass().getSimpleName().toLowerCase());
		toReturn.setAttribute(new Attribute("id", this.getId()));
		toReturn.addContent(new Element("nome").setText(this.getNomeFloor()));
		toReturn.addContent(new Element("descrizione").setText(this.getDescrizione()));	
		Element roomsFather = new Element("rooms");
		Element roomsElement;
		RoomService rs = new RoomService();
		if (Integer.parseInt(id)!= 0) {
		List <Room> rooms = rs.getAllByFloor((Integer.parseInt(id)));
		for (int i=0 ; i < rooms.size(); i++) {
			roomsElement = rooms.get(i).getElement();
			roomsFather.addContent(roomsElement);
		} 
		
		toReturn.addContent(roomsFather);
		}
		return toReturn;
		
	}

}
