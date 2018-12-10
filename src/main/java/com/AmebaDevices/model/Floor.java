package com.AmebaDevices.model;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.jdom2.Attribute;
import org.jdom2.Element;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
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

@Entity
@Getter
@Setter
@Table(name="floor",  uniqueConstraints = {@UniqueConstraint(columnNames={"id"})})
@NoArgsConstructor
@AllArgsConstructor
public class Floor {

	@Id
	@Column
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Column (length = 45)
	private String nomeFloor;
	
	@NotNull
	@Column (length = 100)
	private String descrizione;
	
	@ManyToOne 
	@JoinColumn (name ="idbuilding")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Building building; 
}
