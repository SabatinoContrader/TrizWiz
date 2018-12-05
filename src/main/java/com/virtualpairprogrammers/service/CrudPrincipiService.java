package com.virtualpairprogrammers.service;

import java.util.List;

import com.virtualpairprogrammers.dao.CrudPrincipiDAO;
import com.virtualpairprogrammers.model.Principio;
import javax.servlet.http.HttpServletRequest;


public class CrudPrincipiService {
	
	private CrudPrincipiDAO CrudPrincipiDAO;
	
	public CrudPrincipiService() {
		CrudPrincipiDAO = new CrudPrincipiDAO();
    }
	public List<Principio> getAllPrincipio () {
        return this.CrudPrincipiDAO.getAllPrincipio();
    }
	
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
