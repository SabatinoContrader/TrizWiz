package com.TrizWizSpring.dto;

public class ItemDTO {
	
	private long idItems;
	private String commento;
	
	public ItemDTO() {
		
	}
	
	public ItemDTO(long idItems, String commento) {
		this.idItems=idItems;
		this.commento=commento;
	}

	public long getIdItems() {
		return idItems;
	}

	public void setIdItems(long idItems) {
		this.idItems = idItems;
	}

	public String getCommento() {
		return commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}
	
	
}
