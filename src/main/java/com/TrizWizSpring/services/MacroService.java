package com.TrizWizSpring.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.TrizWizSpring.converter.MacroConverter;
import com.TrizWizSpring.converter.NewUtenteLocaleConverter;
//import com.TrizWizSpring.converter.MacroConverter;
import com.TrizWizSpring.converter.TrizCustomerConverter;
import com.TrizWizSpring.converter.UtenteLocaleConverter;

import com.TrizWizSpring.dao.MacroDAO;
import com.TrizWizSpring.dao.TrizCustomerDAO;
import com.TrizWizSpring.dao.utentiLoginDAO;
import com.TrizWizSpring.dto.MacroDTO;
import com.TrizWizSpring.dto.NewUtenteLocaleDTO;
import com.TrizWizSpring.dto.TrizCustomerDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;

import com.TrizWizSpring.model.Collegamento;

import com.TrizWizSpring.model.Macro;
import com.TrizWizSpring.model.trizcustomer;
import com.TrizWizSpring.model.utentiLocali;
import com.TrizWizSpring.model.Fase;
import com.TrizWizSpring.dao.FaseDAO;
import com.TrizWizSpring.model.Collegamento;
import com.TrizWizSpring.dao.CollegamentoDAO;


@Service
public class MacroService {

	@Autowired
	private MacroDAO macroDAO;
	@Autowired
    private utentiLoginDAO utentiLoginDAO;
	@Autowired
	private utentiLocaliService utentiLocaliService;
	@Autowired
	private FaseDAO faseDAO;
	@Autowired
	private CollegamentoDAO collegamentoDAO;
    
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
		System.out.println("Utente "+usernameo.getNomeLogin());
		macro = macroDAO.findByUsername(usernameo);
		macro.forEach(m -> toReturn.add(MacroConverter.convertToDto(m)));
		System.out.println("----------------------------------->" + macro.size());
		return toReturn;

	}
	
	public MacroDTO insert(MacroDTO macroDTO) { 	
		Macro macro = MacroConverter.convertToMacro(macroDTO);
		macroDAO.save(macro);
		return MacroConverter.convertToDto(macroDAO.save(macro));
	}
	
	public MacroDTO insertMacro (MacroDTO macro) {
		return MacroConverter.convertToDto(macroDAO.save(MacroConverter.convertToMacro(macro)));
	}
	
	/*
	public Macro create(MacroDTO macro, String nomeLogin) {
		//System.out.println("nomeLogin = "+nomeLogin);
		utentiLocali c = this.utentiLoginDAO.findByNomeLogin(nomeLogin);
		//System.out.println("c = "+c.getNomeLogin()+ ""+c.getPasswordLogin()+""+c.getRuolo());
		macro.setUsername(UtenteLocaleConverter.convertToutentiLocali(c));
		//utentiLocaliDTO p=UtenteLocaleConverter.convertToDto(c);
		//System.out.println("p = "+p.getnomeLogin());
		//utentiLocaliDTO p= this.utentiLocaliService.searchUtentiLocali(nomeLogin);
		//System.out.println("utenteDTO= "+p.getNomeLogin()+ ""+p.getNome()+ ""+p.getCognome());
		//Macro.setUsername(p);
		return macroDAO.save(MacroConverter.convertToMacro(macro));

	}*/
	
	public MacroDTO findByPrimaryKey(long IdMacro) {
		return MacroConverter.convertToDto(macroDAO.findOne(IdMacro));
	}
	public void DeleteD(MacroDTO Macro, String nomeLogin) {
		System.out.println("nomeLogin = "+nomeLogin);
		utentiLocaliDTO p= this.utentiLocaliService.searchUtentiLocali(nomeLogin);
		Macro.setUsername(p);
		//return macroDAO.save(MacroConverter.convertToMacro(Macro));
		Macro b = MacroConverter.convertToMacro(Macro);
		macroDAO.delete(b);
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
		List <Fase> fasi= faseDAO.findByMacro(b);
		for (Fase fase : fasi) {
			
			List<Collegamento> collegamenti=collegamentoDAO.findByFase(fase);
			for (Collegamento coll: collegamenti) {
				coll.setFase(null);
				coll.setTool(null);
				collegamentoDAO.save(coll);
				collegamentoDAO.delete(coll);
			}
			//fase.setMacro(null);
			faseDAO.save(fase);
			faseDAO.delete(fase);
		}
		//b.setUsername(null);  	//metto a null la chiave esterna
		//this.trizCustomerDAO.save(b);
		macroDAO.delete(b);
}
  
  public MacroDTO edit(MacroDTO macroDTO) {
		Macro macro = MacroConverter.convertToMacro(macroDTO);
		macroDAO.save(macro);
		return MacroConverter.convertToDto(macroDAO.save(macro));
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
