package com.AmebaDevices.converter;

import com.AmebaDevices.dto.CustomerDTO;
import com.AmebaDevices.model.Customer;

public class CustomerConverter {

	public static CustomerDTO convertToDto(Customer c) {
		CustomerDTO customerDTO=new CustomerDTO();
		customerDTO.setId(c.getId());
		customerDTO.setNome(c.getNome());
		customerDTO.setCognome(c.getCognome());
		customerDTO.setDataNascita(c.getDataNascita());
		customerDTO.setEmail(c.getEmail());
		customerDTO.setUsername(c.getUsername());
		customerDTO.setPassword(c.getPassword());
		customerDTO.setUserRole(c.getUserRole());
		return customerDTO;
	}
	
	public static Customer convertToCustomer(CustomerDTO c) {
		Customer customer= new Customer();
		customer.setId(c.getId());
		customer.setNome(c.getNome());
		customer.setCognome(c.getCognome());
		customer.setDataNascita(c.getDataNascita());
		customer.setEmail(c.getEmail());
		customer.setUsername(c.getUsername());
		customer.setPassword(c.getPassword());
		customer.setUserRole(c.getUserRole());
		return customer;
	}
	
}
