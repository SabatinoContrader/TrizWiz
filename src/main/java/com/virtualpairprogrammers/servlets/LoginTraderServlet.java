package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.service.LoginService;
import com.virtualpairprogrammers.service.LoginServicertt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginTraderServlet extends HttpServlet {

    private LoginService loginService;

    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
    	
    	String richiesta = request.getParameter("richiestaLogin").toString();
    	if (richiesta.equals("Registrati")) {
    		getServletContext().getRequestDispatcher("/register.jsp").forward(request,response);
    	}
    	else {
        loginService =  new LoginService();
        HttpSession session = request.getSession();
        session.setAttribute("utente", null);
        if (request != null) {
        String nomeUtente = request.getParameter("username").toString();
        String password = request.getParameter("password").toString();
        if (loginService.login(nomeUtente, password)) {
            session.setAttribute("utente", nomeUtente);
            //response.sendRedirect("home.jsp");
            getServletContext().getRequestDispatcher("/home.jsp").forward(request,response);
        }
        else
            //response.sendRedirect("login.jsp");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
        }
    	}
    }
}
