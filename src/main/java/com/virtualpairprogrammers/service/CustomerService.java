package com.virtualpairprogrammers.service;


import java.util.List;

import com.virtualpairprogrammers.dao.CustomerDAO;
import com.virtualpairprogrammers.model.Customer;


public class CustomerService {

	private CustomerDAO customerDAO;
	
	public CustomerService() {
		this.customerDAO=new CustomerDAO();
	}
	public boolean insertCustomer(Customer customer) {
		return this.customerDAO.insertCustomer(customer);
	}
	
	public List<Customer> readAll(){
		return this.customerDAO.readAll();
	}
	public void updateCustomer( Customer customer) {
		customerDAO.updateCustomer(customer);
	}
	
	public Customer searchCustomer(int id) {
		return customerDAO.searchCustomer(id);
	}
	
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}
}
