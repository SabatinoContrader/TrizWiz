package main.service;

import java.util.List;

import main.controller.Request;
import main.dao.CrudPrincipiDAO;
import main.model.Principio;

public class CrudPrincipiService {
	
	private CrudPrincipiDAO CrudPrincipiDAO;
	
	public CrudPrincipiService() {
		CrudPrincipiDAO = new CrudPrincipiDAO();
    }
	/*
	public List<Principio> getAllSympthom () {
        return this.sintomoDAO.getAllSympthom();
    }*/
	
	public boolean insertPrincipio(Principio principio) {
		return this.CrudPrincipiDAO.insertPrincipio(principio);
	}
	
	public boolean updatePrincipi(Principio principio) {
		return this.CrudPrincipiDAO.updatePrincipi(principio); 
	}
	
	public boolean deletePrincipio(int id) {
		return this.CrudPrincipiDAO.deletePrincipio(id);
	}
}
