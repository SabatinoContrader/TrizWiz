package com.AmebaDevices.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AmebaDevices.controller.TrizCustomerController;
import com.AmebaDevices.model.Customer;
import com.AmebaDevices.model.trizcustomer;
import com.AmebaDevices.model.utentiLocali;

@Repository
public interface TrizCustomerDAO extends CrudRepository<trizcustomer, Long> {


   // @Query(value = "SELECT c FROM Customer c where c.username = ?1")
	public trizcustomer findByNomeAndCognome(String nome, String cognome, String username);

	 public trizcustomer findByNome(trizcustomer trizcustomer);
	 
	 public List<trizcustomer> findByUsername(utentiLocali username);
}
