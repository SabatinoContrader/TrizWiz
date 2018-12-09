package com.virtualpairprogrammers.service;
import java.util.List;

import com.virtualpairprogrammers.dao.CrudCategorieStandardDAO;
import com.virtualpairprogrammers.model.CategorieStandard;
import javax.servlet.http.HttpServletRequest;

public class CrudCategorieStandardService {
		
		private CrudCategorieStandardDAO CrudCategorieStandardDAO;
		
		public CrudCategorieStandardService() {
			CrudCategorieStandardDAO = new CrudCategorieStandardDAO();
	    }
		public List<CategorieStandard> getAllCategorieStandard () {
	        return this.CrudCategorieStandardDAO.getAllCategorieStandard();
	    }
		
		public boolean insertCategorieStandard(CategorieStandard CategorieStandard) {
			return this.CrudCategorieStandardDAO.insertCategorieStandard(CategorieStandard);
		}
		
		public boolean updateCategorieStandard(CategorieStandard CategorieStandard) {
			return this.CrudCategorieStandardDAO.updateCategorieStandard(CategorieStandard); 
		}
		
		public boolean deleteCategorieStandard(int id) {
			return this.CrudCategorieStandardDAO.deleteCategorieStandard(id);
		}
		
	}


