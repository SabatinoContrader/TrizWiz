package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.dto.ParametroDTO;
import com.virtualpairprogrammers.dto.ParametroNomeDTO;
import com.virtualpairprogrammers.model.Parametro;
import com.virtualpairprogrammers.model.Principio;
import com.virtualpairprogrammers.service.VparametroService;
//import com.virtualpairprogrammers.model.Parametro;
//import com.virtualpairprogrammers.service.VparametroService;
import com.virtualpairprogrammers.service.VparametroServiceDTO;

/**
 * Servlet implementation class ParametriServlet
 */
public class ParametriServlet extends HttpServlet {
	private String message;
	
	private VparametroService VParametriService;
	private VparametroServiceDTO VParametriServiceDTO;
	private List<Parametro> allParametro;
	private List<ParametroNomeDTO> allParametroNomeDTO;
	private ParametroDTO parametroDTO;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.VParametriServiceDTO= new VparametroServiceDTO();
		this.VParametriService= new VparametroService();

    	this.message = "";
    	
		String scelta = request.getParameter("richiesta");
        HttpSession session = request.getSession(true);
        switch (scelta) {
        case "vparametri":
    		//response.sendRedirect("homePrametri.jsp");
    		getServletContext().getRequestDispatcher("/homeParametri.jsp").forward(request,response);
    		break;
    		
        case "visParametri":
        	//this.allParametro = this.VParametriService.getAllParametro();
        	this.allParametroNomeDTO = this.VParametriServiceDTO.getAllParametroNomeDTO ();
            request.setAttribute("visualizzaParametroDTO", allParametroNomeDTO);
            //response.sendRedirect("visualizzaParametri.jsp");
    		getServletContext().getRequestDispatcher("/visualizzaParametri.jsp").forward(request,response);
    		break;
    		
    		
        case "visualizzaParametroId":
        	parametroDTO= this.VParametriServiceDTO.getParametroDTOID(request.getParameter("id"));
        	if(parametroDTO!=null) {
            request.setAttribute("visParametroDTO", parametroDTO);
           	getServletContext().getRequestDispatcher("/visDettaglioParametro.jsp").forward(request,response);
        	}
        	else
        		response.sendRedirect("homeAsset.jsp");
        	break;
        	
        case "insert"://inserisci principio
        	//response.sendRedirect("insertBadgeReader.jsp");
        	getServletContext().getRequestDispatcher("/insertParametri.jsp").forward(request,response);
            break;
            
        case "insertParametri":
        	if (request != null) {
                int id = 0;
                 String nomeParametro = request.getParameter("nomeParametro").toString();
                 String nomeParametroIta = request.getParameter("nomeParametroIta").toString();
                 String descrizione = request.getParameter("descrizione").toString();
                 String descrizioneIta = request.getParameter("descrizioneIta").toString();
                 String icona = request.getParameter("icona").toString();
                //int idasset = Integer.parseInt(request.getParameter("idasset").toString());
                 
                if (VParametriService.insertParametro(new Parametro( id, nomeParametro, nomeParametroIta, descrizione, descrizioneIta, icona ))) {
                	this.allParametro = this.VParametriService.getAllParametro();
               	 request.setAttribute("visualizzaParametroDTO", this.allParametro);
               	 getServletContext().getRequestDispatcher("/inserisciParametro.jsp").forward(request,response);
                } 
                else {
                    response.sendRedirect("insertBadgeReader.jsp");
                }
       	}
           break;
           
           
    
    		
		case "Indietro":
			this.allParametro = this.VParametriService.getAllParametro();
			getServletContext().getRequestDispatcher("/homeAsset.jsp").forward(request,response);
			break; 		

		
    case "deleteParametri":
    	this.allParametro = this.VParametriService.getAllParametro();
        request.setAttribute("visualizzaParametro", allParametro);
    	getServletContext().getRequestDispatcher("/DeleteParametro.jsp").forward(request,response);
    break;
    
    case "deleteID":
    	if(this.VParametriService.deleteParametro(Integer.parseInt(request.getParameter("id")))){
    		this.allParametro = this.VParametriService.getAllParametro();
            request.setAttribute("visualizzaParametro", allParametro);
        	getServletContext().getRequestDispatcher("/DeleteParametro.jsp").forward(request,response);}
    	else {
    		response.sendRedirect("homeAsset.jsp");
    	}
    	
     break;
    	
    		
        }
	}


}
