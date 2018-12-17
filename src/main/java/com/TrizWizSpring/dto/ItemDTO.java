package com.TrizWizSpring.dto;

public class ItemDTO {
	
	private long idItems;
	private String commento;
	private TrizCustomerDTO idCustomer;
	
	public ItemDTO() {
		
	}
	
	public ItemDTO(long idItems, String commento, TrizCustomerDTO idCustomer) {
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
	public TrizCustomerDTO getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(TrizCustomerDTO idCustomer) {
		this.idCustomer = idCustomer;
	}

	
}
