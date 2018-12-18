package com.TrizWizSpring.converter;

import com.TrizWizSpring.dto.LabelDTO;
import com.TrizWizSpring.model.Label;

public class LabelConverter {
	public static LabelDTO convertToDto(Label l) {
		LabelDTO labelDTO=new LabelDTO();
		labelDTO.setIdLabels(l.getIdLabels());
	    labelDTO.setTipologia(l.getTipologia());
	    labelDTO.setCommento(l.getCommento());
	    labelDTO.setItem(ItemConverter.convertToDto(l.getItem()));
		return labelDTO;
		//c
	}
	
	public static Label convertToLabel(LabelDTO l) {
		Label label = new Label();
		label.setIdLabels(l.getIdLabels());
		
		label.setTipologia(l.getTipologia());
		label.setCommento(l.getCommento());
		label.setItem(ItemConverter.convertToItem(l.getItem()));
		return label;
	}
}
