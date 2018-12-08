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
            	getServletContext().getRequestDispatcher("/inserisciStandard.jsp").forward(request,response);
                break;
                
            case "insertSotto":
            	if (request != null) {
                    int id = 0;
                    String descrizione = request.getParameter("descrizioneIng").toString();
                    String descrizioneIta = request.getParameter("descrizioneIta").toString();
                    int categoria = Integer.parseInt(request.getParameter("categoria").toString());
                    //int idasset = Integer.parseInt(request.getParameter("idasset").toString());
                    if (CrudSottoCategorieService.insertSottoCategorie(new SottoCategorie( id,descrizione,categoria, descrizioneIta ))) {
                   	 this.allSottoCategorie = this.CrudSottoCategorieService.getAllSottoCategorie();
                   	 request.setAttribute("visualizzaBadgeReaders", this.allSottoCategorie);
                   	 getServletContext().getRequestDispatcher("/sottoCategorie.jsp").forward(request,response);
                    } 
                    else {
                        response.sendRedirect("insertBadgeReader.jsp");
                    }
           	}
               break;
	    
	    case "cancellaStandard":
        	this.allSottoCategorie = this.CrudSottoCategorieService.getAllSottoCategorie();
            request.setAttribute("visualizzaBadgeReaders", allSottoCategorie);
        	getServletContext().getRequestDispatcher("/DeleteSottoCategoria.jsp").forward(request,response);
        break;
        
	    case "deleteID":
        	if(this.CrudSottoCategorieService.deleteSottoCategorie(Integer.parseInt(request.getParameter("id")))){
        		this.allSottoCategorie = this.CrudSottoCategorieService.getAllSottoCategorie();
                request.setAttribute("visualizzaBadgeReaders", allSottoCategorie);
            	getServletContext().getRequestDispatcher("/DeleteSottoCategoria.jsp").forward(request,response);}
        	else {
        		response.sendRedirect("homeAsset.jsp");
        	}	
         break;
       	
        
	    case "aggiornaID":
	    	if (request != null) {
	    		int id = Integer.parseInt(request.getParameter("id").toString());
                String descrizione = request.getParameter("descrizione").toString();
                String descrizioneIta = request.getParameter("descrizioneIta").toString();
                int categoria = Integer.parseInt(request.getParameter("categoria").toString());
                //int idasset = Integer.parseInt(request.getParameter("idasset").toString());
                if (CrudSottoCategorieService.updateSottoCategorie(new SottoCategorie( id,descrizione,categoria, descrizioneIta ))) {
               	 this.allSottoCategorie = this.CrudSottoCategorieService.getAllSottoCategorie();
               	 request.setAttribute("visualizzaBadgeReaders", this.allSottoCategorie);
               	 getServletContext().getRequestDispatcher("/sottoCategorie.jsp").forward(request,response);
                } 
                else {
                    response.sendRedirect("insertBadgeReader.jsp");
                }
       	}	
         break;
       	
	    
	    case "aggiornaStandard": //da implementare
	    	this.allSottoCategorie = this.CrudSottoCategorieService.getAllSottoCategorie();
            request.setAttribute("visualizzaBadgeReaders", allSottoCategorie);
        	getServletContext().getRequestDispatcher("/AggiornaSottoCategoria.jsp").forward(request,response);
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
