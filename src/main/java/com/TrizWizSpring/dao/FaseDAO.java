package com.TrizWizSpring.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.TrizWizSpring.model.Macro;

public interface FaseDAO extends CrudRepository<FaseDAO, Long> { 
	
	public FaseDAO findByCommento(String commento);

	public List<FaseDAO> findByIdMacro(Macro Macro);
	public List<FaseDAO> findAll();
	


public FaseDAO findByIdFase(long idFase);


	

}
