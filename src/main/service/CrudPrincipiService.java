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
	/*
	public boolean updateSypthom(Request request) {
		return this.sintomoDAO.updateSypthom(request); 
	}
	
	public boolean DeleteSintomo(int idSintomo) {
		return this.sintomoDAO.DeleteSintomo(idSintomo);
	}*/
}
