package com.TrizWizSpring.controller;
import java.util.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.services.utentiLocaliService;
import com.TrizWizSpring.services.TrizCustomerService;

@RestController
@CrossOrigin
@RequestMapping("/utente")
public class loginNewController {


	private utentiLocaliService utentiLocaliService;
	private TrizCustomerService TrizCustomerService ;

	@Autowired
	public loginNewController(utentiLocaliService cs, TrizCustomerService b) {
		utentiLocaliService = cs;
		
		TrizCustomerService=b;
	}
	
	//modificare da qui in poi
	
	@CrossOrigin
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public utentiLocaliDTO login
	(
			@RequestParam(value="username", required=true) String username,
			@RequestParam(value="password", required=true) String password
	) {
		utentiLocaliDTO utentiLocaliDTO = utentiLocaliService.login(username, password);
		return utentiLocaliDTO;
	}

/*	@RequestMapping(value="/", method= RequestMethod.GET)
	public String retur(HttpServletRequest request) {
		return "index";
	}
	@RequestMapping(value="/loginNew", method= RequestMethod.POST)
	public String login(HttpServletRequest request) {
		String nomeLogin = request.getParameter("username");
		String passwordLogin = request.getParameter("password");
		request.getSession().setAttribute("username", nomeLogin);
		long ruolo = utentiLocaliService.login(nomeLogin, passwordLogin);
		System.out.println("ruolo è "+ruolo);
		if (ruolo== 0) {//superuser
			return "GestioneCustomer";
		} else if (ruolo == 1) {//utente
		//	List <utentiLocaliDTO> myutentiLocali = utentiLocaliService.getAll((String) request.getSession().getAttribute("nomeLogin"));
		//	request.setAttribute("utentiLocali", myutentiLocali);
			return "GestioneMacro";	
		} /*else if (userRole == 3) {
			List <BuildingDTO> buildings = buildingService.findByInstaller((String) request.getSession().getAttribute("username"));
			CustomerDTO cDTO = customerService.findByUsername((String) request.getSession().getAttribute("username"));
			request.setAttribute("installer", cDTO);
			request.setAttribute("buildings", buildings);
			return "installerHome";
		}*/
		
/*		else {
			return "index";
		}

	}*/

}
