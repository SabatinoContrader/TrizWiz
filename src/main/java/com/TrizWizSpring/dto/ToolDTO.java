package com.TrizWizSpring.dto;

public class ToolDTO {
	private long idTool;
	private String tipologia;
	
	private FaseDTO fase;
	
public ToolDTO() {
		
	}

public ToolDTO(long idTool, String tipologia, FaseDTO fase) {
	this.idTool = idTool;
	this.tipologia = tipologia;
	this.fase = fase;
}

public long getIdTool() {
	return idTool;
}

public void setIdTool(long idTool) {
	this.idTool = idTool;
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
	return "ToolDTO [idTool=" + idTool + ", tipologia=" + tipologia + ", fase=" + fase + "]";
}
}
	