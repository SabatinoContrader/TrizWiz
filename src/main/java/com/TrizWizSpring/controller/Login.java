package com.TrizWizSpring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.TrizWizSpring.dto.BuildingDTO;
import com.TrizWizSpring.dto.CustomerDTO;
import com.TrizWizSpring.services.BuildingService;
import com.TrizWizSpring.services.CustomerService;

@Controller
@RequestMapping("/CACCA")
public class Login {

	private BuildingService buildingService;
	private CustomerService customerService;

	@Autowired
	public Login(CustomerService cs, BuildingService bs) {
		customerService = cs;
		buildingService = bs;
	}

	@RequestMapping(value="/", method= RequestMethod.GET)
	public String retur(HttpServletRequest request) {
		return "index";
	}
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String login(HttpServletRequest request) {
	
		String nomeUtente = request.getParameter("username");
		String password = request.getParameter("password");
		request.getSession().setAttribute("username", nomeUtente);
		long userRole = customerService.login(nomeUtente, password);
		if (userRole== 1) {
			return "GestioneCustomer";
		} else if (userRole == 2) {
			List <BuildingDTO> myBuildings = buildingService.getAll((String) request.getSession().getAttribute("username"));
			request.setAttribute("buildings", myBuildings);
			return "BuildingMenu";	
		} else if (userRole == 3) {
			List <BuildingDTO> buildings = buildingService.findByInstaller((String) request.getSession().getAttribute("username"));
			CustomerDTO cDTO = customerService.findByUsername((String) request.getSession().getAttribute("username"));
			request.setAttribute("installer", cDTO);
			request.setAttribute("buildings", buildings);
			return "installerHome";
		}
		
		else {
			return "GestioneTrizConsultant";
		}

	}

}
