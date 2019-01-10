package com.TrizWizSpring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.type.LongType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TrizWizSpring.converter.MacroConverter;

import com.TrizWizSpring.dto.MacroDTO;
import com.TrizWizSpring.dto.NewUtenteLocaleDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.model.Macro;
import com.TrizWizSpring.services.MacroService;
import com.TrizWizSpring.converter.NewUtenteLocaleConverter;
import com.TrizWizSpring.dto.NewUtenteLocaleDTO;
import com.TrizWizSpring.dto.UtenteLocaleWithIdDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.dto.NewUtenteLocaleDTO;
import com.TrizWizSpring.model.utentiLocali;
import com.TrizWizSpring.dto.MacroDTO;
import com.TrizWizSpring.dto.NewUtenteLocaleDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.model.Macro;
import com.TrizWizSpring.model.utentiLocali;
import com.TrizWizSpring.services.MacroService;
import com.TrizWizSpring.services.utentiLocaliService;

@RestController
@CrossOrigin
@RequestMapping("/Macro")
public class MacroController {

	@Autowired
	private MacroService MacroService;
	private utentiLocaliService utentiLocaliService;
	
	@Autowired
	public MacroController(MacroService MacroService,utentiLocaliService utentiLocaliService ) {
	   this.MacroService=MacroService;
	   this.utentiLocaliService=utentiLocaliService;
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public List<MacroDTO> readAll(@RequestParam(value="ses")String username){
		List<MacroDTO> macro = MacroService.getAll(username);
		return macro;
	}
	@CrossOrigin
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public boolean delete(
			@RequestParam(value="username", required=true) long username,
			@RequestParam(value="ses", required=true) String ses
	) {
		/*Primo modo*/
		System.out.println("back endddddd");
		utentiLocaliDTO UtenteDTO=utentiLocaliService.findByPrimaryKey(ses);
		MacroDTO MacroDTO = new MacroDTO();
		MacroDTO= MacroService.findByPrimaryKey(username);
		MacroDTO.setUsername(UtenteDTO);
		MacroService.delete(MacroDTO);
		
		/* Secondo modo
		MacroDTO MacroDTO = new MacroDTO();
		MacroDTO= MacroService.findByPrimaryKey(username);
		MacroService.DeleteD(MacroDTO, ses);*/
		return true;
	}
	
	@CrossOrigin
	@RequestMapping(value= "/edit", method = RequestMethod.POST)
	public MacroDTO updateMacro(
			@RequestParam(value = "idMacro")String idMacro,
			@RequestParam(value = "tipologia")String tipologia,
			@RequestParam(value = "nome")String username)
			{
		long id= Long.parseLong(idMacro);
		MacroDTO macroDTO = MacroService.findByPrimaryKey(id);
		macroDTO.setTipologia(tipologia);
		utentiLocaliDTO user= this.utentiLocaliService.searchUtentiLocali(username);
		macroDTO.setUsername(user);
		System.out.println("ciaoooooooooooo"+macroDTO.getUsername().getNomeLogin());
		MacroService.edit(macroDTO);
		//System.out.println("ciaoooooooooooo");
		return macroDTO;
		}
	
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	@CrossOrigin
	public MacroDTO newMacro (
			@RequestParam( "tipologia") String tipologia,
			@RequestParam( "username") String username, Model model
			) 
			
	{
		//System.out.println("tipolo "+ tipologia);

		//int newAnno= Integer.parseInt(anno);
		
		MacroDTO myMacroDTO = new MacroDTO();
		myMacroDTO.setTipologia(tipologia);
		utentiLocaliDTO user=this.utentiLocaliService.searchUtentiLocali(username);
		//System.out.println("tipoloooooooo "+ user.getNomeLogin());
	    myMacroDTO.setUsername(user);
       return MacroService.insert(myMacroDTO);
}

	
}
