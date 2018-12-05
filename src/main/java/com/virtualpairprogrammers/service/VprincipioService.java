package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.VprincipioDAO;
import com.virtualpairprogrammers.model.Principio;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class VprincipioService {
	private VprincipioDAO VprincipioDAO;
	public VprincipioService(){
		this.VprincipioDAO= new VprincipioDAO();
	}
	  public List<Principio> getAllPrincipio () {
	        return this.VprincipioDAO.getAllPrincipio();
	    }
	  
	  public Principio getPrincipioID(String id) {
		  
		  return this.VprincipioDAO.getPrincipioID(id);
	  }
}
