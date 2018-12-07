package com.virtualpairprogrammers.dto;

public class ParametroDTO {

	private int idDTO;
	private String nomeParametroDTO;
	private String nomeParametroItaDTO;
	private String descrizioneDTO;
	private String descrizioneItaDTO;
	private String iconaDTO;
	

//costruttore
	public ParametroDTO(){
		
	}

	public ParametroDTO(int idDTO, String nomeParametroDTO,String nomeParametroItaDTO, String descrizioneDTO, String descrizioneItaDTO, String iconaDTO) {
		
		this.idDTO=idDTO;
		this.nomeParametroDTO=nomeParametroDTO;
		this.nomeParametroItaDTO=nomeParametroItaDTO;
		this.descrizioneDTO=descrizioneDTO;
		this.descrizioneItaDTO=descrizioneItaDTO;
		this.iconaDTO=iconaDTO;
	
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

	public String getNomeParametroItaDTO() {
		return nomeParametroItaDTO;
	}

	public void setNomeParametroItaDTO(String nomeParametroItaDTO) {
		this.nomeParametroItaDTO = nomeParametroItaDTO;
	}

	public String getDescrizioneDTO() {
		return descrizioneDTO;
	}

	public void setDescrizioneDTO(String descrizioneDTO) {
		this.descrizioneDTO = descrizioneDTO;
	}

	public String getDescrizioneItaDTO() {
		return descrizioneItaDTO;
	}

	public void setDescrizioneItaDTO(String descrizioneItaDTO) {
		this.descrizioneItaDTO = descrizioneItaDTO;
	}

	public String getIconaDTO() {
		return iconaDTO;
	}

	public void setIconaDTO(String iconaDTO) {
		this.iconaDTO = iconaDTO;
	}
	
	
}
