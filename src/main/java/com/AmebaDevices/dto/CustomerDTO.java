package com.AmebaDevices.dto;

public class CustomerDTO {

	private long id;
	private String nome;
	private String cognome;
	private String dataNascita;
	private String email;
	private String username;
	private String password;
	private Integer userRole;

	public CustomerDTO() {

	}

	public CustomerDTO(long id, String nome, String cognome, String dataNascita, String email, String username,
			String password, Integer userRole) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.email = email;
		this.username = username;
		this.password = password;
		this.userRole = userRole;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

}
