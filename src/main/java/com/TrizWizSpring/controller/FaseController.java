package com.TrizWizSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public FaseController(FaseService faseService,MacroService macroService ) {
	   this.faseService=faseService;
	   this.macroService=macroService;
	}
	

	}

