package com.TrizWizSpring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TrizWizSpring.model.Customer;

@Repository
public interface CustomerDAO extends CrudRepository<Customer, Long> {


   // @Query(value = "SELECT c FROM Customer c where c.username = ?1")
	 public Customer findByUsernameAndPassword(String username, String password);

	 public Customer findByUsername(String owner);
	 
	 public List<Customer> findByUserRole(Integer userRole);
}
