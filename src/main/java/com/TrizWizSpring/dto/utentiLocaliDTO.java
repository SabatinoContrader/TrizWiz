package com.TrizWizSpring.dto;

public class utentiLocaliDTO {

	private String nomeLogin;
	private String passwordLogin;
	private Integer ruolo;

	public utentiLocaliDTO() {

	}

	public utentiLocaliDTO(String nomeLogin, String passwordLogin, Integer ruolo) {
	
		this.nomeLogin = nomeLogin;
		this.passwordLogin = passwordLogin;
		this.ruolo = ruolo;
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
