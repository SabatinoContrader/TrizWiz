package com.TrizWizSpring.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TrizWizSpring.converter.CollegamentoConverter;
import com.TrizWizSpring.dao.CollegamentoDAO;
import com.TrizWizSpring.dao.FaseDAO;
import com.TrizWizSpring.dao.ToolDAO;
import com.TrizWizSpring.dto.CollegamentoDTO;
import com.TrizWizSpring.dto.FaseDTO;
import com.TrizWizSpring.dto.ToolDTO;
import com.TrizWizSpring.model.Collegamento;
import com.TrizWizSpring.model.Fase;
import com.TrizWizSpring.model.Tool;



public class CollegamentoService {
	
	private static final String FaseService = null;
	private static final String ToolService = null;
	@Autowired
	private FaseService faseService;
	private ToolService toolService;
	//private CustomerDAO customerDAO;
	@Autowired
	private ToolDAO toolDAO;
	@Autowired
	private FaseDAO faseDAO;
	@Autowired
	private CollegamentoDAO collegamentoDAO;
	
	
	@Autowired
	public CollegamentoService(ToolDAO toolDAO, FaseDAO faseDAO, CollegamentoDAO collegamentoDAO ) {
		this.toolDAO = toolDAO;
		this.faseDAO = faseDAO;
		this.collegamentoDAO= collegamentoDAO;
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
	
	public List<CollegamentoDTO> readFase(long idFase) {
		List<Collegamento> collegamento = new ArrayList<>();
		List<CollegamentoDTO> toReturn = new ArrayList<>();
		Fase faseId = this.faseDAO.findOne(idFase);
		collegamento= collegamentoDAO.findByFase(faseId);
		collegamento.forEach(t -> toReturn.add(CollegamentoConverter.convertToDto(t)));
		System.out.println("----------------------------------->" + collegamento.size());
		return toReturn;
	}
	
	public List<CollegamentoDTO> readTool(long idTool) {
		List<Collegamento> collegamento = new ArrayList<>();
		List<CollegamentoDTO> toReturn = new ArrayList<>();
		Tool toolId = this.toolDAO.findOne(idTool);
		collegamento= collegamentoDAO.findByTool(toolId);
		collegamento.forEach(t -> toReturn.add(CollegamentoConverter.convertToDto(t)));
		System.out.println("----------------------------------->" + collegamento.size());
		return toReturn;
	
	}
	
	
	public void insertCollegamento(CollegamentoDTO collegamento, long idFase) {
		FaseDTO i= this.faseService.findByPrimaryKey(idFase);
		collegamento.setFase(i);
		System.out.println(collegamento.getIdCollegamento() + collegamento.getCommento());
		collegamentoDAO.save(CollegamentoConverter.convertToCollegamento(collegamento));
	}
	
	public void insertCollegamento1(CollegamentoDTO collegamento, long idTool) {
		
		ToolDTO i= this.toolService.findByPrimaryKey(idTool);
		collegamento.setTool(i);
		System.out.println(collegamento.getIdCollegamento() + collegamento.getCommento());
		collegamentoDAO.save(CollegamentoConverter.convertToCollegamento(collegamento));
	}
	
	public List<CollegamentoDTO> readAll() {
		List<CollegamentoDTO> collegamento = new ArrayList<>();
		collegamentoDAO.findAll().forEach(c -> {

			collegamento.add(CollegamentoConverter.convertToDto(c));
		});
		return collegamento;

		
	}
	   public void update(CollegamentoDTO collegamento) {
			  collegamentoDAO.save(CollegamentoConverter.convertToCollegamento(collegamento));
		}
	
	public void updateCollegamento(CollegamentoDTO collegamento) {
		collegamentoDAO.save(CollegamentoConverter.convertToCollegamento(collegamento));
	}

	public CollegamentoDTO searchCollegamento(Long idCollegamento) {
		return CollegamentoConverter.convertToDto(collegamentoDAO.findOne(idCollegamento));
	}
	
	public void deleteCollegamento(Long idCollegamento) {
		Collegamento l = collegamentoDAO.findOne(idCollegamento);
		collegamentoDAO.delete(l);
	}
	
	

}
