package main.service;

import main.dao.VparametroDAO;
import main.dao.VprincipioDAO;
import main.model.Parametro;
import main.model.Principio;

import java.sql.SQLException;
import java.util.List;

public class VparametroService {
	private VparametroDAO VparametroDAO;
	public VparametroService(){
		this.VparametroDAO= new VparametroDAO();
	}
	  public List<Parametro> getAllParametro () {
	        return this.VparametroDAO.getAllParametro();
	    }
	  
	  public Parametro getParametroID(String id) {
		  
		  return this.VparametroDAO.getParametroID(id);
	  }
	  
	  public boolean deleteParametro (int id) {
		  return this.VparametroDAO.deleteParametro(id);
	  }
}
