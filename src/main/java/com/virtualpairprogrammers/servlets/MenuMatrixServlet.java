package com.virtualpairprogrammers.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuMatrixServlet extends HttpServlet {
    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String scelta = request.getParameter("richiesta");
        //System.out.println(scelta);
        HttpSession session = request.getSession(true);
        switch (scelta) {
            case "principi":
            	response.sendRedirect("homePrincipi.jsp");
                break;
            case "parametri":
            	response.sendRedirect("homeParametri.jsp");
                break;
            case "SolutionMenu":
            	response.sendRedirect("homeCustomers.jsp");
                break;
            case "Indietro":
            	response.sendRedirect("home.jsp");
                break;
           
        
        }

    }

}
