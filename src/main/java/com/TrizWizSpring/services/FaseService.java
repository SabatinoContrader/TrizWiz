package com.TrizWizSpring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrizWizSpring.converter.FaseConverter;

import com.TrizWizSpring.converter.MacroConverter;
import com.TrizWizSpring.converter.TrizCustomerConverter;

import com.TrizWizSpring.dao.FaseDAO;
import com.TrizWizSpring.dao.MacroDAO;

import com.TrizWizSpring.dao.TrizCustomerDAO;
import com.TrizWizSpring.dao.utentiLoginDAO;
import com.TrizWizSpring.dto.FaseDTO;
import com.TrizWizSpring.dto.MacroDTO;
import com.TrizWizSpring.dto.TrizCustomerDTO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.model.Collegamento;
import com.TrizWizSpring.model.Fase;
import com.TrizWizSpring.model.Macro;
import com.TrizWizSpring.model.trizcustomer;

import com.TrizWizSpring.model.utentiLocali;
import com.TrizWizSpring.dao.CollegamentoDAO;

@Service
public class FaseService {

	@Autowired
    private MacroDAO MacroDAO;
	@Autowired
	private MacroService MacroService;
	private FaseDAO faseDAO;
	@Autowired
	private CollegamentoDAO collegamentoDAO;

	@Autowired
	public FaseService(FaseDAO faseDAO) {
		this.faseDAO = faseDAO;
	}
	

	
	// INSERT
	
	public FaseDTO insert(FaseDTO faseDTO) { 	
		Fase fase = FaseConverter.convertToFase(faseDTO);
		faseDAO.save(fase);
		return FaseConverter.convertToDto(faseDAO.save(fase));
	}
	
	public FaseDTO insertFase (FaseDTO fase) {
		return FaseConverter.convertToDto(faseDAO.save(FaseConverter.convertToFase(fase)));
	}
	

	public List<FaseDTO> readFase(long idMacro) {
		List<Fase> fase = new ArrayList<>();
		List<FaseDTO> faseDTO = new ArrayList<>();
		Macro macroId = this.MacroDAO.findOne(idMacro);
		fase= faseDAO.findByMacro(macroId);
		
		fase.forEach(f -> faseDTO.add(FaseConverter.convertToDto(f)));
		System.out.println("----------------------------------->" + fase.size());
		return faseDTO;
		
	}
	
	public FaseDTO findByPrimaryKey(long idFase) {
		return FaseConverter.convertToDto(faseDAO.findByIdFase(idFase));
	}

	public void delete(FaseDTO toDestroy) {
		Fase b = FaseConverter.convertToFase(toDestroy);
		//System.out.println("Fase B"+b.getIdFase());
		List<Collegamento> collegamenti=collegamentoDAO.findByFase(b);
		for (Collegamento coll: collegamenti) {
			//Collegamento collDel=coll;
			//System.out.println("Collegamento B"+collDel.getIdCollegamento());
			coll.setFase(null);
			coll.setTool(null);
			collegamentoDAO.save(coll);
			collegamentoDAO.delete(coll);
			//collDel=null;
		}
		//b.setUsername(null);  	//metto a null la chiave esterna
		//this.trizCustomerDAO.save(b);
		faseDAO.delete(b);
}
	
	 public FaseDTO edit(FaseDTO faseDTO) {
			Fase fase = FaseConverter.convertToFase(faseDTO);
			faseDAO.save(fase);
			return FaseConverter.convertToDto(faseDAO.save(fase));
		}



	/* public long login(String username, String password) {
		Customer c = customerDAO.findByUsernameAndPassword(username, password);
		if (c != null) {
			if (c.getUserRole() != null)
				return c.getUserRole();
		}
		return -1;
	} */
/*
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
	}*/

	
	
	

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
