package com.TrizWizSpring.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.TrizWizSpring.converter.TrizCustomerConverter;
import com.TrizWizSpring.converter.UtenteLocaleConverter;

import com.TrizWizSpring.dao.TrizCustomerDAO;
import com.TrizWizSpring.dao.utentiLoginDAO;

import com.TrizWizSpring.dto.TrizCustomerDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.model.trizcustomer;
import com.TrizWizSpring.model.utentiLocali;


@Service
public class TrizCustomerService {

	@Autowired
	private TrizCustomerDAO trizCustomerDAO;
	@Autowired
    private utentiLoginDAO utentiLoginDAO;
	@Autowired
	private utentiLocaliService utentiLocaliService;
    
	public TrizCustomerService() {
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
	public List<TrizCustomerDTO> getAll(String username) {

		List<trizcustomer> trizcustomer = new ArrayList<>();
		List<TrizCustomerDTO> toReturn = new ArrayList<>();
		utentiLocali usernameo = this.utentiLoginDAO.findByNomeLogin(username);
		trizcustomer = trizCustomerDAO.findByUsername(usernameo);
		trizcustomer.forEach(b -> toReturn.add(TrizCustomerConverter.convertToDto(b)));
		System.out.println("----------------------------------->" + trizcustomer.size());
		return toReturn;

	}
	
	public void insertTrizCustomer(TrizCustomerDTO trizcustomer) {
		System.out.println(trizcustomer.getIdCustomer() + trizcustomer.getNome() + trizcustomer.getCognome());
		trizCustomerDAO.save(TrizCustomerConverter.convertTotrizcustomer(trizcustomer));
	
}
	public trizcustomer create(TrizCustomerDTO trizcustomer, String nomeLogin) {
		System.out.println("nomeLogin = "+nomeLogin);
		//utentiLocali c = this.utentiLoginDAO.findByNomeLogin(nomeLogin);
		//System.out.println("c = "+c.getNomeLogin()+ ""+c.getPasswordLogin()+""+c.getRuolo());
		//trizcustomer.setUsername(UtenteLocaleConverter.convertToDto(c));
		//utentiLocaliDTO p=UtenteLocaleConverter.convertToDto(c);
		//System.out.println("p = "+p.getnomeLogin());
		utentiLocaliDTO p= this.utentiLocaliService.searchUtentiLocali(nomeLogin);
		System.out.println("utenteDTO= "+p.getNomeLogin()+ ""+p.getRuolo());
		trizcustomer.setUsername(p);
		return trizCustomerDAO.save(TrizCustomerConverter.convertTotrizcustomer(trizcustomer));

	}
	public TrizCustomerDTO findByPrimaryKey(long IdCustomer) {
		return TrizCustomerConverter.convertToDto(trizCustomerDAO.findOne(IdCustomer));
	}


   public void update(TrizCustomerDTO newValues, String nomeLogin) {
	  if (trizCustomerDAO.findOne(newValues.getIdCustomer()) != null) {
		utentiLocali utentiLocali = this.utentiLoginDAO.findByNomeLogin(nomeLogin);
		newValues.setUsername(UtenteLocaleConverter.convertToDto(utentiLocali));
		trizCustomerDAO.save(TrizCustomerConverter.convertTotrizcustomer(newValues));
	}
}

   public void update(TrizCustomerDTO newValues) {
	trizCustomerDAO.save(TrizCustomerConverter.convertTotrizcustomer(newValues));
}

  public void delete(TrizCustomerDTO toDestroy) {
		trizcustomer b = TrizCustomerConverter.convertTotrizcustomer(toDestroy);
		//b.setUsername(null);  	//metto a null la chiave esterna
		//this.trizCustomerDAO.save(b);
		trizCustomerDAO.delete(b);
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
