package com.virtualpairprogrammers.model;

import java.util.ArrayList;
import java.util.List;

public class Thing {
	
	private String id;
	private String nome;
	private int numUscite; //potenze di 2
	
	private Item[] items;
	
	public Thing(int numUscite) {
		this.numUscite = numUscite;
		items = new Item[numUscite];
	}
	
	public Thing(int numUscite, String nome) {
		this.numUscite=numUscite;
		this.nome=nome;
	}

	public Thing(String id, String nome, int numUscite) {
		super();
		this.id = id;
		this.nome = nome;
		this.numUscite = numUscite;
		items = new Item[numUscite];
	}

	public Thing() {
		// TODO Auto-generated constructor stub
	}

	public int addItem(Item item) {
		int pos = -1;
		for (int i = 0 ; i < items.length; i++) {
			if (items[i] == null) {
				pos = i;
				items[i] = item;
				break;
			}
		}
		
		return pos;
	}
	
	public void removeItem(Item item) {
		for (int i=0 ; i < items.length ; i++) {
			if (items[i] != null) {
				if (items[i].getId().equals(item.getId())) {
					items[i] = null;
				}
				
			}
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumUscite() {
		return numUscite;
	}

	public void setNumUscite(int numUscite) {
		this.numUscite = numUscite;
	}

	
	public int usciteLibere() {
		int freeSlots = 0;
		for (int i = 0 ; i < items.length; i++) {
			if (items[i] == null) {
				freeSlots++;
			}
		}
		return freeSlots;
	}
	
	
	
	
}
