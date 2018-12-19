package com.TrizWizSpring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TrizWizSpring.controller.TrizCustomerController;
import com.TrizWizSpring.dto.LabelDTO;
import com.TrizWizSpring.model.Fase;
import com.TrizWizSpring.model.Item;
import com.TrizWizSpring.model.Label;
import com.TrizWizSpring.model.Tool;
import com.TrizWizSpring.model.trizcustomer;
import com.TrizWizSpring.model.utentiLocali;

@Repository
public interface ToolDAO extends CrudRepository<Tool, Long> {
	
	//public Tool findByTipologia(String tipologia);
	
	//public Tool findByIdTool(long idTool);
	
	//public Iterable<Tool> findAll();
	
	//public List<Tool> findByFase(Fase fase);
	

}
