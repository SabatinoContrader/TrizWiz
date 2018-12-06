package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.Parametro;
import com.virtualpairprogrammers.service.VparametroService;

/**
 * Servlet implementation class ParametriServlet
 */
public class ParametriServlet extends HttpServlet {
	private String message;
	
	private VparametroService VParametriService;
	private List<Parametro> allParametro;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
        	this.allParametro = this.VParametriService.getAllParametro();
            request.setAttribute("visualizzaParametro", allParametro);
            //response.sendRedirect("visualizzaParametri.jsp");
    		getServletContext().getRequestDispatcher("/visualizzaParametri.jsp").forward(request,response);
    		break;
    		
    		
    		
        }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
