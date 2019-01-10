package com.TrizWizSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TrizWizSpring.dto.CollegamentoDTO;
import com.TrizWizSpring.dto.FaseDTO;
import com.TrizWizSpring.dto.ToolDTO;
import com.TrizWizSpring.dto.MacroDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.services.CollegamentoService;
import com.TrizWizSpring.services.FaseService;
import com.TrizWizSpring.services.MacroService;
import com.TrizWizSpring.services.ToolService;
import com.TrizWizSpring.services.utentiLocaliService;


	@RestController
	@CrossOrigin
	@RequestMapping("/Collegamento")
	public class CollegamentoController {
		@Autowired
		private CollegamentoService collegamentoService;
		private FaseService faseService;
		private ToolService toolService;
		
		
		@Autowired
		public CollegamentoController(CollegamentoService collegamentoService, FaseService faseService, ToolService toolService ) {
		   this.collegamentoService=collegamentoService;
		   this.faseService=faseService;
		   this.toolService=toolService;
		}
	 	
		@CrossOrigin
		@RequestMapping(value = "/read", method = RequestMethod.GET)
		public List<CollegamentoDTO> readAll(@RequestParam(value="idFase")long idFase){
			System.out.println("back endddddd");
			
			List<CollegamentoDTO> collegamento = collegamentoService.readCollegamento(idFase);
			return collegamento;
		}
		
		@CrossOrigin
		@RequestMapping(value="/delete", method=RequestMethod.POST)
		public boolean delete(
				@RequestParam(value="idCollegamento", required=true) long idCollegamento
		) {
			/*Primo modo*/
			CollegamentoDTO collDTO=collegamentoService.findByIdCollegamento(idCollegamento);
			collegamentoService.delete(collDTO);
			return true;
		}
	
		@RequestMapping(value="/insert",method=RequestMethod.POST)
		@CrossOrigin
		public CollegamentoDTO newCollegamento (
				@RequestParam( "idFase") long idFase,
				@RequestParam( "idTool") long idTool,
				@RequestParam( "commento") String commento)
				
		{
			FaseDTO fDTO = this.faseService.findByPrimaryKey(idFase);  // creazione oggetto DTO fase
			ToolDTO tDTO = this.toolService.findByPrimaryKey(idTool);  // creazione oggetto DTO tool
			CollegamentoDTO cDTO = new CollegamentoDTO();  // creazione oggetto DTO collegamento
			cDTO.setFase(fDTO);
			cDTO.setTool(tDTO);
			cDTO.setCommento(commento);
			return collegamentoService.insert(cDTO); // restituisce la funzione insert
	}	
		
	}
