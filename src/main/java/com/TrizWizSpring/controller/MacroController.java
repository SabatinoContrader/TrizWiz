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
import com.TrizWizSpring.services.utentiLocaliService;

@RestController
@CrossOrigin
@RequestMapping("/Macro")
public class MacroController {

	@Autowired
	private MacroService MacroService;
	
	@Autowired
	private utentiLocaliService utentiLocaliService;
	
	@Autowired
	public MacroController(MacroService MacroService) {
	   this.MacroService=MacroService;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public List<MacroDTO> readAll(@RequestParam(value="ses")String username){
		System.out.print("siamo nel back-end");
		List<MacroDTO> macro = MacroService.getAll(username);
		return macro;
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

	
}
