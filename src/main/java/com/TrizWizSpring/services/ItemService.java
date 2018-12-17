package com.TrizWizSpring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrizWizSpring.converter.CustomerConverter;
import com.TrizWizSpring.converter.ItemConverter;
import com.TrizWizSpring.converter.TrizCustomerConverter;
import com.TrizWizSpring.dao.CustomerDAO;
import com.TrizWizSpring.dao.ItemDAO;
import com.TrizWizSpring.dao.TrizCustomerDAO;
import com.TrizWizSpring.dao.utentiLoginDAO;
import com.TrizWizSpring.dto.CustomerDTO;
import com.TrizWizSpring.dto.ItemDTO;
import com.TrizWizSpring.dto.TrizCustomerDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.model.Customer;
import com.TrizWizSpring.model.Item;
import com.TrizWizSpring.model.trizcustomer;
import com.TrizWizSpring.model.utentiLocali;


@Service
public class ItemService {

	@Autowired
    private TrizCustomerDAO TrizCustomerDAO;
	@Autowired
	private TrizCustomerService TrizCustomerService;
	private CustomerDAO customerDAO;
	private ItemDAO itemDAO;

	@Autowired
	public ItemService(ItemDAO itemDAO) {
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

	public void insertItem(ItemDTO item, long idCustomer) {

		TrizCustomerDTO p= this.TrizCustomerService.findByPrimaryKey(idCustomer);
		item.setIdCustomer(p);
		System.out.println(item.getIdItems() + item.getCommento());
		itemDAO.save(ItemConverter.convertToItem(item));
	}

	public List<ItemDTO> readAll() {
		List<ItemDTO> item = new ArrayList<>();
		itemDAO.findByCommento("commento");
		return item;
	}
	
	public void updateItem(ItemDTO item) {
		itemDAO.save(ItemConverter.convertToItem(item));
	}

	public ItemDTO searchItem(Long id) {
		return ItemConverter.convertToDto(itemDAO.findOne(id));
	}
	
	public void deleteItem(Long id) {
		Item i = itemDAO.findOne(id);
		itemDAO.delete(i);
	}

	public ItemDTO findByPrimaryKey(long idItems) {
		return ItemConverter.convertToDto(itemDAO.findByIdItems(idItems));
	}

	
	public List<ItemDTO> readItemsCustomer(long idCustomer) {
		List<Item> item = new ArrayList<>();
		List<ItemDTO> itemDTO = new ArrayList<>();
		trizcustomer trizCustomerId = this.TrizCustomerDAO.findOne(idCustomer);
		item= itemDAO.findByIdCustomer(trizCustomerId);
		
		item.forEach(b -> itemDTO.add(ItemConverter.convertToDto(b)));
		System.out.println("----------------------------------->" + item.size());
		return itemDTO;
		
	}


	/*public List<CustomerDTO> readInstallers() {
		List<CustomerDTO> installers = new ArrayList<>();
		customerDAO.findByUserRole(3).forEach(i -> installers.add(CustomerConverter.convertToDto(i)));
		return installers;

	}

	public void updateCustomer(CustomerDTO customer) {
		customerDAO.save(CustomerConverter.convertToCustomer(customer));
	}

	public CustomerDTO searchCustomer(Long id) {
		return CustomerConverter.convertToDto(customerDAO.findOne(id));
	}

	public void deleteCustomer(Long id) {
		Customer c = customerDAO.findOne(id);
		customerDAO.delete(c);
	}

	public CustomerDTO findByUsername(String username) {
		return CustomerConverter.convertToDto(customerDAO.findByUsername(username));
	}
	*/
}
