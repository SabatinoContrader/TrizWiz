package com.TrizWizSpring.converter;

import com.TrizWizSpring.dto.ToolDTO;
import com.TrizWizSpring.model.Tool;

public class ToolConverter {

	public static ToolDTO convertToDto(Tool t) {
		ToolDTO tool= new ToolDTO();
		tool.setIdTool(t.getIdTool());
		tool.setTipologia(t.getTipologia());
		tool.setFase(FaseConverter.convertToDto(t.getFase()));
		return tool;
	}
	
	public static Tool convertToTool(ToolDTO t) {
		Tool tool= new Tool();
		tool.setIdTool(t.getIdTool());
		tool.setTipologia(t.getTipologia());
		tool.setFase(FaseConverter.convertToFase(t.getFase()));
		return tool;
	}
}
