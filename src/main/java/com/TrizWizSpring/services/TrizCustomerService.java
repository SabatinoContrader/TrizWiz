package com.TrizWizSpring.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrizWizSpring.controller.TrizCustomerController;
import com.TrizWizSpring.converter.BuildingConverter;
import com.TrizWizSpring.converter.CustomerConverter;
import com.TrizWizSpring.converter.TrizCustomerConverter;
import com.TrizWizSpring.converter.UtenteLocaleConverter;
import com.TrizWizSpring.dao.CustomerDAO;
import com.TrizWizSpring.dao.TrizCustomerDAO;
import com.TrizWizSpring.dao.utentiLoginDAO;
import com.TrizWizSpring.dto.BuildingDTO;
import com.TrizWizSpring.dto.CustomerDTO;
import com.TrizWizSpring.dto.TrizCustomerDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.model.Building;
import com.TrizWizSpring.model.Customer;
import com.TrizWizSpring.model.trizcustomer;
import com.TrizWizSpring.model.utentiLocali;


@Service
public class TrizCustomerService {

	@Autowired
	private TrizCustomerDAO trizCustomerDAO;
	@Autowired
    private utentiLoginDAO utentiLoginDAO;
    
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
		utentiLocali c = this.utentiLoginDAO.findByNomeLogin(nomeLogin);
		System.out.println("c = "+c);
		trizcustomer.setUsername(UtenteLocaleConverter.convertToDto(c));
		return trizCustomerDAO.save(TrizCustomerConverter.convertTotrizcustomer(trizcustomer));

	}
	/*
	public void delete(TrizCustomerDTO trizcustomer) {
		trizcustomer b = TrizCustomerConverter.convertTotrizcustomer(trizcustomer);
		b.setUsername(null);
		List<utentiLocali> utenteLocale = utentiLoginDAO.findByUtenti(b);
		for (utentiLocali utentiLocali : utenteLocale) {
			utentiLocali.setNomeLogin(null); 
			utentiLoginDAO.save(utenteLocale);
			utentiLoginDAO.delete(utenteLocale);
		}
		this.trizCustomerDAO.save(b);
		trizCustomerDAO.delete(b);
	}
	/*
	public void delete(Long nomeLogin) {
		utentiLocali c = utentiLoginDAO.findOne(nomeLogin);
		 utentiLoginDAO.delete(c);
	}


/*
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
