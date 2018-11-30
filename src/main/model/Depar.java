package main.model;

public class Depar {
private int id;
private int parId;
private int exld;

public Depar (int id, int parId,int exld) {
	this.id=id;
	this.parId=parId;
	this.exld=exld;
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getParId() {
	return parId;
}

public void setParId(int parId) {
	this.parId = parId;
}

public int getExld() {
	return exld;
}

public void setExld(int exld) {
	this.exld = exld;
}
}