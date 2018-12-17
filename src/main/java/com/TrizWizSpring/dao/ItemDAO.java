package com.TrizWizSpring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TrizWizSpring.controller.TrizCustomerController;
import com.TrizWizSpring.dto.ItemDTO;
import com.TrizWizSpring.model.Item;
import com.TrizWizSpring.model.trizcustomer;
import com.TrizWizSpring.model.utentiLocali;

@Repository
public interface ItemDAO extends CrudRepository<Item, Long> { 
	
	public Item findByCommento(String commento);
	
	public List<Item> findByIdCustomer(trizcustomer idCustomer);

public Item findByIdItems(long idItems);
	
//	public Item findByItem(String item);
	 
}
