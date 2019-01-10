package com.TrizWizSpring.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TrizWizSpring.converter.CollegamentoConverter;
import com.TrizWizSpring.converter.FaseConverter;
import com.TrizWizSpring.converter.MacroConverter;
import com.TrizWizSpring.dao.CollegamentoDAO;
import com.TrizWizSpring.dao.FaseDAO;
import com.TrizWizSpring.dao.ToolDAO;
import com.TrizWizSpring.dto.CollegamentoDTO;
import com.TrizWizSpring.dto.FaseDTO;
import com.TrizWizSpring.dto.ToolDTO;
import com.TrizWizSpring.model.Collegamento;
import com.TrizWizSpring.model.Fase;
import com.TrizWizSpring.model.Macro;
import com.TrizWizSpring.model.Tool;


@Service
public class CollegamentoService {
	
	@Autowired
	public FaseDAO faseDAO;
	
	@Autowired
	public CollegamentoDAO collegamentoDAO;
	
	@Autowired
	public CollegamentoService(CollegamentoDAO collegamentoDAO) {
		this.collegamentoDAO = collegamentoDAO;
	}
	
	
	

	public List<CollegamentoDTO> readCollegamento(long idFase) {
		List<Collegamento> collegamento = new ArrayList<>();
		List<CollegamentoDTO> collegamentoDTO = new ArrayList<>();
		Fase faseId = this.faseDAO.findOne(idFase);
		collegamento= collegamentoDAO.findByFase(faseId);
		
		/*for (Collegamento colleg: collegamento) {
			collegamentoDTO.add(CollegamentoConverter.convertToDto(colleg));
			System.out.println("ID TOOL"+colleg.getIdCollegamento());
		}*/
		
		collegamento.forEach(f -> collegamentoDTO.add(CollegamentoConverter.convertToDto(f)));
		System.out.println("----------------------------------->" + collegamento.size());
		
		/*for (CollegamentoDTO colleg: collegamentoDTO) {
			//collegamentoDTO.add(CollegamentoConverter.convertToDto(colleg));
			System.out.println("ID TOOLDTO"+colleg.getIdCollegamento());
		}*/
		return collegamentoDTO;
		
	}
	
	public void delete(CollegamentoDTO toDestroy) {
		Collegamento b = CollegamentoConverter.convertToCollegamento(toDestroy);
		//b.setUsername(null);  	//metto a null la chiave esterna
		//this.trizCustomerDAO.save(b);
		collegamentoDAO.delete(b);
}
	
	public CollegamentoDTO findByIdCollegamento (long idCollegamento) {
		Collegamento coll = collegamentoDAO.findOne(idCollegamento);
		CollegamentoDTO collDTO = CollegamentoConverter.convertToDto(coll);
		return collDTO;
	}
}
