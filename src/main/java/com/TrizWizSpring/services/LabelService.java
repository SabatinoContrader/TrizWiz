package com.TrizWizSpring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrizWizSpring.converter.CustomerConverter;
import com.TrizWizSpring.converter.ItemConverter;
import com.TrizWizSpring.converter.LabelConverter;
import com.TrizWizSpring.converter.TrizCustomerConverter;
import com.TrizWizSpring.converter.UtenteLocaleConverter;
import com.TrizWizSpring.dao.CustomerDAO;
import com.TrizWizSpring.dao.ItemDAO;
import com.TrizWizSpring.dao.LabelDAO;
import com.TrizWizSpring.dto.CustomerDTO;
import com.TrizWizSpring.dto.ItemDTO;
import com.TrizWizSpring.dto.LabelDTO;
import com.TrizWizSpring.dto.TrizCustomerDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.model.Customer;
import com.TrizWizSpring.model.Item;
import com.TrizWizSpring.model.Label;
import com.TrizWizSpring.model.trizcustomer;
import com.TrizWizSpring.model.utentiLocali;


@Service
public class LabelService {
	
	private static final String ItemService = null;
	
	@Autowired
	private ItemService itemService;
	private CustomerDAO customerDAO;
	@Autowired
	private LabelDAO labelDAO;
	@Autowired
	private ItemDAO itemDAO;
	
	
	@Autowired
	public LabelService(LabelDAO labelDAO, ItemDAO itemDAO ) {
		this.labelDAO = labelDAO;
		this.itemDAO = itemDAO;
	}

	/* public long login(String username, String password) {
		Customer c = customerDAO.findByUsernameAndPassword(username, password);
		if (c != null) {
			if (c.getUserRole() != null)
				return c.getUserRole();
		}
		return -1;
	} */

/*	public List<LabelDTO> getAll(long idLabel) {

		List<Label> label = new ArrayList<>();
		Label label1 = this.label = labelDAO.findByIdLabels(idLabel);
		label1.forEach(l -> toReturn.add(LabelConverter.convertToDto(l)));
		return toReturn;
	}
	public List<LabelDTO> getAll(long attribute) {
		return (List<LabelDTO>) LabelConverter.convertToDto(labelDAO.findByIdLabels(attribute));
	}
	
	public List<LabelDTO> readItemsCustomer(long idItems) {
		List<Label> label = new ArrayList<>();
		List<LabelDTO> toReturn = new ArrayList<>();
		Item itemId = this.itemDAO.findOne(idItems);
		label= labelDAO.findByIdItems(itemId);
		
		label.forEach(l -> LabelDTO.add(LabelConverter.convertToDto(l)));
		System.out.println("----------------------------------->" + label.size());
		return toReturn;
		
	}*/
	public void insertLabel(LabelDTO label, long idItems) {
		ItemDTO i= this.itemService.findByPrimaryKey(idItems);
		label.setItem(i);
		System.out.println(label.getIdLabels() + label.getTipologia());
		labelDAO.save(LabelConverter.convertToLabel(label));
	}

	public List<LabelDTO> readAll() {
		List<LabelDTO> label = new ArrayList<>();
		labelDAO.findAll().forEach(c -> {

			label.add(LabelConverter.convertToDto(c));
		});
		return label;

		
	}
	   public void update(LabelDTO label) {
			  labelDAO.save(LabelConverter.convertToLabel(label));
		}
	
	public void updateLabel(LabelDTO label) {
		labelDAO.save(LabelConverter.convertToLabel(label));
	}

	public LabelDTO searchLabel(Long id) {
		return LabelConverter.convertToDto(labelDAO.findOne(id));
	}
	
	public void deleteLabel(Long id) {
		Label l = labelDAO.findOne(id);
		labelDAO.delete(l);
	}

}
