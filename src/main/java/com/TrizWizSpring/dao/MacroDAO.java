package com.TrizWizSpring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TrizWizSpring.controller.TrizCustomerController;
import com.TrizWizSpring.model.Customer;
import com.TrizWizSpring.model.Macro;
import com.TrizWizSpring.model.trizcustomer;
import com.TrizWizSpring.model.utentiLocali;

@Repository
public interface MacroDAO extends CrudRepository<Macro, Long> {


   // @Query(value = "SELECT c FROM Customer c where c.username = ?1")

	public Macro findByTipologiaAndUsername(String tipologia, String username);

	 public Macro findBytipologia(Macro macro);
	 
	 public List<Macro> findByUsername(utentiLocali username);
	//public Macro findByTipologiaAndUsername(String tipologia, String username);

	 //public trizcustomer findBytipologia(Macro macro);
	 
	// public List<Macro> findByUsername(utentiLocali username);

	//  public List<trizcustomer> findAllListTrizcustomer(long idCustomer);
}
