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



import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table (name="building", uniqueConstraints = {@UniqueConstraint(columnNames = {"address", "interno", "cap", "city"})})
public class Building{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column 
	private long id;
	
	@Column (length = 45)
	@NotNull
	private String address;
	
	@Column (length = 45)
	@NotNull
	private String city;
	
	@Column (length = 5)
	@NotNull
	private String cap;
	
	@Column 
	@NotNull
	private long interno;
	
	@ManyToOne
	@JoinColumn (name = "owner")
    private Customer owner; 
	
	@ManyToOne
	@JoinColumn (name = "installer")
    private Customer installer; 
		
} 

