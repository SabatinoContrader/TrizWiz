package com.AmebaDevices.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.converter.ItemConverter;
import com.AmebaDevices.converter.RoomConverter;
import com.AmebaDevices.converter.utentiLocaliConverter;
import com.AmebaDevices.dao.utentiLoginDAO;
import com.AmebaDevices.dto.ItemDTO;
import com.AmebaDevices.dto.RoomDTO;
import com.AmebaDevices.dto.utentiLocaliDTO;
import com.AmebaDevices.model.Item;
import com.AmebaDevices.model.utentiLocali;

@Service
public class utentiLocaliService {

	private utentiLoginDAO utentiLoginDAO;

	@Autowired
	public utentiLocaliService(utentiLoginDAO utentiLoginDAO) {
		this.utentiLoginDAO = utentiLoginDAO;
	}

	public long login(String nomeLogin, String passwordLogin) {
		utentiLocali c = utentiLoginDAO.findByNomeLoginAndPasswordLogin(nomeLogin, passwordLogin);
		if (c != null) {
			if (c.getRuolo() != null)
				return c.getRuolo();
		}
		return -1;
	}
	public List<utentiLocaliDTO> getAllByNomeLogin(utentiLocaliDTO nomeLogin) {
		List<utentiLocali> items = (List<utentiLocali>) utentiLoginDAO.findByNomeLogin(utentiLocaliConverter.convertToutentiLocali(nomeLogin));
		List<utentiLocaliDTO> utentiLocali= new ArrayList<>();
		items.forEach(i->utentiLocali.addAll((Collection<? extends utentiLocaliDTO>) utentiLocaliConverter.utentiLocaliDto(i)));
		return utentiLocali;

	}
/*
	public void insertCustomer(CustomerDTO customer) {
		System.out.println(customer.getId() + customer.getNome() + customer.getCognome() + customer.getDataNascita()
				+ customer.getEmail() + customer.getUsername() + customer.getPassword() + customer.getUserRole());
		customerDAO.save(CustomerConverter.convertToCustomer(customer));
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

	public CustomerDTO findByUsername(String username) {
		return CustomerConverter.convertToDto(customerDAO.findByUsername(username));
	}*/

	public List<utentiLocaliDTO> getAll(String attribute) {
		List<utentiLocaliDTO> utentiLogin = new ArrayList<>();
		utentiLoginDAO.findByRuolo(1).forEach(c -> {
			utentiLogin.add(utentiLocaliConverter.utentiLocaliDto(c));
			System.out.println(c.getNomeLogin());
		});
		return utentiLogin;
	}
}
