package com.AmebaDevices.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Room", uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
public class Room {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String nomeRoom;

	@Column
	private String descrizione;

	@ManyToOne
	@JoinColumn (name ="idfloor")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Floor floor;

}
