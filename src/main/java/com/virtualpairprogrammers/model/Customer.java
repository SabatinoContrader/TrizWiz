package com.virtualpairprogrammers.model;


import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Element;

import com.virtualpairprogrammers.service.BuildingService;


public class Customer implements Buildable {

	private int id;
	private String nome;
	private String cognome;
	private String dataNascita;
	private String email;
	private String username;
	private String password;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(String nome,String cognome, String dataNascita,String email, String username, String password){
		this.nome=nome;
		this.cognome=cognome;
		this.dataNascita=dataNascita;
		this.email=email;
		this.username=username;
		this.password=password;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getId() {
		return String.valueOf(this.id);
	}
	
	
	@Override
	public Element getElement() {
		Element toReturn =new Element(this.getClass().getSimpleName().toLowerCase());
		toReturn.setAttribute(new Attribute("id", this.getId()));
		toReturn.addContent(new Element("nome").setText(this.getNome()));
		toReturn.addContent(new Element("cognome").setText(this.getCognome()));
		toReturn.addContent(new Element("username").setText(this.getUsername()));
		toReturn.addContent(new Element("datanascita").setText(this.getDataNascita()));
		Element buildingsFather = new Element("buildings");
		Element buildingsElement;
		BuildingService bs = new BuildingService();
		List <Building> buildings = bs.getAll(this.username);
		for (int i=0 ; i < buildings.size(); i++) {
			buildingsElement = buildings.get(i).getElement();
			buildingsFather.addContent(buildingsElement);
		} 
		toReturn.addContent(buildingsFather);
		return toReturn;
	}
	
	
	
}
