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
import com.TrizWizSpring.dto.MacroDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.services.CollegamentoService;
import com.TrizWizSpring.services.FaseService;
import com.TrizWizSpring.services.MacroService;
import com.TrizWizSpring.services.utentiLocaliService;

	@RestController
	@CrossOrigin
	@RequestMapping("/Collegamento")
	public class CollegamentoController {
		@Autowired
		private CollegamentoService collegamentoService;
		
		
		@Autowired
		public CollegamentoController(CollegamentoService collegamentoService ) {
		   this.collegamentoService=collegamentoService;
		   
		}
	 	

		@CrossOrigin
		@RequestMapping(value = "/read", method = RequestMethod.GET)
		public List<CollegamentoDTO> readAll(@RequestParam(value="idFase")long idFase){
			System.out.println("back endddddd");
			
			List<CollegamentoDTO> collegamento = collegamentoService.readCollegamento(idFase);
			return collegamento;
		}
		
		
		
	}
