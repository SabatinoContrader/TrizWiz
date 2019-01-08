package com.TrizWizSpring.dto;

public class ToolDTO {
	private long idTool;
	private String tipologia;
public ToolDTO() {
		
	}

public ToolDTO(long idTool, String tipologia) {
	this.idTool = idTool;
	this.tipologia = tipologia;
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

@Override
public String toString() {
	return "ToolDTO [idTool=" + idTool + ", tipologia=" + tipologia + "]";
}
}
	