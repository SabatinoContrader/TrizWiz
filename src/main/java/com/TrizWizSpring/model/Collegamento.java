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

@Table(name="Collegamento",  uniqueConstraints = {@UniqueConstraint(columnNames={"idCollegamento", "commento"})})

@NoArgsConstructor
public class Collegamento {

		@Id
		@Column
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long idCollegamento;
		
		@Column (length = 45)
		@NotNull
		private String commento;
		
		@ManyToOne
		@JoinColumn (name = "fase")
	    private Fase fase;

       @ManyToOne
       @JoinColumn (name = "tool")
         private Tool tool;

}
