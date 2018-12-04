package com.virtualpairprogrammers.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.service.LoginService;

public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private LoginService loginService;
	
	
    public Login() {
    	super();
    	loginService = new LoginService();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeUtente =request.getParameter("username");
        String password = request.getParameter("password");
        request.getSession().setAttribute("username", nomeUtente);
        int userId= loginService.login(nomeUtente, password);
        request.getSession().setAttribute("userId", userId);
        System.out.println(nomeUtente + " "+ password);
     
        if (userId==1) {
        	getServletContext().getRequestDispatcher("/superuserhome.jsp").forward(request,response);
         }
        else if (userId==2) {
        	getServletContext().getRequestDispatcher("/CustomerHome.jsp").forward(request,response);
         }
        else {
        	getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
		
        }
	}

}
