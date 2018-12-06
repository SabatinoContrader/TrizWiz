package com.virtualpairprogrammers.model;

public class CategorieStandard {
	private int id;
	private String nome;
	private String nomeIng;

	public CategorieStandard() {
	}

	public CategorieStandard(int id, String nome, String nomeIng) {

		this.id = id;
		this.nome = nome;
		this.nomeIng = nomeIng;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeIng() {
		return nomeIng;
	}

	public void setNomeIng(String nomeIng) {
		this.nomeIng = nomeIng;
	}

	@Override
	public String toString() {
		return "CategorieStandard [id=" + id + ", nome=" + nome + ", nomeIng=" + nomeIng + "]";
	}

}
