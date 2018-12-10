package com.AmebaDevices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Item {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String seriale;
	
	@Column
	private String consumoEnergetico;
	
	@ManyToOne
	@JoinColumn (name ="idroom")
	private Room room;
	
	@ManyToOne
	@JoinColumn (name ="iditemtype")
	private ItemType itemType;
	
	@ManyToOne
	@JoinColumn (name="idthing")
	private Thing thing;
	

}
