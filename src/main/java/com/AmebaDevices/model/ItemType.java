package com.AmebaDevices.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.AmebaDevices.dto.ItemTypeDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ItemType  {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	@NotNull
	private String categoria;
	
	@Column
	@NotNull
	private String modello; 
	
	@Column
	@NotNull
	private String marca;
	
	@Column
	@NotNull
	private String descrizione;

	
	/*@ManyToOne
	@JoinColumn (name ="iditemtype")
	private Item item;*/
	
	/*@ManyToOne
	@JoinColumn(name="idroom")
	private Room room;*/
	

	 

}

