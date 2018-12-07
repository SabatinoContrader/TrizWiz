package com.virtualpairprogrammers.service;
import java.util.List;

import com.virtualpairprogrammers.dao.CrudSottoCategorieDAO;
import com.virtualpairprogrammers.model.SottoCategorie;
import javax.servlet.http.HttpServletRequest;


public class CrudSottoCategorieService {
			private CrudSottoCategorieDAO CrudSottoCategorieDAO;
			
			public CrudSottoCategorieService() {
				CrudSottoCategorieDAO = new CrudSottoCategorieDAO();
		    }
			public List<SottoCategorie> getAllSottoCategorie () {
		        return this.CrudSottoCategorieDAO.getAllSottoCategorie();
		    }
			
			public boolean insertSottoCategorie(SottoCategorie SottoCategorie) {
				return this.CrudSottoCategorieDAO.insertSottoCategorie(SottoCategorie);
			}
			
			public boolean updateSottoCategorie(SottoCategorie SottoCategorie) {
				return this.CrudSottoCategorieDAO.updateSottoCategorie(SottoCategorie); 
			}
			
			public boolean deleteSottoCategorie(int id) {
				return this.CrudSottoCategorieDAO.deleteSottoCategorie(id);
			}
		}