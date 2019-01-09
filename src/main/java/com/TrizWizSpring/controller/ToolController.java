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

import com.TrizWizSpring.converter.ToolConverter;
import com.TrizWizSpring.dto.ToolDTO;
import com.TrizWizSpring.model.Tool;
import com.TrizWizSpring.services.ToolService;;

@RestController
@CrossOrigin
@RequestMapping("/Tool")
public class ToolController {

	@Autowired
	private ToolService ToolService;
	
	@Autowired
	public ToolController(ToolService ToolService) {
	   this.ToolService=ToolService;
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	@CrossOrigin
	public ToolDTO newTool (@RequestParam( "tipologia") String tipologia){	
		ToolDTO ToolDTO = new ToolDTO();
		ToolDTO.setTipologia(tipologia);
		return ToolService.insert(ToolDTO);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public List<ToolDTO> readAll(){
		List<ToolDTO> Tool = ToolService.readAll();
		return Tool;
	}

	
	@CrossOrigin
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public boolean delete(@RequestParam(value="id", required=true) long id){
		//ToolDTO ToolDTO=ToolService.findByPrimaryKey(id);
		ToolService.delete(id);
		return true;
	}
	
	
	@CrossOrigin
	@RequestMapping(value= "/edit", method = RequestMethod.POST)
	public ToolDTO updateTool(
			@RequestParam(value = "id")String id,
			@RequestParam(value = "tipologia")String tipologia)
			{

		System.out.println("backkkkkkkkkkkkkk");
		System.out.println(id+" er "+tipologia);
		
		long id1= Long.parseLong(id);
		System.out.println(tipologia);
		ToolDTO toolDTO = ToolService.findByPrimaryKey(id1); 	// ricerco il tool tramite l'id e lo metto in un dto e poi gli setto la nuova tipologia
		toolDTO.setTipologia(tipologia);
		ToolService.updateTool(toolDTO);
		return toolDTO;
		}
}
