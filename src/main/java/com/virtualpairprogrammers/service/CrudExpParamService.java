package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.CrudExpParametroDAO;

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
}
