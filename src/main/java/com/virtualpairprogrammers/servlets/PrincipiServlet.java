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
import com.virtualpairprogrammers.model.Principio;
import com.virtualpairprogrammers.service.AssetService;
import com.virtualpairprogrammers.service.CrudPrincipiService;

public class PrincipiServlet extends HttpServlet{ 

	private String message;
	
	private CrudPrincipiService CrudPrincipiService;
	private List<Principio> allPrincipio;

	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		
	    HttpSession session = request.getSession(true);
	    
	    this.CrudPrincipiService= new CrudPrincipiService();
    	this.message = "";
    	String scelta = request.getParameter("richiesta");
        if (scelta != null) {
        	switch (scelta) {
        	
        	case "vprincipi":
        		//response.sendRedirect("homePrincipi.jsp");
        		getServletContext().getRequestDispatcher("/homePrincipi.jsp").forward(request,response);
        		break;
        	
            case "visualizzaPrincipi":
            	this.allPrincipio = this.CrudPrincipiService.getAllPrincipio();
                request.setAttribute("visualizzaBadgeReaders", allPrincipio);
            	getServletContext().getRequestDispatcher("/badgeReaderHome.jsp").forward(request,response);
            	break;
            	
            case "insert"://inserisci principio
            	//response.sendRedirect("insertBadgeReader.jsp");
            	getServletContext().getRequestDispatcher("/insertBadgeReader.jsp").forward(request,response);
                break;
	    
	    case "delete":
        	this.allPrincipio = this.CrudPrincipiService.getAllPrincipio();
            request.setAttribute("visualizzaBadgeReaders", allPrincipio);
        	getServletContext().getRequestDispatcher("/DeletePrincipio.jsp").forward(request,response);
        break;
        
	    
	    case "aggiornaPrincipi": //da implementare
	    	getServletContext().getRequestDispatcher("/aggiornaPrinicpi.jsp").forward(request,response);
	    	break;
	    
	    case "Indietro":
            getServletContext().getRequestDispatcher("/homeAsset.jsp").forward(request,response);
            break;
	    	
        	}
		
	}

	/*private ServletRequest getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}*/
	
}
}
