package com.TrizWizSpring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrizWizSpring.converter.MacroConverter;
import com.TrizWizSpring.converter.ToolConverter;
import com.TrizWizSpring.dao.ToolDAO;
import com.TrizWizSpring.dto.ToolDTO;
import com.TrizWizSpring.model.Tool;


@Service
public class ToolService {
	
	@Autowired
	private ToolDAO toolDAO;
	
	
	
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
		toolDAO.delete(l);
	}
	/* public long login(String username, String password) {
		Customer c = customerDAO.findByUsernameAndPassword(username, password);
		if (c != null) {
			if (c.getUserRole() != null)
				return c.getUserRole();
		}
		return -1;
	} */

/*	public List<LabelDTO> getAll(long idLabel) {

		List<Label> label = new ArrayList<>();
		Label label1 = this.label = labelDAO.findByIdLabels(idLabel);
		label1.forEach(l -> toReturn.add(LabelConverter.convertToDto(l)));
		return toReturn;
	}
	public List<LabelDTO> getAll(long attribute) {
		return (List<LabelDTO>) LabelConverter.convertToDto(labelDAO.findByIdLabels(attribute));
	}*/
	/*
	public List<ToolDTO> readToolFase(long idFase) {
		List<Tool> tool = new ArrayList<>();
		List<ToolDTO> toReturn = new ArrayList<>();
		Fase faseId = this.faseDAO.findOne(idFase);
		tool= toolDAO.findByFase(faseId);
		tool.forEach(t -> toReturn.add(ToolConverter.convertToDto(t)));
		System.out.println("----------------------------------->" + tool.size());
		return toReturn;
		
	}
	public void insertTool(ToolDTO tool, long idFase) {
		FaseDTO i= this.faseService.findByPrimaryKey(idFase);
		tool.setFase(i);
		System.out.println(tool.getIdTool() + tool.getTipologia());
		toolDAO.save(ToolConverter.convertToTool(tool));
	}

	public List<ToolDTO> readAll() {
		List<ToolDTO> tool = new ArrayList<>();
		toolDAO.findAll().forEach(c -> {

			tool.add(ToolConverter.convertToDto(c));
		});
		return tool;

		
	}
	   public void update(ToolDTO tool) {
			  toolDAO.save(ToolConverter.convertToTool(tool));
		}
	
	public void updateTool(ToolDTO tool) {
		toolDAO.save(ToolConverter.convertToTool(tool));
	}

	public ToolDTO searchLabel(Long idTool) {
		return ToolConverter.convertToDto(toolDAO.findOne(idTool));
	}
	

	*/

}
