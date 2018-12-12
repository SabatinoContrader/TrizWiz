package com.AmebaDevices.converter;

import com.AmebaDevices.dto.utentiLocaliDTO;
import com.AmebaDevices.model.utentiLocali;

public class utentiLocaliConverter {

	public static utentiLocaliDTO utentiLocaliDto(utentiLocali c) {
		utentiLocaliDTO utentiLocaliDTO=new utentiLocaliDTO();
		utentiLocaliDTO.setId(c.getId());
		utentiLocaliDTO.setnomeLogin(c.getNomeLogin());
		utentiLocaliDTO.setpasswordLogin(c.getPasswordLogin());
		utentiLocaliDTO.setruolo(c.getRuolo());
		return utentiLocaliDTO;
	}
	
	public static utentiLocali convertToutentiLocali(utentiLocaliDTO c) {
		utentiLocali utentiLocali= new utentiLocali();
		utentiLocali.setId(c.getId());
		utentiLocali.setNomeLogin(c.getnomeLogin());
		utentiLocali.setPasswordLogin(c.getpasswordLogin());
		utentiLocali.setRuolo(c.ruolo());
		return utentiLocali;
	}


	
	
	
	
}
