package com.TrizWizSpring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TrizWizSpring.model.trizcustomer;
import com.TrizWizSpring.model.utentiLocali;

@Repository
public interface utentiLoginDAO extends CrudRepository<utentiLocali, Long> {


	 public utentiLocali findByNomeLoginAndPasswordLogin(String nomeLogin, String passwordLogin);

	 public utentiLocali findByNomeLogin(utentiLocali utentiLocali);
	 public utentiLocali findByNomeLogin(String nomeLogin);
	 
	 public List<utentiLocali> findByRuolo(Integer ruolo);
}
