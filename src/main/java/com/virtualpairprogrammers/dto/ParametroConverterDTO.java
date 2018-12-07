package com.virtualpairprogrammers.dto;

import com.virtualpairprogrammers.dao.VparametroDAO;
import com.virtualpairprogrammers.model.Parametro;


public class ParametroConverterDTO {

	public static ParametroDTO converterParametroToDTO(Parametro parametro) { //converter parametro --> parametroDTO
		
		ParametroDTO parametroDTO= new ParametroDTO();
			if (parametro!=null) {
				
				parametroDTO.setIdDTO(parametro.getId());
				parametroDTO.setNomeParametroDTO(parametro.getNomeParametro());
				parametroDTO.setNomeParametroItaDTO(parametro.getNomeParametroIta());
				parametroDTO.setDescrizioneDTO(parametro.getDescrizione());
				parametroDTO.setDescrizioneItaDTO(parametro.getDescrizioneIta());
				parametroDTO.setIconaDTO(parametro.getIcona());
				
			}
		
		return parametroDTO;
	}
	
	
	
	public static Parametro converterParametroDTOToParametro(ParametroDTO parametroDTO) { //converter parametroDTO --> parametro
		
		Parametro parametro=new Parametro();
		VparametroDAO vParametroDAO= new VparametroDAO();
		
		if(parametroDTO!=null) {
		
			String id = Integer.toString(parametroDTO.getIdDTO());
			parametro= vParametroDAO.getParametroID(id);
		
		}
		
		return parametro;
		
	}
	
	

	public static ParametroNomeDTO converterNomeParametroToDTO(Parametro parametro) { //converter parametro --> parametroNomeDTO
		
		ParametroNomeDTO parametroNomeDTO= new ParametroNomeDTO();
		if (parametro!=null) {
			parametroNomeDTO.setIdDTO(parametro.getId());
			parametroNomeDTO.setNomeParametroDTO(parametro.getNomeParametro());
		}
		
		return parametroNomeDTO;	
		
	}
	
	
public static Parametro converterParametroNomeDTOToParametro(ParametroDTO parametroNomeDTO) { //converter parametroNomeDTO --> parametro
		
		Parametro parametro=new Parametro();
		VparametroDAO vParametroDAO= new VparametroDAO();
		
		if(parametroNomeDTO!=null) {
		
			String id = Integer.toString(parametroNomeDTO.getIdDTO());
			parametro= vParametroDAO.getParametroID(id);
		
		}
		
		return parametro;
		
	}
	
	
}
