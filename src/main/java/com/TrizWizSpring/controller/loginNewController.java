package com.TrizWizSpring.controller;
import java.util.*;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.TrizWizSpring.dto.BuildingDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.services.BuildingService;
import com.TrizWizSpring.services.utentiLocaliService;
import com.TrizWizSpring.services.TrizCustomerService;
@Controller
@RequestMapping("")
public class loginNewController {

	private BuildingService buildingService;
	private utentiLocaliService utentiLocaliService;
	private TrizCustomerService TrizCustomerService ;

	@Autowired
	public loginNewController(utentiLocaliService cs, BuildingService bs,TrizCustomerService b) {
		utentiLocaliService = cs;
		buildingService = bs;
		TrizCustomerService=b;
	}

	@RequestMapping(value="/", method= RequestMethod.GET)
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
			return "GestioneTrizConsultant";	
		} /*else if (userRole == 3) {
			List <BuildingDTO> buildings = buildingService.findByInstaller((String) request.getSession().getAttribute("username"));
			CustomerDTO cDTO = customerService.findByUsername((String) request.getSession().getAttribute("username"));
			request.setAttribute("installer", cDTO);
			request.setAttribute("buildings", buildings);
			return "installerHome";
		}*/
		
		else {
			return "index";
		}

	}

}
