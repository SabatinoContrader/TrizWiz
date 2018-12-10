package com.virtualpairprogrammers.service;

import java.util.List;

import com.virtualpairprogrammers.dao.CrudExpParametroDAO;
import com.virtualpairprogrammers.model.ExpParametro;

public class CrudExpParamService {

	private CrudExpParametroDAO crudEsperienzaDAO;
	
	public CrudExpParamService (){
		crudEsperienzaDAO= new CrudExpParametroDAO();
		
	}
	
	public boolean insertEspParametro(String idParam, String commento) {
		boolean risposta=false;
		risposta= this.crudEsperienzaDAO.insertEspParametro(idParam, commento);
		return risposta;
	}
	
	public List<ExpParametro> selezionaExpParametro(String id){
		return this.crudEsperienzaDAO.selezionaExpParametro(id);
	}
}
