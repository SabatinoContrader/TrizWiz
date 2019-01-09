package com.TrizWizSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.TrizWizSpring.services.CollegamentoService;
import com.TrizWizSpring.services.FaseService;
import com.TrizWizSpring.services.MacroService;

public class CollegamentoController {
	@Autowired
	private FaseService faseService;
	private MacroService macroService;
	private CollegamentoService collegamentoService;
	
	
	@Autowired
	public CollegamentoController(FaseService faseService, MacroService macroService, CollegamentoService collegamentoService ) {
	   this.faseService=faseService;
	   this.macroService=macroService;
	   this.collegamentoService=collegamentoService;
	}
	
}
