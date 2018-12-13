package com.AmebaDevices.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.controller.TrizCustomerController;
import com.AmebaDevices.converter.BuildingConverter;
import com.AmebaDevices.converter.CustomerConverter;
import com.AmebaDevices.converter.TrizCustomerConverter;
import com.AmebaDevices.converter.utentiLocaliConverter;
import com.AmebaDevices.dao.CustomerDAO;
import com.AmebaDevices.dao.utentiLoginDAO;
import com.AmebaDevices.dao.TrizCustomerDAO;
import com.AmebaDevices.dto.BuildingDTO;
import com.AmebaDevices.dto.CustomerDTO;

import com.AmebaDevices.dto.utentiLocaliDTO;
import com.AmebaDevices.dto.TrizCustomerDTO;
import com.AmebaDevices.model.Building;
import com.AmebaDevices.model.Customer;
import com.AmebaDevices.model.trizcustomer;
import com.AmebaDevices.model.utentiLocali;


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
		trizcustomer.setUsername(utentiLocaliConverter.convertToDto(c));
		return trizCustomerDAO.save(TrizCustomerConverter.convertTotrizcustomer(trizcustomer));

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
