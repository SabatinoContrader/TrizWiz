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
import com.TrizWizSpring.dto.TrizCustomerDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.model.trizcustomer;
import com.TrizWizSpring.services.BuildingService;
import com.TrizWizSpring.services.CustomerService;
import com.TrizWizSpring.services.TrizCustomerService;

@Controller
@RequestMapping("/TrizCustomer")
public class TrizCustomerController  {

	@Autowired
	private TrizCustomerService TrizCustomerService;
	
	@Autowired
	public TrizCustomerController() {
	}
	
	@RequestMapping(value="/insertForm", method=RequestMethod.GET)
	public String insertForm(HttpServletRequest request) {
		return "insertTrizCustomer";
	} 

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(HttpServletRequest request) {
		return "BuildingMenu";
	}
	/*
	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String back(HttpServletRequest request) {
		return "GestioneTrizConsultant";
	}
	*/
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		String nome= request.getParameter("nome");
		String cognome= request.getParameter("cognome");
		 TrizCustomerDTO trizcustomer = new TrizCustomerDTO();
		 trizcustomer.setCognome(cognome);
		 trizcustomer.setNome(nome);
		 String username = request.getSession().getAttribute("username").toString();
		 this.TrizCustomerService.create(trizcustomer, username);
		 //commento
			List<TrizCustomerDTO> trizcustomer1 = this.TrizCustomerService.getAll(username);
			request.setAttribute("trizcustomer1", trizcustomer1);
			return "BuildingMenu";
		}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(HttpServletRequest request) {
		String username = request.getSession().getAttribute("username").toString();
		List <TrizCustomerDTO> trizcustomer = this.TrizCustomerService.getAll(username);
		request.setAttribute("trizcustomer", trizcustomer);
		return "TrizCustomerRead";
	}
	
	@RequestMapping(value = "/readItem", method = RequestMethod.GET)
	public String readItem(HttpServletRequest request) {
		String username = request.getSession().getAttribute("username").toString();
		List <TrizCustomerDTO> trizcustomer = this.TrizCustomerService.getAll(username);
		request.setAttribute("trizcustomer", trizcustomer);
		return "insertItem";
	}
/*
	@RequestMapping(value = "/deleteForm", method = RequestMethod.GET)
	public String deleteForm(HttpServletRequest request) {
		String username = request.getSession().getAttribute("username").toString();
		List <TrizCustomerDTO> trizcustomer1 = this.TrizCustomerService.getAll(username);
		request.setAttribute("trizcustomer1", trizcustomer1);
		return "TrizCustomerDelete";
		//return "DeleteTrizCustomer";
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		String username = request.getSession().getAttribute("username").toString();
		int toDelete = Integer.parseInt(request.getParameter("idselected"));
		TrizCustomerDTO toDestroy = TrizCustomerService.findByPrimaryKey(toDelete);
		this.TrizCustomerService.delete(toDestroy);
		List <TrizCustomerDTO> trizcustomer1 = this.TrizCustomerService.getAll(username);
		request.setAttribute("trizcustomer1", trizcustomer1);
		
		
		return "CustomerHome";
	
	 
	 }
		/*long idCustomer = Long.parseLong(request.getParameter("idCustomer"));
		TrizCustomerService.delete(idCustomer);
		List <TrizCustomerDTO> trizcustomer1 =TrizCustomerService.getAll(null);
		request.setAttribute("trizcustomer1", trizcustomer1);
		return "CustomerHome";
		
	}
		String username = request.getSession().getAttribute("username").toString();
		int toDelete = Integer.parseInt(request.getParameter("idselected"));
		TrizCustomerDTO toDestroy = TrizCustomerService.findByPrimaryKey(toDelete);
		this.TrizCustomerService.delete(toDestroy);
		List <TrizCustomerDTO> trizcustomer1 = this.TrizCustomerService.getAll(username);
		request.setAttribute("trizcustomer1", trizcustomer1);
		return "CustomerHome";
		
	//	return "CustomerHome";
	
	 */
	 
 
	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm(HttpServletRequest request) {
		String username = request.getSession().getAttribute("username").toString();
		List <TrizCustomerDTO> trizcustomer1 = this.TrizCustomerService.getAll(username);
		request.setAttribute("trizcustomer1", trizcustomer1);
		return "TrizCustomerUpdate";
		
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		String username = request.getSession().getAttribute("username").toString();
		long idCustomer = Long.parseLong(request.getParameter("idselected"));
		String nome= request.getParameter("nome");
		String cognome= request.getParameter("cognome");
		//System.out.println("nome è" + nome);
		 TrizCustomerDTO newValues = new TrizCustomerDTO();
		 newValues.setIdCustomer(idCustomer);
		 newValues.setCognome(cognome);
		              // trizcustomer.setUsername(request.getParameter("username"));
		 newValues.setNome(nome);
		              // String username = request.getSession().getAttribute("username").toString();
		 this.TrizCustomerService.update(newValues, username);
			List<TrizCustomerDTO> trizcustomer1= this.TrizCustomerService.getAll(username);
			request.setAttribute("trizcustomer1", trizcustomer1);
			return "CustomerHome";
	}
	
	@RequestMapping(value = "/goBack", method = RequestMethod.GET)
	public String goBack(HttpServletRequest request) {
		return "BuildingMenu";
	
	}




		//this.trizCustomerService.insertTrizCustomer(trizcustomer);
		//String username=request.getSession().getAttribute("username").toString();
		//trizcustomer.setUsername(username);
		//TrizCustomerService.insertTrizCustomer(trizcustomer);
		//return "GestioneTrizConsultant";//ritorna pag da visualizzare
	 
	
	/*
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String read(HttpServletRequest request, Model model) {
		List<CustomerDTO> customers = customerService.readAll();
		model.addAttribute("customers", customers);
		return "readCustomers";
	}
	
	@RequestMapping(value="/updateForm", method=RequestMethod.GET)
	public String updateForm(HttpServletRequest request) {
		List<CustomerDTO> customers = customerService.readAll();
		request.setAttribute("customers", customers);
		return "updateCustomer";
	} 
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("idselected"));
		long l=id;
		CustomerDTO newcustomer = customerService.searchCustomer(l);
		System.out.println(request.getParameter("selected"));
		switch (Integer.parseInt(request.getParameter("selected"))) {
		case 1:
			newcustomer.setNome(request.getParameter("value"));
			break;
		case 2:
			newcustomer.setCognome(request.getParameter("value"));
			break;
		case 3:
			newcustomer.setDataNascita(request.getParameter("value"));
			break;
		case 4:
			newcustomer.setUsername(request.getParameter("value"));
			break;
		case 5:
			newcustomer.setPassword(request.getParameter("value"));
			break;
		default:
			break;
		}
		customerService.updateCustomer(newcustomer);
		return "GestioneCustomer";
	} 
	
	@RequestMapping(value="/deleteForm", method=RequestMethod.GET)
	public String deleteForm(HttpServletRequest request) {
		List<CustomerDTO> customers = customerService.readAll();
		request.setAttribute("customers", customers);
		return "deletecustomer";
	} 
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		int idDelete = Integer.parseInt(request.getParameter("idselected"));
		long l=idDelete;
		customerService.deleteCustomer(l);
		return "GestioneCustomer";
	} 
	
	@RequestMapping(value="/goBack", method=RequestMethod.GET)   // cambiare return con goBack
	public String goBack(HttpServletRequest request) {
		return "GestioneCustomer";
	} 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void TrizcustomerControl(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	/*	String mode = request.getParameter("mode");
		CustomerService customerService = new CustomerService();
		List<Customer> customers = customerService.readAll();
		switch (mode) {
		case "InsertForm":
			getServletContext().getRequestDispatcher("/insertCustomer.jsp").forward(request, response);
			break;
		case "InsertDb":
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String data = request.getParameter("dataDiNascita").toString();
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Customer customer = new Customer(nome, cognome, data, email, username, password);
			customerService.insertCustomer(customer);
			getServletContext().getRequestDispatcher("/GestioneCustomer.jsp").forward(request, response);
			break;
		case "Read":
			request.setAttribute("customers", customers);
			getServletContext().getRequestDispatcher("/readCustomers.jsp").forward(request, response);
			break;
		case "Return":
			getServletContext().getRequestDispatcher("/GestioneCustomer.jsp").forward(request, response);
			break;
		case "UpdateForm":
			request.setAttribute("customers", customers);
			getServletContext().getRequestDispatcher("/updateCustomer.jsp").forward(request, response);
			break;
		case "UpdateDb":
			int id = Integer.parseInt(request.getParameter("idselected"));
			customer = customerService.searchCustomer(id);
			System.out.println(request.getParameter("selected"));
			switch (Integer.parseInt(request.getParameter("selected"))) {
			case 1:
				customer.setNome(request.getParameter("value"));
				break;
			case 2:
				customer.setCognome(request.getParameter("value"));
				break;
			case 3:
				customer.setDataNascita(request.getParameter("value"));
				break;
			case 4:
				customer.setUsername(request.getParameter("value"));
				break;
			case 5:
				customer.setPassword(request.getParameter("value"));
				break;
			default:
				break;
			}
			customerService.updateCustomer(customer);
			getServletContext().getRequestDispatcher("/GestioneCustomer.jsp").forward(request, response);
			break;
		case "DeleteForm":
			request.setAttribute("customers", customers);
			getServletContext().getRequestDispatcher("/deletecustomer.jsp").forward(request, response);
			break;
		case "DeleteDb":
			int idDelete = Integer.parseInt(request.getParameter("idselected"));
			customerService.deleteCustomer(idDelete);
			getServletContext().getRequestDispatcher("/GestioneCustomer.jsp").forward(request, response);
			break;
		}*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void trizcustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	doGet(request, response);
	}

}

