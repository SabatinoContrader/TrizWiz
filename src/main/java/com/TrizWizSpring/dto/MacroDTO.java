package com.TrizWizSpring.dto;
import com.TrizWizSpring.dto.utentiLocaliDTO;

public class MacroDTO {
	
	private long idMacro;
	private String tipologia;
	
	private utentiLocaliDTO username;
	
	public MacroDTO() {
		
	}

	public MacroDTO(long idMacro, String tipologia, utentiLocaliDTO username) {
		this.idMacro = idMacro;
		this.tipologia = tipologia;
		this.username = username;
	}

	public long getIdMacro() {
		return idMacro;
	}

	public void setIdMacro(long idMacro) {
		this.idMacro = idMacro;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public utentiLocaliDTO getUsername() {
		return username;
	}

	public void setUsername(utentiLocaliDTO username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "MacroDTO [idMacro=" + idMacro + ", tipologia=" + tipologia + ", username=" + username + "]";
	}
	
}