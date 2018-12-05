package com.virtualpairprogrammers.service;

import java.util.List;

import com.virtualpairprogrammers.dao.MatrixDAO;
import com.virtualpairprogrammers.model.Matrix;
import com.virtualpairprogrammers.model.Principio;

import javax.servlet.http.HttpServletRequest;

public class MatrixService {

    private MatrixDAO MatrixDAO;
    
    public MatrixService() {
        this.MatrixDAO = new MatrixDAO();
    }
	  public List<Principio> getAllMatrix (String param1, String param2) {
	        return this.MatrixDAO.getAllMatrix(param1, param2);
	    }
    /*public boolean Matrix (String param1, String param2) {
        return this.MatrixDAO.Matrix(param1, param2);
    }*/
}
