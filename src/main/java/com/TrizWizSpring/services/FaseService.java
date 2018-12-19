package com.TrizWizSpring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrizWizSpring.converter.CustomerConverter;
import com.TrizWizSpring.converter.FaseConverter;
import com.TrizWizSpring.converter.ItemConverter;
import com.TrizWizSpring.converter.TrizCustomerConverter;
import com.TrizWizSpring.dao.CustomerDAO;
import com.TrizWizSpring.dao.FaseDAO;
import com.TrizWizSpring.dao.MacroDAO;
import com.TrizWizSpring.dao.ItemDAO;
import com.TrizWizSpring.dao.TrizCustomerDAO;
import com.TrizWizSpring.dao.utentiLoginDAO;
import com.TrizWizSpring.dto.CustomerDTO;
import com.TrizWizSpring.dto.FaseDTO;
import com.TrizWizSpring.dto.ItemDTO;
import com.TrizWizSpring.dto.MacroDTO;
import com.TrizWizSpring.dto.TrizCustomerDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.model.Customer;
import com.TrizWizSpring.model.Fase;
import com.TrizWizSpring.model.Item;
import com.TrizWizSpring.model.Macro;
import com.TrizWizSpring.model.trizcustomer;

import com.TrizWizSpring.model.utentiLocali;

@Service
public class FaseService {

	@Autowired
    private MacroDAO MacroDAO;
	@Autowired
	                            private MacroService MacroService;
	private CustomerDAO customerDAO;
	private FaseDAO faseDAO;

	@Autowired
	public FaseService(FaseDAO faseDAO) {
		this.faseDAO = faseDAO;
	}

	/* public long login(String username, String password) {
		Customer c = customerDAO.findByUsernameAndPassword(username, password);
		if (c != null) {
			if (c.getUserRole() != null)
				return c.getUserRole();
		}
		return -1;
	} */

	public void insertItem(FaseDTO fase, long idMacro) {

		MacroDTO p= this.MacroService.findByPrimaryKey(idMacro);
		fase.setMacro(p);
		System.out.println(fase.getIdFase() + fase.getTipologia());
		faseDAO.save(FaseConverter.convertToFase(fase));
	}
	
	public List<FaseDTO> readAll() {
		List <FaseDTO> fase = new ArrayList<>();
		List<Fase> faseo = faseDAO.findAll();
		faseo.forEach(f -> fase.add(FaseConverter.convertToDto(f)));
		return fase;
		
	}
	
	public void updateFase(FaseDTO fase) {
		faseDAO.save(FaseConverter.convertToFase(fase));
	}

	public FaseDTO searchFase(Long idFase) {
		return FaseConverter.convertToDto(faseDAO.findOne(idFase));
	}
	
	public void deleteFase(Long idFase) {
		Fase i = faseDAO.findOne(idFase);
		faseDAO.delete(i);
	}

	public FaseDTO findByPrimaryKey(long idFase) {
		return FaseConverter.convertToDto(faseDAO.findByIdFase(idFase));
	}

	
	/*public List<FaseDTO> readFase(long idMacro) {
		List<Fase> fase = new ArrayList<>();
		List<FaseDTO> faseDTO = new ArrayList<>();
		Macro macroId = this.MacroDAO.findOne(idMacro);
		fase= faseDAO.findByIdFase(macroId);
		
		fase.forEach(f -> faseDTO.add(FaseConverter.convertToDto(f)));
		System.out.println("----------------------------------->" + fase.size());
		return faseDTO;
		
	}
*/
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
