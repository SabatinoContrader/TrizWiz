package com.AmebaDevices.model;

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
@Getter
@Setter
@Table(name="utentiLocali",  uniqueConstraints = {@UniqueConstraint(columnNames={"nomeLogin"})})
@NoArgsConstructor
@AllArgsConstructor
public class utentiLocali {

	
	//private long id;
	@Id
	@Column
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String nomeLogin;
	@Column
	private String passwordLogin;
	@Column
	@NotNull
	private Integer ruolo;

}
