package com.TrizWizSpring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrizWizSpring.converter.CustomerConverter;
import com.TrizWizSpring.converter.FaseConverter;
import com.TrizWizSpring.converter.ItemConverter;
import com.TrizWizSpring.converter.LabelConverter;
import com.TrizWizSpring.converter.ToolConverter;
import com.TrizWizSpring.converter.TrizCustomerConverter;
import com.TrizWizSpring.converter.UtenteLocaleConverter;
import com.TrizWizSpring.dao.CustomerDAO;
import com.TrizWizSpring.dao.FaseDAO;
import com.TrizWizSpring.dao.ItemDAO;
import com.TrizWizSpring.dao.LabelDAO;
import com.TrizWizSpring.dao.ToolDAO;
import com.TrizWizSpring.dto.CustomerDTO;
import com.TrizWizSpring.dto.FaseDTO;
import com.TrizWizSpring.dto.ItemDTO;
import com.TrizWizSpring.dto.LabelDTO;
import com.TrizWizSpring.dto.ToolDTO;
import com.TrizWizSpring.dto.TrizCustomerDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.model.Customer;
import com.TrizWizSpring.model.Fase;
import com.TrizWizSpring.model.Item;
import com.TrizWizSpring.model.Label;
import com.TrizWizSpring.model.trizcustomer;
import com.TrizWizSpring.model.utentiLocali;
import com.TrizWizSpring.model.Tool;



public class ToolService {
	/*
	
	private static final String FaseService = null;
	
	@Autowired
	private FaseService faseService;
	//private CustomerDAO customerDAO;
	@Autowired
	private ToolDAO toolDAO;
	@Autowired
	private FaseDAO faseDAO;
	
	
	@Autowired
	public ToolService(ToolDAO toolDAO, FaseDAO faseDAO ) {
		this.toolDAO = toolDAO;
		this.faseDAO = faseDAO;
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
	
	public void deleteTool(Long idTool) {
		Tool l = toolDAO.findOne(idTool);
		toolDAO.delete(l);
	}
	public ToolDTO findByPrimaryKey(long idTool) {
		return ToolConverter.convertToDto(toolDAO.findByIdTool(idTool));
	}

	*/

}
