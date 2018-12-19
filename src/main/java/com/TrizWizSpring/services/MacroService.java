package com.TrizWizSpring.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrizWizSpring.controller.TrizCustomerController;
import com.TrizWizSpring.converter.BuildingConverter;
import com.TrizWizSpring.converter.CustomerConverter;
import com.TrizWizSpring.converter.MacroConverter;
//import com.TrizWizSpring.converter.MacroConverter;
import com.TrizWizSpring.converter.TrizCustomerConverter;
import com.TrizWizSpring.converter.UtenteLocaleConverter;
import com.TrizWizSpring.dao.CustomerDAO;
import com.TrizWizSpring.dao.MacroDAO;
import com.TrizWizSpring.dao.TrizCustomerDAO;
import com.TrizWizSpring.dao.utentiLoginDAO;
import com.TrizWizSpring.dto.BuildingDTO;
import com.TrizWizSpring.dto.CustomerDTO;
import com.TrizWizSpring.dto.MacroDTO;
import com.TrizWizSpring.dto.TrizCustomerDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.model.Building;
import com.TrizWizSpring.model.Customer;
import com.TrizWizSpring.model.Macro;
import com.TrizWizSpring.model.trizcustomer;
import com.TrizWizSpring.model.utentiLocali;


@Service
public class MacroService {

	@Autowired
	private MacroDAO macroDAO;
	@Autowired
    private utentiLoginDAO utentiLoginDAO;
	@Autowired
	private utentiLocaliService utentiLocaliService;
    
	public MacroService() {
	}
/*
	public long login (String nome, String cognome) {
		TrizCustomer c = trizCustomerDAO.findByNomeAndCognome(nome, cognome);
		if (c != null) {
			if (c.getUserRole() != null)
				return c.getUserRole();
		}
		return -1;
	}*/
	
	public List<MacroDTO> getAll(String username) {

		List<Macro> macro = new ArrayList<>();
		List<MacroDTO> toReturn = new ArrayList<>();
		utentiLocali usernameo = this.utentiLoginDAO.findByNomeLogin(username);
		macro = macroDAO.findByUsername(usernameo);
		macro.forEach(m -> toReturn.add(MacroConverter.convertToDto(m)));
		System.out.println("----------------------------------->" + macro.size());
		return toReturn;

	}
	
	public void insertMacro(MacroDTO Macro) {
		System.out.println(Macro.getIdMacro() + Macro.getTipologia() );
		macroDAO.save(MacroConverter.convertToMacro(Macro));
	
}
	
	public Macro create(MacroDTO Macro, String nomeLogin) {
		System.out.println("nomeLogin = "+nomeLogin);
		//utentiLocali c = this.utentiLoginDAO.findByNomeLogin(nomeLogin);
		//System.out.println("c = "+c.getNomeLogin()+ ""+c.getPasswordLogin()+""+c.getRuolo());
		//trizcustomer.setUsername(UtenteLocaleConverter.convertToDto(c));
		//utentiLocaliDTO p=UtenteLocaleConverter.convertToDto(c);
		//System.out.println("p = "+p.getnomeLogin());
		utentiLocaliDTO p= this.utentiLocaliService.searchUtentiLocali(nomeLogin);
		System.out.println("utenteDTO= "+p.getnomeLogin()+ ""+p.getpasswordLogin());
		Macro.setUsername(p);
		return macroDAO.save(MacroConverter.convertToMacro(Macro));

	}
	public MacroDTO findByPrimaryKey(long IdMacro) {
		return MacroConverter.convertToDto(macroDAO.findOne(IdMacro));
	}


   public void update(MacroDTO newValues, String nomeLogin) {
	  if (macroDAO.findOne(newValues.getIdMacro()) != null) {
		  
		  utentiLocali utentiLocali = this.utentiLoginDAO.findByNomeLogin(nomeLogin);
			newValues.setUsername(UtenteLocaleConverter.convertToDto(utentiLocali));
			macroDAO.save(MacroConverter.convertToMacro(newValues));
	}
}

   public void update(MacroDTO newValues) {
	   macroDAO.save(MacroConverter.convertToMacro(newValues));
}

  public void delete(MacroDTO toDestroy) {
		Macro b = MacroConverter.convertToMacro(toDestroy);
		//b.setUsername(null);  	//metto a null la chiave esterna
		//this.trizCustomerDAO.save(b);
		macroDAO.delete(b);
}

		//List<trizcustomer> trizcustomer1=trizCustomerDAO.findByUsername(b);
	/*	List<utentiLocali> utenteLocale = utentiLoginDAO.findByNomeLogin(b);
		
		for (utentiLocali utentiLocali : utenteLocale) {
			utentiLocali.setNomeLogin(null); 
			utentiLoginDAO.save(utenteLocale);
			utentiLoginDAO.delete(utenteLocale);
		}
		this.trizCustomerDAO.save(b);
		trizCustomerDAO.delete(b);
	}
	
		
		/*for (trizcustomer trizcustomern : trizcustomer1) {
			trizcustomer.setUsername(null); 
			trizCustomerDAO.save(trizcustomer1);
			trizCustomerDAO.delete(trizcustomer1);
		
		for (utentiLocali utentiLocali : utenteLocale) {
			utentiLocali.setNomeLogin(null); 
			utentiLoginDAO.save(utenteLocale);
			utentiLoginDAO.delete(utenteLocale);
		}
		this.trizCustomerDAO.save(b);
		trizCustomerDAO.delete(b);
	}
	
	public void delete(Long nomeLogin) {
		utentiLocali c = utentiLoginDAO.findOne(nomeLogin);
		 utentiLoginDAO.delete(c);
	}



	public List<CustomerDTO> readAll() {
		List<CustomerDTO> customers = new ArrayList<>();
		customerDAO.findByUserRole(2).forEach(c -> {
			customers.add(CustomerConverter.convertToDto(c));
			System.out.println(c.getNome());
		});
		return customers;
	}

	public List<CustomerDTO> readInstallers() {
		List<CustomerDTO> installers = new ArrayList<>();
		customerDAO.findByUserRole(3).forEach(i -> installers.add(CustomerConverter.convertToDto(i)));
		return installers;

	}

	public void updateCustomer(CustomerDTO customer) {
		customerDAO.save(CustomerConverter.convertToCustomer(customer));
	}

	public CustomerDTO searchCustomer(Long id) {
		return CustomerConverter.convertToDto(customerDAO.findOne(id));
	}

	public void deleteCustomer(Long id) {
		Customer c = customerDAO.findOne(id);
		customerDAO.delete(c);
	}

	public TrizCustomerDTO findByUsername(String username) {
		return TrizCustomerConverter.convertToDto(TrizCustomerDAO.findByUsername(username));
	}*/

	}
