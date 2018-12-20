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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TrizWizSpring.converter.NewUtenteLocaleConverter;
import com.TrizWizSpring.converter.UtenteLocaleConverter;
import com.TrizWizSpring.dto.BuildingDTO;
import com.TrizWizSpring.dto.CustomerDTO;
import com.TrizWizSpring.dto.NewUtenteLocaleDTO;
import com.TrizWizSpring.dto.UtenteLocaleWithIdDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.model.Building;
import com.TrizWizSpring.services.BuildingService;
import com.TrizWizSpring.services.CustomerService;
import com.TrizWizSpring.services.utentiLocaliService;

@RestController
@CrossOrigin
@RequestMapping("/UtentiLocali")// da vedere
public class UtentiLocaliController  {
	
	@Autowired
	private utentiLocaliService utentiLocaliService;
	
	@Autowired
	public UtentiLocaliController(utentiLocaliService utentiLocaliService) {
	   this.utentiLocaliService=utentiLocaliService;
	}
	
	// CREAZIONE NEW UTENTE LOCALE
	
	@CrossOrigin
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public NewUtenteLocaleDTO newUtenteLocale(
			@RequestParam(value = "nomeLogin") String nomeLogin,
			@RequestParam(value = "passwordLogin") String passwordLogin,
			@RequestParam(value = "nome") String nome,
			@RequestParam(value = "cognome") String cognome,
			@RequestParam(value = "ruolo") String ruolo
			)
	{
		int role = Integer.parseInt(ruolo);
		NewUtenteLocaleDTO utentelocaleDTO = new NewUtenteLocaleDTO(nomeLogin, passwordLogin, nome, cognome, role);
		utentelocaleDTO = utentiLocaliService.insertUtentiLocali(utentelocaleDTO);
		return utentelocaleDTO;
	}
	
	
	
	
	@CrossOrigin
	@RequestMapping(value="/insertForm", method=RequestMethod.GET)
	public String insertForm(HttpServletRequest request) {
		return "insertCustomer";
	} 
	
	
	@CrossOrigin
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public List<NewUtenteLocaleDTO> readAll(){
		List<NewUtenteLocaleDTO> utente = utentiLocaliService.readAll();
		return utente;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public NewUtenteLocaleDTO update(
			@RequestParam(value = "username") String username, 
			@RequestParam(value = "field") String field, 
			@RequestParam(value = "newValue") String newValue 
			) {
		UtenteLocaleWithIdDTO utenteWithIdDTO= utentiLocaliService.findByNomeLogin(username);
		System.out.println("l'username is "+ utenteWithIdDTO.getNomeLogin());
		/*if(utenteWithIdDTO==null) {
			utenteWithIdDTO= new UtenteLocaleWithIdDTO();
			utenteWithIdDTO.setRuolo(1);
			utenteWithIdDTO.setNomeLogin(username);
		}*/
		if(Integer.parseInt(field)==1) {
			utenteWithIdDTO.setNome(newValue);
		}
		else if(Integer.parseInt(field)==2) {
			utenteWithIdDTO.setCognome(newValue);
		}
		else if(Integer.parseInt(field)==3) {
			utenteWithIdDTO.setNomeLogin(newValue);
		}
		else if(Integer.parseInt(field)==4) {
			utenteWithIdDTO.setPasswordLogin(newValue);
		}
		return NewUtenteLocaleConverter.convertToUtenteWhitIdNewUtente(utentiLocaliService.updateUtente(utenteWithIdDTO));
	}
	
	
	
	
/*	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		utentiLocaliDTO utenti = new utentiLocaliDTO();
		utenti.setNomeLogin(request.getParameter("username"));
		Integer ruolo=1;
		utenti.setRuolo(ruolo);
		utenti.setPasswordLogin(request.getParameter("password")); // in caso aggiungere anche utenti.setNome() e utenti.setCognome()
		utentiLocaliService.insertUtentiLocali(utenti);
		return "GestioneCustomer";
	} 
	
/*	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String read(HttpServletRequest request, Model model) {
		List<utentiLocaliDTO> utenti = utentiLocaliService.readAll();
		model.addAttribute("utentiLocali", utenti);
		return "ReadUtenteLocale"; //cambiare nome readCustomers in readUtenti
	}
	
	@RequestMapping(value="/updateForm", method=RequestMethod.GET)
	public String updateForm(HttpServletRequest request) {
		List<utentiLocaliDTO> utenti = utentiLocaliService.readAll();
		request.setAttribute("utentiLocali", utenti);
		return "UpdateUtenteLocale";
	} 
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(HttpServletRequest request) {
		String username= request.getParameter("idselected");
		//int id = Integer.parseInt(request.getParameter("idselected"));
		//long l=id;
		utentiLocaliDTO newutente = utentiLocaliService.searchUtentiLocali(username);
		System.out.println(request.getParameter("selected"));
		switch (Integer.parseInt(request.getParameter("selected"))) {
		case 1:
			newutente.setPasswordLogin(request.getParameter("value"));
			newutente.setNomeLogin(username);
			break;
		/*case 2:
			newutente.setpasswordLogin(request.getParameter("value"));
			break;*/
/*		default:
			break;
		}
		utentiLocaliService.updateUtentiLocali(newutente);
		return "GestioneCustomer";
	} 
	
	@RequestMapping(value="/deleteForm", method=RequestMethod.GET)
	public String deleteForm(HttpServletRequest request) {
		List<utentiLocaliDTO> utenti = utentiLocaliService.readAll();
		request.setAttribute("utenti", utenti);
		return "deletecustomer";
	} 
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		String username = request.getParameter("idselected");
		//long l=idDelete;
		utentiLocaliService.deleteUtentiLocali(username);
		return "GestioneCustomer";
	} 
	
	@RequestMapping(value="/goBack", method=RequestMethod.GET)   // cambiare return con goBack
	public String goBack(HttpServletRequest request) {
		return "GestioneCustomer";
	} 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void customerControl(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	/*	String mode = request.getParameter("mode");
		CustomerService customerService = new CustomerService();
		List<Customer> customers = customerService.readAll();
		switch (mode) {
		case "InsertForm":
			getServletContext().getRequestDispatcher("/insertCustomer.jsp").forward(request, response);
			break;
		case "InsertDb":
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String data = request.getParameter("dataDiNascita").toString();
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Customer customer = new Customer(nome, cognome, data, email, username, password);
			customerService.insertCustomer(customer);
			getServletContext().getRequestDispatcher("/GestioneCustomer.jsp").forward(request, response);
			break;
		case "Read":
			request.setAttribute("customers", customers);
			getServletContext().getRequestDispatcher("/readCustomers.jsp").forward(request, response);
			break;
		case "Return":
			getServletContext().getRequestDispatcher("/GestioneCustomer.jsp").forward(request, response);
			break;
		case "UpdateForm":
			request.setAttribute("customers", customers);
			getServletContext().getRequestDispatcher("/updateCustomer.jsp").forward(request, response);
			break;
		case "UpdateDb":
			int id = Integer.parseInt(request.getParameter("idselected"));
			customer = customerService.searchCustomer(id);
			System.out.println(request.getParameter("selected"));
			switch (Integer.parseInt(request.getParameter("selected"))) {
			case 1:
				customer.setNome(request.getParameter("value"));
				break;
			case 2:
				customer.setCognome(request.getParameter("value"));
				break;
			case 3:
				customer.setDataNascita(request.getParameter("value"));
				break;
			case 4:
				customer.setUsername(request.getParameter("value"));
				break;
			case 5:
				customer.setPassword(request.getParameter("value"));
				break;
			default:
				break;
			}
			customerService.updateCustomer(customer);
			getServletContext().getRequestDispatcher("/GestioneCustomer.jsp").forward(request, response);
			break;
		case "DeleteForm":
			request.setAttribute("customers", customers);
			getServletContext().getRequestDispatcher("/deletecustomer.jsp").forward(request, response);
			break;
		case "DeleteDb":
			int idDelete = Integer.parseInt(request.getParameter("idselected"));
			customerService.deleteCustomer(idDelete);
			getServletContext().getRequestDispatcher("/GestioneCustomer.jsp").forward(request, response);
			break;
		}*/
		
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