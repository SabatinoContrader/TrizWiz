package com.virtualpairprogrammers.model;

import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Element;

import com.virtualpairprogrammers.service.ItemService;
import com.virtualpairprogrammers.service.RoomService;

public class Room implements Buildable{
	private int id;
	private String nomeRoom;
	private String descrizione;
	private String idfloor;
	
	public Room(String nomeRoom, String descrizione) {
		this.nomeRoom=nomeRoom;
		this.descrizione=descrizione;
	}
	
	public Room() {
		
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


	public String getIdFloor() {

		return idfloor;

	}

	public void setIdFloor(String idfloor) {

		this.idfloor=idfloor;

	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getId() {
		return String.valueOf(id);
	}

	@Override
	public Element getElement() {
		Element toReturn =new Element(this.getClass().getSimpleName().toLowerCase());
		toReturn.setAttribute(new Attribute("id", this.getId()));
		toReturn.addContent(new Element("nome").setText(this.getNomeRoom()));
		toReturn.addContent(new Element("descrizione").setText(this.getDescrizione()));	
		/*Element itemsFather = new Element("items");
		Element itemsElement;
		ItemService is = new ItemService();
		if (id!= 0) {
		List <Item> items = is.getAllByRoom(id);
		for (int i=0 ; i < items.size(); i++) {
			itemsElement = items.get(i).getElement();
			itemsFather.addContent(itemsElement);
		} 
		
		toReturn.addContent(itemsFather);
		}*/
		return toReturn;
	}

}
