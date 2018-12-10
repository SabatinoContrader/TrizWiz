package com.AmebaDevices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Thing {
	
	
	@Id
	@Column
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private long id;
	
	
	@NotNull
	@Column
	@Getter
	private double prezzo;
	
	@NotNull
	@Column
	@Getter
	private int numUscite; //potenze di 2
	

	public void setNumUscite(int numUscite) {
		this.numUscite = numUscite;
		this.prezzo = 5 + numUscite;
	}
	
	
	@ManyToOne
	@JoinColumn (name="idbuilding")
	@Getter
	@Setter
	private Building building;
	
	
	
}
