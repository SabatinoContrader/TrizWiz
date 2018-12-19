package com.TrizWizSpring.dto;

public class FaseDTO {
	private long idFase;
	private String tipologia;
	
	private MacroDTO macro;
	
	public FaseDTO() {
		
	}

	public FaseDTO(long idFase, String tipologia, MacroDTO macro) {

		this.idFase = idFase;
		this.tipologia = tipologia;
	    this.macro = macro;
	}

	public long getIdFase() {
		return idFase;
	}

	public void setIdFase(long idFase) {
		this.idFase = idFase;
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
		return "FaseDTO [idFase=" + idFase + ", tipologia=" + tipologia + ", macro=" + macro + "]";
	}
	
	
}