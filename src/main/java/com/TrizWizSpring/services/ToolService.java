package com.TrizWizSpring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrizWizSpring.converter.MacroConverter;
import com.TrizWizSpring.converter.ToolConverter;
import com.TrizWizSpring.dao.ToolDAO;
import com.TrizWizSpring.dto.ToolDTO;
import com.TrizWizSpring.model.Collegamento;
import com.TrizWizSpring.model.Tool;
import com.TrizWizSpring.model.Collegamento;
import com.TrizWizSpring.dao.CollegamentoDAO;

@Service
public class ToolService {
	
	@Autowired
	private ToolDAO toolDAO;
	@Autowired
	private CollegamentoDAO collegamentoDAO;
	
	public ToolDTO insert(ToolDTO ToolDTO) {
		Tool Tool = ToolConverter.convertToTool(ToolDTO);
		toolDAO.save(Tool);
		return ToolConverter.convertToDto(toolDAO.save(Tool));
	}
	
	public List<ToolDTO> readAll() {
		List<ToolDTO> tool = new ArrayList<>();
		toolDAO.findAll().forEach(c -> {
			tool.add(ToolConverter.convertToDto(c));
		});
		return tool;		
	}

	public ToolDTO findByPrimaryKey(long idTool) {
		return ToolConverter.convertToDto(toolDAO.findByIdTool(idTool));
	}
	
	public void delete(Long idTool) {
		Tool l = toolDAO.findOne(idTool);
		List<Collegamento> collegamenti=collegamentoDAO.findByTool(l);
		for (Collegamento coll: collegamenti) {
			coll.setFase(null);
			coll.setTool(null);
			collegamentoDAO.save(coll);
			collegamentoDAO.delete(coll);
		}
		toolDAO.delete(l);
	}
	
	public void updateTool(ToolDTO tool) {
		toolDAO.save(ToolConverter.convertToTool(tool));
	}

}
