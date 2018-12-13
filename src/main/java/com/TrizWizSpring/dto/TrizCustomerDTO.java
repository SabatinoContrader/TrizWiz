package com.TrizWizSpring.dto;

public class TrizCustomerDTO {

	private long idCustomer;
	private String nome;
	private String cognome;
	private utentiLocaliDTO username;
	
   //private utentiLocaliDTO username;

	public TrizCustomerDTO() {
	}

	public TrizCustomerDTO(long idCustomer, String nome, String cognome, utentiLocaliDTO username) {
	//public TrizCustomerDTO(long idCustomer, String nome, String cognome, String username) {
	//	super();
		this.idCustomer = idCustomer;
		this.nome = nome;
		this.cognome = cognome;
	//	this.username = username;
	}

	public long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
/*
	public utentiLocaliDTO getUsername() {
		return username;
	}
*/
	public utentiLocaliDTO getUsername() {
		return username;
	}

	public void setUsername(utentiLocaliDTO username) {
		this.username = username;
	}

	
	@Override
	public String toString() {
		return "TrizCustomerDTO [idCustomer=" + idCustomer + ", nome=" + nome + ", cognome=" + cognome + ", username="
				+ username + "]";
	}

}