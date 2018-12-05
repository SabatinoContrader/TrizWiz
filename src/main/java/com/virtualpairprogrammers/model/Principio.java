package com.virtualpairprogrammers.model;


public class Principio {
private int id;
private String nomePrincipio;
private String nomePrincipioIta;
private String domande;
private String steps;
private String esempi;
//costruttore
public Principio(){}

public Principio(int id, String nomePrincipio,String nomePrincipioIta, String domande, String steps, String esempi) {
	this.id=id;
	this.nomePrincipio=nomePrincipio;
	this.nomePrincipioIta=nomePrincipioIta;
	this.domande=domande;
	this.steps=steps;
	this.esempi=esempi;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNomePrincipio() {
	return nomePrincipio;
}
public void setNomePrincipio(String nomePrincipio) {
	this.nomePrincipio = nomePrincipio;
}
public String getNomePrincipioIta() {
	return nomePrincipioIta;
}
public void setNomePrincipioIta(String nomePrincipioIta) {
	this.nomePrincipioIta = nomePrincipioIta;
}
public String getDomande() {
	return domande;
}
public void setDomande(String domande) {
	this.domande = domande;
}
public String getSteps() {
	return steps;
}
public void setSteps(String steps) {
	this.steps = steps;
}
public String getEsempi() {
	return esempi;
}
public void setEsempi(String esempi) {
	this.esempi = esempi;
}

}