package com.TrizWizSpring.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TrizWizSpring.converter.UtenteLocaleConverter;
import com.TrizWizSpring.dao.utentiLoginDAO;
import com.TrizWizSpring.dto.utentiLocaliDTO;
import com.TrizWizSpring.model.utentiLocali;

@Service
public class utentiLocaliService {

	private utentiLoginDAO utentiLoginDAO;

	@Autowired
	public utentiLocaliService(utentiLoginDAO utentiLoginDAO) {
		this.utentiLoginDAO = utentiLoginDAO;
	}

	public long login(String nomeLogin, String passwordLogin) {
		utentiLocali c = utentiLoginDAO.findByNomeLoginAndPasswordLogin(nomeLogin, passwordLogin);
		if (c != null) {
			if (c.getRuolo() != null)
				return c.getRuolo();
		}
		return -1;
	}
	public List<utentiLocaliDTO> getAllByNomeLogin(utentiLocaliDTO nomeLogin) {
		List<utentiLocali> items = (List<utentiLocali>) utentiLoginDAO.findByNomeLogin(UtenteLocaleConverter.convertToutentiLocali(nomeLogin));
		List<utentiLocaliDTO> utentiLocali= new ArrayList<>();
		items.forEach(i->utentiLocali.addAll((Collection<? extends utentiLocaliDTO>) UtenteLocaleConverter.convertToDto(i)));
		return utentiLocali;

	}

	public void insertUtentiLocali(utentiLocaliDTO utenti) {
		System.out.println(utenti.getId() + utenti.getnomeLogin() + utenti.getpasswordLogin() + utenti.ruolo());
		utentiLoginDAO.save(UtenteLocaleConverter.convertToutentiLocali(utenti));
	}

	public List<utentiLocaliDTO> readAll() {
		List<utentiLocaliDTO> utenti = new ArrayList<>();
		utentiLoginDAO.findByRuolo(1).forEach(c -> {
			utenti.add(UtenteLocaleConverter.convertToDto(c));
			System.out.println(c.getNomeLogin());
		});
		return utenti;
	}
	
	public utentiLocaliDTO searchUtentiLocali(Long id) {
		return UtenteLocaleConverter.convertToDto(utentiLoginDAO.findOne(id));
	}
	
	public void updateUtentiLocali(utentiLocaliDTO utenti) {
		utentiLoginDAO.save(UtenteLocaleConverter.convertToutentiLocali(utenti));
	}
	
	public void deleteUtentiLocali(Long id) {
		utentiLocali c = utentiLoginDAO.findOne(id);
		utentiLoginDAO.delete(c);
	}
/*
	public List<CustomerDTO> readInstallers() {
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
	}*/

	public List<utentiLocaliDTO> getAll(String attribute) {
		List<utentiLocaliDTO> utentiLogin = new ArrayList<>();
		utentiLoginDAO.findByRuolo(1).forEach(c -> {
			utentiLogin.add(UtenteLocaleConverter.convertToDto(c));
			System.out.println(c.getNomeLogin());
		});
		return utentiLogin;
	}
}
