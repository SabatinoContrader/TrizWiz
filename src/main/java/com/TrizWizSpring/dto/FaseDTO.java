package com.TrizWizSpring.dto;

public class FaseDTO {
	private long idMacro;
	private String tipologia;
	
	private MacroDTO macro;
	
	public FaseDTO() {
		
	}

	public FaseDTO(long idMacro, String tipologia, MacroDTO macro) {

		this.idMacro = idMacro;
		this.tipologia = tipologia;
	    this.macro = macro;
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

	public MacroDTO getMacro() {
		return macro;
	}

	public void setMacro(MacroDTO macro) {
		this.macro = macro;
	}

	@Override
	public String toString() {
		return "FaseDTO [idMacro=" + idMacro + ", tipologia=" + tipologia + ", macro=" + macro + "]";
	}
	
	
}