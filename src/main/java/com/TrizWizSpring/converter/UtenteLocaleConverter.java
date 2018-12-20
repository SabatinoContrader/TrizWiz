package com.TrizWizSpring.converter;

import com.TrizWizSpring.dto.UtenteLocaleWithIdDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.model.utentiLocali;

public class UtenteLocaleConverter {

	public static utentiLocaliDTO convertToDto(utentiLocali c) {
		utentiLocaliDTO utentiLocaliDTO=new utentiLocaliDTO();
		//utentiLocaliDTO.setId(c.getId());
		utentiLocaliDTO.setNomeLogin(c.getNomeLogin());
		//utentiLocaliDTO.setPasswordLogin(c.getPasswordLogin());
		utentiLocaliDTO.setNome(c.getNome());
		utentiLocaliDTO.setCognome(c.getCognome());
		utentiLocaliDTO.setRuolo(c.getRuolo());
		return utentiLocaliDTO;
	}
	
	public static utentiLocali convertToutentiLocali(utentiLocaliDTO c) {
		utentiLocali utentiLocali= new utentiLocali();
		//utentiLocali.setId(c.getId());
		utentiLocali.setNomeLogin(c.getNomeLogin());
		//utentiLocali.setPasswordLogin(c.getPasswordLogin());
		utentiLocali.setNome(c.getNome());
		utentiLocali.setCognome(c.getCognome());
		utentiLocali.setRuolo(c.getRuolo());
		return utentiLocali;
	}
	
	public static UtenteLocaleWithIdDTO convertToDtoWithId(utentiLocali c) {
		
		UtenteLocaleWithIdDTO utentewithID= new UtenteLocaleWithIdDTO();
		
		//utentewithID.setId(c.getId());
		if (c.getNomeLogin()!=null)
		utentewithID.setNomeLogin(c.getNomeLogin());
		if(c.getPasswordLogin()!=null)
		utentewithID.setPasswordLogin(c.getPasswordLogin());
		if(c.getNome()!=null)
		utentewithID.setNome(c.getNome());
		if(c.getCognome()!=null)
		utentewithID.setCognome(c.getCognome());
		utentewithID.setRuolo(c.getRuolo());
		return utentewithID;
	}

public static utentiLocali convertToUtentiLocali(UtenteLocaleWithIdDTO c) {
		
		utentiLocali utenti= new utentiLocali();
		
		//utenti.setId(c.getId());
		if (c.getNomeLogin()!=null)
			utenti.setNomeLogin(c.getNomeLogin());
		if(c.getPasswordLogin()!=null)
			utenti.setPasswordLogin(c.getPasswordLogin());
		if(c.getNome()!=null)
			utenti.setNome(c.getNome());
		if(c.getCognome()!=null)
			utenti.setCognome(c.getCognome());
		utenti.setRuolo(c.getRuolo());
		return utenti;
	}
	


	
	
	
	
}
