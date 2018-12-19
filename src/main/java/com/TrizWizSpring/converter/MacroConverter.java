package com.TrizWizSpring.converter;

import com.TrizWizSpring.dto.MacroDTO;
import com.TrizWizSpring.model.Macro;

public class MacroConverter {

	public static MacroDTO convertToDto(Macro m) {
		MacroDTO macro= new MacroDTO();
		macro.setIdMacro(m.getIdMacro());
		macro.setTipologia(m.getTipologia());
		macro.setUsername(UtenteLocaleConverter.convertToDto(m.getUsername()));
		return macro;
	}
	
	public static Macro convertToMacro(MacroDTO m) {
		Macro macro= new Macro();
		macro.setIdMacro(m.getIdMacro());
		macro.setTipologia(m.getTipologia());
		macro.setUsername(UtenteLocaleConverter.convertToutentiLocali(m.getUsername()));
		return macro;
	}
}