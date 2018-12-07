package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.VparametroDAO;
import com.virtualpairprogrammers.model.Parametro;



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
	  
		public boolean updateParametri(Parametro parametro) {
			return this.VparametroDAO.updateParametri(parametro); 
		}
	  
	  public boolean deleteParametro (int id) {
		  return this.VparametroDAO.deleteParametro(id);
	  }
	  
	  public boolean insertParametro(Parametro parametro) {
			return this.VparametroDAO.insertParametro(parametro);
		}
}
