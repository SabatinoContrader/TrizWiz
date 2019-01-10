package com.TrizWizSpring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.TrizWizSpring.model.Fase;
import com.TrizWizSpring.model.Tool;
import com.TrizWizSpring.model.trizcustomer;
import com.TrizWizSpring.model.utentiLocali;

@Repository
public interface ToolDAO extends CrudRepository<Tool, Long> {


	public Tool findByTipologia(String tipologia);

	

	public Tool findByIdTool(long idTool);
	public List <Tool> findAll();
	
//	 public List<Label> findByUsername(Item item);
	// public Label findByNome(Item item);


}


