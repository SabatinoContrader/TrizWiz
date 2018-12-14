package com.TrizWizSpring.converter;

import com.TrizWizSpring.dto.LabelDTO;
import com.TrizWizSpring.model.Label;

public class LabelConverter {
	
	public static LabelDTO convertToDto(Label l) {
		LabelDTO labelDTO = new LabelDTO();
		labelDTO.setIdLabels(l.getIdLabels());
		labelDTO.setNome(l.getNome());
		return labelDTO;
	}
	
	public static Label convertToLabel(LabelDTO l) {
		Label label = new Label();
		label.setIdLabels(l.getIdLabels());
		label.setNome(l.getNome());
		return label;
	}
}
