package com.TrizWizSpring.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.TrizWizSpring.model.Collegamento;
import com.TrizWizSpring.model.Fase;
import com.TrizWizSpring.model.Tool;

@Repository
public interface CollegamentoDAO extends CrudRepository<Collegamento, Long> { 
	
	public FaseDAO findByCommento(String commento);

	public List<Collegamento> findByFase(Fase fase);
	public List<Collegamento> findByTool(Tool tool);
	public List<Collegamento> findAll();
	
  //public Fase findByFase(long Fase);

    public Tool findByTool(long Tool);

    
}