package com.virtualpairprogrammers.model;

public class ExpParametro {

	private int id;
	private String commento;
	
	public ExpParametro() {
		
	}
	
	public ExpParametro(int id, String commento) {
		
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
