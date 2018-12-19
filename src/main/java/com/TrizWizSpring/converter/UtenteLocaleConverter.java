package com.TrizWizSpring.converter;

import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.model.utentiLocali;

public class UtenteLocaleConverter {

	public static utentiLocaliDTO convertToDto(utentiLocali c) {
		utentiLocaliDTO utentiLocaliDTO=new utentiLocaliDTO();
		//utentiLocaliDTO.setId(c.getId());
		utentiLocaliDTO.setNomeLogin(c.getNomeLogin());
		utentiLocaliDTO.setPasswordLogin(c.getPasswordLogin());
		utentiLocaliDTO.setNome(c.getNome());
		utentiLocaliDTO.setCognome(c.getCognome());
		utentiLocaliDTO.setRuolo(c.getRuolo());
		return utentiLocaliDTO;
	}
	
	public static utentiLocali convertToutentiLocali(utentiLocaliDTO c) {
		utentiLocali utentiLocali= new utentiLocali();
		//utentiLocali.setId(c.getId());
		utentiLocali.setNomeLogin(c.getNomeLogin());
		utentiLocali.setPasswordLogin(c.getPasswordLogin());
		utentiLocali.setNome(c.getNome());
		utentiLocali.setCognome(c.getCognome());
		utentiLocali.setRuolo(c.getRuolo());
		return utentiLocali;
	}

	


	
	
	
	
}
