package com.TrizWizSpring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TrizWizSpring.controller.TrizCustomerController;
import com.TrizWizSpring.dto.LabelDTO;
import com.TrizWizSpring.model.Item;
import com.TrizWizSpring.model.Label;
import com.TrizWizSpring.model.trizcustomer;
import com.TrizWizSpring.model.utentiLocali;

@Repository
public interface ToolDAO extends CrudRepository<ToolDAO, Long> {
	
	public ToolDAO findByTipologia(String tipologia);
	
	public ToolDAO findByIdTool(long idTool);
	
	public Iterable<ToolDAO> findAll();
	
	public List<ToolDAO> findByFase(FaseDAO fase);
	

}
