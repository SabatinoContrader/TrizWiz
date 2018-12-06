package com.virtualpairprogrammers.model;

public class Standard {
	private int id;
	private String descrizione;
	private String categorieStandard;
	private String descrizioneIta;

	public Standard() {
	}

	public Standard(int id, String descrizione, String categorieStandard, String descrizioneIta) {

		this.id = id;
		this.descrizione = descrizione;
		this.categorieStandard = categorieStandard;
		this.descrizioneIta = descrizioneIta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCategorieStandard() {
		return categorieStandard;
	}

	public void setCategorieStandard(String categorieStandard) {
		this.categorieStandard = categorieStandard;
	}

	public String getDescrizioneIta() {
		return descrizioneIta;
	}

	public void setDescrizioneIta(String descrizioneIta) {
		this.descrizioneIta = descrizioneIta;
	}

	@Override
	public String toString() {
		return "Standard [id=" + id + ", descrizione=" + descrizione + ", categorieStandard=" + categorieStandard
				+ ", descrizioneIta=" + descrizioneIta + "]";
	}

}
