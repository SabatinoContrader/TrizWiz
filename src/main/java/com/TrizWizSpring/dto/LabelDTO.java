package com.TrizWizSpring.dto;

public class LabelDTO {
	
	private long idLabels;
	private String nome;
	
	public LabelDTO() {
		
	}
	
	public LabelDTO (long idLabels, String nome) {
		this.idLabels=idLabels;
		this.nome=nome;
	}

	public long getIdLabels() {
		return idLabels;
	}

	public void setIdLabels(long idLabels) {
		this.idLabels = idLabels;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
