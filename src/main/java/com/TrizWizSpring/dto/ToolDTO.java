package com.TrizWizSpring.dto;

public class ToolDTO {
	private long idFase;
	private String tipologia;
	
	private FaseDTO fase;
	
public ToolDTO() {
		
	}

public ToolDTO(long idFase, String tipologia, FaseDTO fase) {
	this.idFase = idFase;
	this.tipologia = tipologia;
	this.fase = fase;
}

public long getIdFase() {
	return idFase;
}

public void setIdFase(long idFase) {
	this.idFase = idFase;
}

public String getTipologia() {
	return tipologia;
}

public void setTipologia(String tipologia) {
	this.tipologia = tipologia;
}

public FaseDTO getFase() {
	return fase;
}

public void setFase(FaseDTO fase) {
	this.fase = fase;
}

@Override
public String toString() {
	return "ToolDTO [idFase=" + idFase + ", tipologia=" + tipologia + ", fase=" + fase + "]";
}
}
	