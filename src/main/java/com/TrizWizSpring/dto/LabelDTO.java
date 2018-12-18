package com.TrizWizSpring.dto;

public class LabelDTO {
	
	private long idLabels;
	private String tipologia;
	private String commento;
	private ItemDTO item;
	
	public LabelDTO() {
		
	}

	public LabelDTO(long idLabels, String tipologia, String commento, ItemDTO item) {
		//super();
		this.idLabels = idLabels;
		this.tipologia = tipologia;
		this.commento = commento;
		this.item = item;
	}

	public long getIdLabels() {
		return idLabels;
	}

	public void setIdLabels(long idLabels) {
		this.idLabels = idLabels;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getCommento() {
		return commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}

	public ItemDTO getItem() {
		return item;
	}

	public void setItem(ItemDTO item) {
		this.item = item;
	}
	
}