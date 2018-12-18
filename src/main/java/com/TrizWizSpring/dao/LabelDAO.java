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
public interface LabelDAO extends CrudRepository<Label, Long> {

	public Label findByTipologia(String tipologia);

	

	public Label findByIdLabels(long idLabel);
	public List <Label> findAll();
	
//	 public List<Label> findByUsername(Item item);
	// public Label findByNome(Item item);

	//public List<Label> findByIdItems(Item itemId);

}
