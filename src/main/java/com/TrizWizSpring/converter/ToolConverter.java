package com.TrizWizSpring.converter;

import com.TrizWizSpring.dto.ToolDTO;
import com.TrizWizSpring.model.Tool;

public class ToolConverter {

	public static ToolDTO convertToDto(Tool t) {

		ToolDTO toolDTO= new ToolDTO();
		toolDTO.setIdTool(t.getIdTool());
		toolDTO.setTipologia(t.getTipologia());
		toolDTO.setFase(FaseConverter.convertToDto(t.getFase()));
		return toolDTO;
			}
	
	public static Tool convertToTool(ToolDTO t) {
		Tool tool= new Tool();
		tool.setIdTool(t.getIdTool());
		tool.setTipologia(t.getTipologia());
		tool.setFase(FaseConverter.convertToFase(t.getFase()));
		return tool;
	}
}
