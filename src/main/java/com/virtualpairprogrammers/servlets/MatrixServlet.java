package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.Parametro;
import com.virtualpairprogrammers.model.Principio;
import com.virtualpairprogrammers.service.MatrixService;

/**
 * Servlet implementation class MatrixServlet
 */
public class MatrixServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<Principio> allPrincipioMatrix;
	private MatrixService matrixService;
       
   
 /*   public MatrixServlet() {
        super();
        // TODO Auto-generated constructor stub
    }*/

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	this.matrixService= new MatrixService();
    	String scelta = request.getParameter("richiesta");
        HttpSession session = request.getSession(true);
        switch (scelta) {
        
        case "insValoriMatrice":
        	
        	getServletContext().getRequestDispatcher("/InsMatrix.jsp").forward(request,response);
    		break;
    		
        case "visualizzaMatrice":
        	
        	String parametro1 = request.getParameter("param1");
        	//String parametro2 = request.getParameter("param2");
        	//this.allPrincipioMatrix= matrixService.getAllMatrix(parametro1, parametro2);
			//request.setAttribute("visPrincipioMatrice", allPrincipioMatrix);
			//getServletContext().getRequestDispatcher("/visualizzaMatrice.jsp").forward(request,response);
			//break;
        	
        	if (parametro1.isEmpty()) {
        		getServletContext().getRequestDispatcher("/InsMatrix.jsp").forward(request,response);
        		break;
        	}
        	else {
        		String parametro2 = request.getParameter("param2");
        		if(parametro2.isEmpty()) {
        			getServletContext().getRequestDispatcher("/InsMatrix.jsp").forward(request,response);
        			break;
        		}else {
        			this.allPrincipioMatrix= matrixService.getAllMatrix(parametro1, parametro2);
        			request.setAttribute("visPrincipioMatrice", allPrincipioMatrix);
        			getServletContext().getRequestDispatcher("/visualizzaMatrice.jsp").forward(request,response);
        			break;
        		}
        	}
        }
    }

}
