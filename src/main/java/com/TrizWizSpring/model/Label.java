package com.TrizWizSpring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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

@Table(name="labels",  uniqueConstraints = {@UniqueConstraint(columnNames={"idLabels", "nome"})})

@NoArgsConstructor
public class Label {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idLabels;
	
	@Column (length = 45)
	@NotNull
	private String nome;
	
	/*
	@ManyToMany(mappedBy="projects")
	private Set<items> itemss= new HashSet<>();	
	*/
	////
//	@Override
//	public String getId() {
//		return String.valueOf(this.id);
//	}
//
//	@Override
//	public Element getElement() {
//		Element toReturn = new Element(this.getClass().getSimpleName().toLowerCase());
//		toReturn.setAttribute(new Attribute("id", this.getId()));
//		toReturn.addContent(new Element("nome").setText(this.getNome()));
//		toReturn.addContent(new Element("cognome").setText(this.getCognome()));
//		toReturn.addContent(new Element("username").setText(this.getUsername()));
//		toReturn.addContent(new Element("datanascita").setText(this.getDataNascita()));
//		Element buildingsFather = new Element("buildings");
//		Element buildingsElement;
//		BuildingService bs = new BuildingService();
//		List<Building> buildings = bs.getAll(this.username);
//		for (int i = 0; i < buildings.size(); i++) {
//			buildingsElement = buildings.get(i).getElement();
//			buildingsFather.addContent(buildingsElement);
//		}
//		toReturn.addContent(buildingsFather);
//		return toReturn;
//	}

}
