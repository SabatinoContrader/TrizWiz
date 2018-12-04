package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.Building;
import com.virtualpairprogrammers.service.BuildingService;

/**
 * Servlet implementation class BuildingServlet
 */
public class BuildingServlet extends HttpServlet {
	
	private BuildingService buildingService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuildingServlet() {
        super();
        // TODO Auto-generated constructor stub
        buildingService = new BuildingService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String scelta = request.getParameter("richiesta");
		String username = request.getSession().getAttribute("username").toString();
		List<Building> buildings = this.buildingService.getAll(username);
		switch (scelta) {
			case "BuildingMenu":
				getServletContext().getRequestDispatcher("/BuildingMenu.jsp").forward(request, response);
			break;
			case "InserisciBuilding":
				getServletContext().getRequestDispatcher("/InsertBuilding.jsp").forward(request, response);
			break;
			case "newBuilding":
				String indirizzo = request.getParameter("indirizzo");
				String interno = request.getParameter("interno");
				String citta = request.getParameter("citta");
				String cap = request.getParameter("cap");
				Building mynewBuilding = new Building(indirizzo, citta, cap, interno); 
				this.buildingService.create(username, mynewBuilding);
				getServletContext().getRequestDispatcher("/CustomerHome.jsp").forward(request, response);
			break;
			case "VisualizzaBuildings":
				request.setAttribute("buildings", buildings);
				RequestDispatcher view = request.getRequestDispatcher("/ReadBuilding.jsp");      
		        view.include(request, response);
				//getServletContext().getRequestDispatcher("/ReadBuilding.jsp").forward(request, response);
			break;
			case "ModificaBuilding":
				request.setAttribute("buildings", buildings);
				getServletContext().getRequestDispatcher("/UpdateBuilding.jsp").forward(request, response);
			break;
			case "UpdateBuilding":
				int buildingId = Integer.parseInt(request.getParameter("idselected"));
				Building building = buildingService.findByPrimaryKey(buildingId);
				String newindirizzo = request.getParameter("newindirizzo");
				String newinterno = request.getParameter("newinterno");
				String newcitta = request.getParameter("newcitta");
				String newcap = request.getParameter("newcap");
				Building newValues = new Building(newindirizzo, newcitta, newcap, newinterno);
				this.buildingService.update(building, newValues, username);
				getServletContext().getRequestDispatcher("/CustomerHome.jsp").forward(request, response);
				break;
			case "EliminaBuilding":
				request.setAttribute("buildings", buildings);
				getServletContext().getRequestDispatcher("/DeleteBuilding.jsp").forward(request, response);
			break;
			case "Delete":
				int toDelete = Integer.parseInt(request.getParameter("idselected"));
				Building toDestroy = buildingService.findByPrimaryKey(toDelete);
				this.buildingService.delete(toDestroy, username);
				getServletContext().getRequestDispatcher("/CustomerHome.jsp").forward(request, response);
			break;
			case "goBack":
				getServletContext().getRequestDispatcher("/CustomerHome.jsp").forward(request, response);;
			break;
		}
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
