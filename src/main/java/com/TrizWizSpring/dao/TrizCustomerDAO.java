package com.TrizWizSpring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TrizWizSpring.model.trizcustomer;
import com.TrizWizSpring.model.utentiLocali;

@Repository
public interface TrizCustomerDAO extends CrudRepository<trizcustomer, Long> {


   // @Query(value = "SELECT c FROM Customer c where c.username = ?1")
	public trizcustomer findByNomeAndCognome(String nome, String cognome, String username);

	 public trizcustomer findByNome(trizcustomer trizcustomer);
	 
	 public List<trizcustomer> findByUsername(utentiLocali username);
	//  public List<trizcustomer> findAllListTrizcustomer(long idCustomer);
}
