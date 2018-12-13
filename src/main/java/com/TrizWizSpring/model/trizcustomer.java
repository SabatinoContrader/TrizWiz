package com.TrizWizSpring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Getter
@Setter
@Entity
@NoArgsConstructor
/*
@Table(name="trizcustomer",  uniqueConstraints = {@UniqueConstraint(columnNames={"idCustomer", "nome" , "cognome"})})
*/
@Table(name="trizcustomer",  uniqueConstraints = {@UniqueConstraint(columnNames={"idCustomer", "nome" , "cognome"})})
public class trizcustomer {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idCustomer;

	@Column (length = 45)
	@NotNull
	private String nome;
	@Column (length = 45)
	@NotNull
	private String cognome;


	@ManyToOne 
	@JoinColumn (name ="username")
	private utentiLocali username;
}