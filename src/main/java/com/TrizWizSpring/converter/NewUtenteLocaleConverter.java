package com.TrizWizSpring.converter;

import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.dto.NewUtenteLocaleDTO;
import com.TrizWizSpring.dto.UtenteLocaleWithIdDTO;
import com.TrizWizSpring.model.utentiLocali;

public class NewUtenteLocaleConverter {

	public static NewUtenteLocaleDTO convertToDto(utentiLocali c) {
		NewUtenteLocaleDTO newutenteDTO=new NewUtenteLocaleDTO();
		//utentiLocaliDTO.setId(c.getId());
		
		if(c != null) {
		newutenteDTO.setNomeLogin(c.getNomeLogin());
		newutenteDTO.setPasswordLogin(c.getPasswordLogin());
		newutenteDTO.setNome(c.getNome());
		newutenteDTO.setCognome(c.getCognome());
		newutenteDTO.setRuolo(c.getRuolo());
		}
		else {
			newutenteDTO.setRuolo(-1);
		}
		return newutenteDTO;
	}
	
	public static utentiLocali convertToutentiLocali(NewUtenteLocaleDTO c) {
		utentiLocali newutente= new utentiLocali();
		//utentiLocali.setId(c.getId());
		newutente.setNomeLogin(c.getNomeLogin());
		newutente.setPasswordLogin(c.getPasswordLogin());
		newutente.setNome(c.getNome());
		newutente.setCognome(c.getCognome());
		newutente.setRuolo(c.getRuolo());
		return newutente;
	}
	
	public static NewUtenteLocaleDTO convertToUtenteWhitIdNewUtente(UtenteLocaleWithIdDTO c) {
		NewUtenteLocaleDTO newutenteDTO=new NewUtenteLocaleDTO();
		
		newutenteDTO.setNomeLogin(c.getNomeLogin());
		newutenteDTO.setPasswordLogin(c.getPasswordLogin());
		newutenteDTO.setNome(c.getNome());
		newutenteDTO.setCognome(c.getCognome());
		newutenteDTO.setRuolo(c.getRuolo());
		
		return newutenteDTO;
		}
		
	}

	


	
	
	
	
