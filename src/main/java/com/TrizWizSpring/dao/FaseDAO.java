package com.TrizWizSpring.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.TrizWizSpring.model.Fase;
import com.TrizWizSpring.model.Macro;

public interface FaseDAO extends CrudRepository<Fase, Long> { 
	
	//public Fase findByCommento(String commento);

	//public List<Fase> findByIdMacro(Macro Macro);
	//public List<Fase> findAll();
	


//public Fase findByIdFase(long idFase);


	

}
