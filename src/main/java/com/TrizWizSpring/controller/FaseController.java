package com.TrizWizSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TrizWizSpring.dto.FaseDTO;
import com.TrizWizSpring.dto.MacroDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.services.FaseService;
import com.TrizWizSpring.services.MacroService;
import com.TrizWizSpring.services.utentiLocaliService;

@RestController
@CrossOrigin
@RequestMapping("/Fase")
public class FaseController {
	@Autowired
	private FaseService faseService;
	private MacroService macroService;
	
	
	@Autowired
	public FaseController(FaseService faseService, MacroService macroService ) {
	   this.faseService=faseService;
	   this.macroService=macroService;
	}
	
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	@CrossOrigin
	public FaseDTO newFase (
			@RequestParam( "tipologia") String tipologia,
			@RequestParam( "idMacro") long IdMacro) 
			
	{
		
		FaseDTO fDTO = new FaseDTO();  // creazione oggetto DTO fase
		fDTO.setTipologia(tipologia);  // faccio il set della tipologia della fase
		MacroDTO macroDTO = this.macroService.findByPrimaryKey(IdMacro); // creazione oggetto DTO macro e cerco la primary key della macro
	    fDTO.setMacro(macroDTO); // faccio il set dell oggetto creato
        return faseService.insert(fDTO); // restituisce la funzione insert
}
	

	@CrossOrigin
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public List<FaseDTO> readAll(@RequestParam(value="ses")String ses){
		
		long idMacro=Long.parseLong(ses);
		List<FaseDTO> fase = faseService.readFase(idMacro);
		return fase;
	}
	
	@CrossOrigin
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public boolean delete(
			@RequestParam(value="idMacro", required=true) long idMacro,
			@RequestParam(value="idFase", required=true) long idFase
	) {
		/*Primo modo*/
		MacroDTO macroDTO=macroService.findByPrimaryKey(idMacro);
		FaseDTO faseDTO = new FaseDTO();
		faseDTO= faseService.findByPrimaryKey(idFase);
		faseDTO.setMacro(macroDTO);
		faseService.delete(faseDTO);
		return true;
	}
}

