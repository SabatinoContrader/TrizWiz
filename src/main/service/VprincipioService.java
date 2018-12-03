package main.service;

import main.dao.VprincipioDAO;
import main.model.Principio;
import java.util.List;

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
