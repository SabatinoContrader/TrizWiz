package com.virtualpairprogrammers.model;

public class SottoCategorie {
	private int id;
	private String descrizione;
	private int idStandard;
	private String descrizioneIta;

	public SottoCategorie() {
	}

	public SottoCategorie(int id, String descrizione, int idStandard, String descrizioneIta) {

		this.id = id;
		this.descrizione = descrizione;
		this.idStandard = idStandard;
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

	public int getIdStandard() {
		return idStandard;
	}

	public void setIdStandard(int idStandard) {
		this.idStandard = idStandard;
	}

	public String getDescrizioneIta() {
		return descrizioneIta;
	}

	public void setDescrizioneIta(String descrizioneIta) {
		this.descrizioneIta = descrizioneIta;
	}

	@Override
	public String toString() {
		return "SottoCategorie [id=" + id + ", descrizione=" + descrizione + ", idStandard=" + idStandard
				+ ", descrizioneIta=" + descrizioneIta + "]";
	}

}
