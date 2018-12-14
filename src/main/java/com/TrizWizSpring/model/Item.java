package com.TrizWizSpring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="items",  uniqueConstraints = {@UniqueConstraint(columnNames={"idItems", "commento"})})
@NoArgsConstructor

public class Item {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idItems;
	

	
	@Column (length = 45)
	@NotNull
	private String commento;
	
	
	@ManyToOne
	@JoinColumn (name = " idCustomer")
    private trizcustomer idCustomer; 
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name= "Cartella",
			joinColumns= { @JoinColumn(name="idItems")},
			inverseJoinColumns= {@JoinColumn(name="idLabels")}
			)
	Set<Label> projects= new HashSet<>();

	
	}
