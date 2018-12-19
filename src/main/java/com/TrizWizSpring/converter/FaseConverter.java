package com.TrizWizSpring.converter;

import com.TrizWizSpring.dto.FaseDTO;
import com.TrizWizSpring.model.Fase;

public class FaseConverter {

	public static FaseDTO convertToDto(Fase f) {
		FaseDTO fase= new FaseDTO();
		fase.setIdFase(f.getIdFase());
		fase.setTipologia(f.getTipologia());
		fase.setMacro(MacroConverter.convertToDto(f.getMacro()));
		return fase;
	}
	
	public static Fase convertToFase(FaseDTO f) {
		Fase fase= new Fase();
		fase.setIdFase(f.getIdFase());
		fase.setTipologia(f.getTipologia());
		fase.setMacro(MacroConverter.convertToMacro(f.getMacro()));
		return fase;
	}
}
