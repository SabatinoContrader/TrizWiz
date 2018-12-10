package com.virtualpairprogrammers.model;

import java.util.ArrayList;
import java.util.List;

public class Parametro {
	private int id;
	private String nomeParametro;
	private String nomeParametroIta;
	private String descrizione;
	private String descrizioneIta;
	private String icona;
	private List<ExpParametro> esperienza;

//costruttore
	public Parametro(){
		this.esperienza=new ArrayList<ExpParametro>();
	}

	public Parametro(int id, String nomeParametro,String nomeParametroIta, String descrizione, String descrizioneIta, String icona) {
	this.id=id;
	this.nomeParametro=nomeParametro;
	this.nomeParametroIta=nomeParametroIta;
	this.descrizione=descrizione;
	this.descrizioneIta=descrizioneIta;
	this.icona=icona;
	this.esperienza=new ArrayList<ExpParametro>();
	
	
}

public List<ExpParametro> getEsperienza() {
		return esperienza;
	}

	public void setEsperienza(List<ExpParametro> esperienza) {
		this.esperienza = esperienza;
	}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNomeParametro() {
	return nomeParametro;
}

public void setNomeParametro(String nomeParametro) {
	this.nomeParametro = nomeParametro;
}

public String getNomeParametroIta() {
	return nomeParametroIta;
}

public void setNomeParametroIta(String nomeParametroIta) {
	this.nomeParametroIta = nomeParametroIta;
}

public String getDescrizione() {
	return descrizione;
}

public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
}

public String getDescrizioneIta() {
	return descrizioneIta;
}

public void setDescrizioneIta(String descrizioneIta) {
	this.descrizioneIta = descrizioneIta;
}

public String getIcona() {
	return icona;
}

public void setIcona(String icona) {
	this.icona = icona;
}
}
