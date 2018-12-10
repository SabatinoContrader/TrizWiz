package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.dto.ParametroNomeDTO;
import com.virtualpairprogrammers.service.CrudExpParamService;
import com.virtualpairprogrammers.service.VparametroServiceDTO;

/**
 * Servlet implementation class ExpParametroServlet
 */
public class ExpParametroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private VparametroServiceDTO VParametriServiceDTO;
	private List<ParametroNomeDTO> allParametroNomeDTO;
	private CrudExpParamService crudExpParamService;
	private String rispostaIns;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpParametroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String scelta = request.getParameter("richiesta");
        HttpSession session = request.getSession(true);
        this.VParametriServiceDTO= new VparametroServiceDTO();
        this.crudExpParamService=new CrudExpParamService();
        
        switch(scelta) {
        
        case "InserisciEsperienza":
        	
        	//this.allParametro = this.VParametriService.getAllParametro();
        	this.allParametroNomeDTO = this.VParametriServiceDTO.getAllParametroNomeDTO ();
            request.setAttribute("insParametroDTO", allParametroNomeDTO);
            //response.sendRedirect("visualizzaParametri.jsp");
    		getServletContext().getRequestDispatcher("/insEsperienza.jsp").forward(request,response);
    		break;
    		
        case "insertEsperienza":
        	rispostaIns="";
        	String idParametro= request.getParameter("idParam");
        	String commento= request.getParameter("commento");
        	boolean risposta= crudExpParamService.insertEspParametro(idParametro, commento);
        	if(risposta) 
        		rispostaIns="Inserimento Riuscito";
        
        	else 
        		rispostaIns="Inserimento Non Riuscito";
        	
        	request.setAttribute("rispostaInserimento", rispostaIns);
        	getServletContext().getRequestDispatcher("/rispostaEsperienza.jsp").forward(request,response);
        
        	break; }
    }

}
