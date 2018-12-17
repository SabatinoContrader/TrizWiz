package com.TrizWizSpring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.TrizWizSpring.dto.BuildingDTO;
import com.TrizWizSpring.dto.CustomerDTO;
import com.TrizWizSpring.dto.LabelDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.model.Building;
import com.TrizWizSpring.services.BuildingService;
import com.TrizWizSpring.services.CustomerService;
import com.TrizWizSpring.services.LabelService;
import com.TrizWizSpring.services.utentiLocaliService;


@Controller
@RequestMapping("/Label")
public class LabelController {
	@Autowired
	private LabelService labelService;
	@Autowired
	public LabelController(LabelService lb) {
		labelService = lb;
	}
	
	@RequestMapping(value="/menu", method=RequestMethod.GET)
	public String menu(HttpServletRequest request) {
		return "LabelMenu";
	} 
	
	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String back(HttpServletRequest request) {
		return "GestioneTrizConsultant";
	}
	
	@RequestMapping(value="/insertForm", method=RequestMethod.GET)
	public String insertForm(HttpServletRequest request) {
		return "insertLabel";
	} 
	/*@RequestMapping(value="/goBackSuper", method=RequestMethod.GET)
	public String goBackSuper(HttpServletRequest request) {
		return "superuserhome"; */
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		LabelDTO label = new LabelDTO();
		label.setTipologia(request.getParameter("tipologia"));
		label.setCommento(request.getParameter("commento"));
		String idItem=request.getParameter("idItems");
		int idItems = Integer.parseInt(idItem);
		labelService.insertLabel(label, idItems);
		return "LabelMenu";
	} 
	
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String read(HttpServletRequest request, Model model) {
		List<LabelDTO> label = labelService.readAll();
		model.addAttribute("label", label);
		return "ReadLabel";
	}
	

	@RequestMapping(value="/deleteForm", method=RequestMethod.GET)
	public String deleteForm(HttpServletRequest request) {
		List<LabelDTO> label = this.labelService.readAll();
		request.setAttribute("label", label);
		return "DeleteLabel";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		int idItems = Integer.parseInt(request.getParameter("idselected"));
		long l=idItems;
		labelService.deleteLabel(l);
		return "DeleteLabel";
	}
	/*
	
	
	@RequestMapping(value="/updateForm", method=RequestMethod.GET)
	public String updateForm(HttpServletRequest request) {
		List<ItemDTO> item = itemService.readAll();
		request.setAttribute("item", item);
		return "UpdateItem";
	} 
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(HttpServletRequest request) {
		int idItems = Integer.parseInt(request.getParameter("idselected"));
		long l=idItems;
		ItemDTO newitem = itemService.searchItem(l);
		System.out.println(request.getParameter("selected"));
		itemService.updateItem(newitem);
		return "ItemMenu";
	} 
	
	
	@RequestMapping(value="/deleteForm", method=RequestMethod.GET)
	public String deleteForm(HttpServletRequest request) {
		List<ItemDTO> item = itemService.readAll();
		request.setAttribute("item", item);
		return "DeleteItem";
	} 
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		int idItems = Integer.parseInt(request.getParameter("idselected"));
		long l=idItems;
		itemService.deleteItem(l);
		return "DeleteItem";
	} */
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void customerControl(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void customer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	doGet(request, response);
	}
	

	
}
