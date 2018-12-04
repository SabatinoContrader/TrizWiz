package com.virtualpairprogrammers.model;


import org.jdom2.Element;

public class Item implements Buildable {
	private String id, categoria,modello,marca, descrizione;
	
	public Item(String id, String categoria, String marca, String modello, String descrizione) {
	
		this.id = id;
		this.categoria = categoria;
		this.modello = modello;
		this.marca = marca;
		this.descrizione = descrizione;
	}
	
	public Item() {
		
	}
	
	@Override
	public String getId() {
		return String.valueOf(this.id);
	}
	
	public String getCategoria() {
		return this.categoria;
	}
	
	public String getModello() {
		return this.modello;
	}
	
	public String getMarca() {
		return this.marca;
	}
	
	public String getDescrizione() {
		return this.descrizione;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public void setModello(String modello) {
		this.modello = modello;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String toString() {
		return "id: " + id + 
				"\nModello: " + modello + 
	        	"\nMarca: " +marca + 
	        	"\nCategoria: "+ categoria +
	        	"\nDescrizione: " + descrizione;
	 }
	 
	 public boolean equals(Object o) {
		 if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        Item i = (Item) o;
	        return id == i.id&&modello.equals(i.modello)&&categoria.equals(i.categoria)&&marca.equals(i.marca)&&descrizione.equals(i.descrizione);
	 }
	 
	 @Override
	 public Element getElement() {
		 // TODO Auto-generated method stub
		 return null;
	}
}

