package com.virtualpairprogrammers.model;

public class Matrix {
	private int paramID1;
	private int paramID2;
	private int principleId;
	private String note;
	private String campo1;
	
//costruttore
public Matrix (int paramID1, int paramID2,int principleId, String note, String campo1) {
	this.paramID1=paramID1;
	this.paramID2=paramID2;
	this.principleId=principleId;
	this.note=note;
	this.campo1=campo1;
	
}

public int getParamID1() {
	return paramID1;
}

public void setParamID1(int paramID1) {
	this.paramID1 = paramID1;
}

public int getParamID2() {
	return paramID2;
}

public void setParamID2(int paramID2) {
	this.paramID2 = paramID2;
}

public int getPrincipleId() {
	return principleId;
}

public void setPrincipleId(int principleId) {
	this.principleId = principleId;
}

public String getNote() {
	return note;
}

public void setNote(String note) {
	this.note = note;
}

public String getCampo1() {
	return campo1;
}

public void setCampo1(String campo1) {
	this.campo1 = campo1;
}
}