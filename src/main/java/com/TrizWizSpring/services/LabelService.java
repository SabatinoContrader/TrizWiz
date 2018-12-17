package com.TrizWizSpring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrizWizSpring.converter.CustomerConverter;
import com.TrizWizSpring.converter.ItemConverter;
import com.TrizWizSpring.converter.LabelConverter;
import com.TrizWizSpring.dao.CustomerDAO;
import com.TrizWizSpring.dao.ItemDAO;
import com.TrizWizSpring.dao.LabelDAO;
import com.TrizWizSpring.dto.CustomerDTO;
import com.TrizWizSpring.dto.ItemDTO;
import com.TrizWizSpring.dto.LabelDTO;
import com.TrizWizSpring.model.Customer;
import com.TrizWizSpring.model.Item;
import com.TrizWizSpring.model.Label;


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
