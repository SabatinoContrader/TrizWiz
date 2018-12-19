package com.TrizWizSpring.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TrizWizSpring.model.Fase;
import com.TrizWizSpring.model.Macro;
@Repository
public interface FaseDAO extends CrudRepository<Fase, Long> { 
	
	public FaseDAO findByTipologia(String tipologia);

	public List<Fase> findByMacro(Macro Macro);
	public List<Fase> findAll();
	
   public Fase findByIdFase(long idFase);


	

}
