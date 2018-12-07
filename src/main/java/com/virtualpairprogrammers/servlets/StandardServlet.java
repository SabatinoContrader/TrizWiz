package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.Asset;
import com.virtualpairprogrammers.model.SottoCategorie;
import com.virtualpairprogrammers.service.AssetService;
import com.virtualpairprogrammers.service.CrudSottoCategorieService;

public class StandardServlet extends HttpServlet{ 

	private String message;
	
	private CrudSottoCategorieService CrudSottoCategorieService;
	private List<SottoCategorie> allSottoCategorie;

	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
	    HttpSession session = request.getSession(true);
	    
	    this.CrudSottoCategorieService= new CrudSottoCategorieService();
    	this.message = "";
    	String scelta = request.getParameter("richiesta");
        if (scelta != null) {
        	switch (scelta) {
        	
        	case "vprincipi":
        		//response.sendRedirect("homePrincipi.jsp");
        		getServletContext().getRequestDispatcher("/homePrincipi.jsp").forward(request,response);
        		break;
        	
            case "visualizzaStandard":
            	this.allSottoCategorie = this.CrudSottoCategorieService.getAllSottoCategorie();
                request.setAttribute("visualizzaBadgeReaders", allSottoCategorie);
            	getServletContext().getRequestDispatcher("/sottoCategorie.jsp").forward(request,response);
            	break;
            	
            case "inserisciStandard":
            	//response.sendRedirect("insertBadgeReader.jsp");
            	getServletContext().getRequestDispatcher("/insertBadgeReader.jsp").forward(request,response);
                break;
	    
	    case "cancellaStandard":
        	this.allSottoCategorie = this.CrudSottoCategorieService.getAllSottoCategorie();
            request.setAttribute("visualizzaBadgeReaders", allSottoCategorie);
        	getServletContext().getRequestDispatcher("/DeletePrincipio.jsp").forward(request,response);
        break;
        
	    
	    case "aggiornaStandard": //da implementare
	    	getServletContext().getRequestDispatcher("/aggiornaPrinicpi.jsp").forward(request,response);
	    	break;
	    
	    case "Indietro":
            getServletContext().getRequestDispatcher("/homeCustomers.jsp").forward(request,response);
            break;
	    	
        	}
		
	}

	/*private ServletRequest getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}*/
	
}
}
