package main.model;


public class Expar {
	private int id;
	private String commento;

public Expar (int id, String commento) {
this.id=id;
this.commento=commento;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCommento() {
	return commento;
}

public void setCommento(String commento) {
	this.commento = commento;
}
}