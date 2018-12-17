package com.TrizWizSpring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.TrizWizSpring.dto.BuildingDTO;
import com.TrizWizSpring.dto.CustomerDTO;
import com.TrizWizSpring.dto.ItemDTO;
import com.TrizWizSpring.dto.TrizCustomerDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.model.Building;
import com.TrizWizSpring.model.Item;
import com.TrizWizSpring.services.BuildingService;
import com.TrizWizSpring.services.CustomerService;
import com.TrizWizSpring.services.ItemService;
import com.TrizWizSpring.services.TrizCustomerService;
import com.TrizWizSpring.services.utentiLocaliService;


@Controller
@RequestMapping("/Item")
public class ItemController {
	
	private ItemService itemService;
	
	@Autowired
	private TrizCustomerService TrizCustomerService;
	
	@Autowired
	public ItemController(ItemService is) {
		itemService = is;
	}
	
	@RequestMapping(value="/menu", method=RequestMethod.GET)
	public String menu(HttpServletRequest request) {
		return "ItemMenu";
	} 
	
	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String back(HttpServletRequest request) {
		return "GestioneTrizConsultant";
	}
	
	@RequestMapping(value="/insertForm", method=RequestMethod.GET)
	public String insertForm(HttpServletRequest request) {
		return "insertItem";
	} 
	/*@RequestMapping(value="/goBackSuper", method=RequestMethod.GET)
	public String goBackSuper(HttpServletRequest request) {
		return "superuserhome"; */
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		ItemDTO item = new ItemDTO();
		item.setCommento(request.getParameter("commento"));
		String idCustomer= request.getParameter("idCustomer");
		int idCustom = Integer.parseInt(idCustomer);///// casting
		itemService.insertItem(item, idCustom);
		///long g=(long)idCustom; // casting
		return "ItemMenu";
	} 
	
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String read(HttpServletRequest request, Model model) {
		String username= request.getSession().getAttribute("username").toString();
		List <TrizCustomerDTO> trizcustomer = this.TrizCustomerService.getAll(username);
		request.setAttribute("trizcustomer", trizcustomer);
		return "InsVisItem";
	}
	
	@RequestMapping(value="/insVisCustomer", method=RequestMethod.POST)
	public String insVisCustomer(HttpServletRequest request, Model model) {
		String idCustomer= request.getParameter("idCustomer");
		int idCustom = Integer.parseInt(idCustomer);
		List <ItemDTO> itemIdCustomer= itemService.readItemsCustomer(idCustom);
		request.setAttribute("itemCustomer", itemIdCustomer);
		return "VisualizzaItem";
		
	}
	
	
	@RequestMapping(value="/updateForm", method=RequestMethod.GET)
	public String updateForm(HttpServletRequest request) {
		List<ItemDTO> item = itemService.readAll();
		request.setAttribute("item", item);
		return "UpdateItem";
	} 
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(HttpServletRequest request) {
		int idItems = Integer.parseInt(request.getParameter("idselected"));
		long l=idItems;
		ItemDTO newitem = itemService.searchItem(l);
		System.out.println(request.getParameter("selected"));
		itemService.updateItem(newitem);
		return "ItemMenu";
	} 
	
	
	@RequestMapping(value="/deleteForm", method=RequestMethod.GET)
	public String deleteForm(HttpServletRequest request) {
		List<ItemDTO> item = itemService.readAll();
		request.setAttribute("item", item);
		return "DeleteItem";
	} 
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		int idItems = Integer.parseInt(request.getParameter("idselected"));
		long l=idItems;
		itemService.deleteItem(l);
		return "DeleteItem";
	} 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void customerControl(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void customer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	doGet(request, response);
	}
	

	
}
