package com.TrizWizSpring.dto;

public class utentiLocaliDTO {

	private String nomeLogin;
	private String passwordLogin;
	private String nome;
	private String cognome;
	private Integer ruolo;

	public utentiLocaliDTO() {

	}

	public utentiLocaliDTO(String nomeLogin, String passwordLogin, String nome, String cognome, Integer ruolo) {
	
		this.nomeLogin = nomeLogin;
		this.passwordLogin = passwordLogin;
		this.nome = nome;
		this.cognome = cognome;
		this.ruolo = ruolo;
	}

	public String getNomeLogin() {
		return nomeLogin;
	}

	public void setNomeLogin(String nomeLogin) {
		this.nomeLogin = nomeLogin;
	}

	public String getPasswordLogin() {
		return passwordLogin;
	}

	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
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

	public Integer getRuolo() {
		return ruolo;
	}

	public void setRuolo(Integer ruolo) {
		this.ruolo = ruolo;
	}



}
