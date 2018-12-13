package com.TrizWizSpring.dto;

public class utentiLocaliDTO {

	private long id;
	private String nomeLogin;
	private String passwordLogin;
	private Integer ruolo;

	public utentiLocaliDTO() {

	}

	public utentiLocaliDTO(long id, String nomeLogin, String passwordLogin, Integer ruolo) {
		this.id = id;
		this.nomeLogin = nomeLogin;
		this.passwordLogin = passwordLogin;
		this.ruolo = ruolo;
	}

	public long getId() {
		return id;
	}


	public String getnomeLogin() {
		return nomeLogin;
	}

	public String getpasswordLogin() {
		return passwordLogin;
	}

	public Integer ruolo() {
		return ruolo;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setnomeLogin(String nomeLogin) {
		this.nomeLogin = nomeLogin;
	}

	public void setpasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}

	public void setruolo(Integer ruolo) {
		this.ruolo = ruolo;
	}

}
