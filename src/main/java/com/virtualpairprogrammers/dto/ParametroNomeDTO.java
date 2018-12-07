package com.virtualpairprogrammers.dto;

public class ParametroNomeDTO {

	
	private int idDTO;
	private String nomeParametroDTO;
	
	public ParametroNomeDTO(){
		
	}
	
	public ParametroNomeDTO(int idDTO, String nomeParametroDTO) {
		this.idDTO=idDTO;
		this.nomeParametroDTO=nomeParametroDTO;
	}

	public int getIdDTO() {
		return idDTO;
	}

	public void setIdDTO(int idDTO) {
		this.idDTO = idDTO;
	}

	public String getNomeParametroDTO() {
		return nomeParametroDTO;
	}

	public void setNomeParametroDTO(String nomeParametroDTO) {
		this.nomeParametroDTO = nomeParametroDTO;
	}
}
