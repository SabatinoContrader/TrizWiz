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
import com.TrizWizSpring.dto.ItemDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.model.Building;
import com.TrizWizSpring.services.BuildingService;
import com.TrizWizSpring.services.CustomerService;
import com.TrizWizSpring.services.ItemService;
import com.TrizWizSpring.services.utentiLocaliService;


@Controller
@RequestMapping("/Item")
public class ItemController {
	
	private ItemService itemService;
	@Autowired
	public ItemController(ItemService is) {
		itemService = is;
	}
	
	@RequestMapping(value="/menu", method=RequestMethod.GET)
	public String menu(HttpServletRequest request) {
		return "ItemMenu";
	} 
	
	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String back(HttpServletRequest request) {
		return "GestioneTrizConsultant";
	}
	
	@RequestMapping(value="/insertForm", method=RequestMethod.GET)
	public String insertForm(HttpServletRequest request) {
		return "insertItem";
	} 
	/*@RequestMapping(value="/goBackSuper", method=RequestMethod.GET)
	public String goBackSuper(HttpServletRequest request) {
		return "superuserhome"; */
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		ItemDTO item = new ItemDTO();
		item.setCommento(request.getParameter("commento"));
		itemService.insertItem(item);
		return "GestioneItem";
	} 
	
	/*
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String read(HttpServletRequest request, Model model) {
		List<CustomerDTO> customers = customerService.readAll();
		model.addAttribute("customers", customers);
		return "readItem";
	}
	
	@RequestMapping(value="/updateForm", method=RequestMethod.GET)
	public String updateForm(HttpServletRequest request) {
		List<CustomerDTO> customers = customerService.readAll();
		request.setAttribute("customers", customers);
		return "updateItem";
	} 
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("idselected"));
		long l=id;
		CustomerDTO newcustomer = customerService.searchCustomer(l);
		System.out.println(request.getParameter("selected"));
		switch (Integer.parseInt(request.getParameter("selected"))) {
		case 1:
			newcustomer.setNome(request.getParameter("value"));
			break;
		case 2:
			newcustomer.setCognome(request.getParameter("value"));
			break;
		case 3:
			newcustomer.setDataNascita(request.getParameter("value"));
			break;
		case 4:
			newcustomer.setUsername(request.getParameter("value"));
			break;
		case 5:
			newcustomer.setPassword(request.getParameter("value"));
			break;
		default:
			break;
		}
		customerService.updateCustomer(newcustomer);
		return "GestioneItem";
	} 
	
	@RequestMapping(value="/deleteForm", method=RequestMethod.GET)
	public String deleteForm(HttpServletRequest request) {
		List<CustomerDTO> customers = customerService.readAll();
		request.setAttribute("customers", customers);
		return "deletecustomer";
	} 
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		int idDelete = Integer.parseInt(request.getParameter("idselected"));
		long l=idDelete;
		customerService.deleteCustomer(l);
		return "GestioneItem";
	} 
	
	@RequestMapping(value="/goBack", method=RequestMethod.GET)   // cambiare return con goBack
	public String goBack(HttpServletRequest request) {
		return "GestioneItem";
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
