package com.TrizWizSpring.model;
import java.util.HashSet;

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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Fase",  uniqueConstraints = {@UniqueConstraint(columnNames={"idFase", "tipologia"})})

@NoArgsConstructor

public class Fase {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idFase;
	
	@Column (length = 45)
	@NotNull
	private String tipologia;
	
	@ManyToOne
	@JoinColumn (name = "macro")
    private utentiLocali macro;


}
