package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.model.Floor;
import com.virtualpairprogrammers.service.FloorService;

/**
 * Servlet implementation class FloorController
 */
public class FloorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FloorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Nothing to do
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int buildingId = Integer.parseInt(request.getParameter("buildingId"));
		request.setAttribute("buildingId",String.valueOf(buildingId));
		RequestDispatcher dispatcher = null;
		FloorService fs = new FloorService();
		List <Floor> alreadyExisting = new ArrayList<>();
		alreadyExisting = fs.getAllByBuilding(buildingId);
		request.setAttribute("floors", alreadyExisting);
		String operation = request.getParameter("operation");
		
		switch (operation) {
		case "create":
			dispatcher = request.getRequestDispatcher("newFloor.jsp");
			break;
		case "read":
			
			RequestDispatcher view = request.getRequestDispatcher("/displayFloors.jsp");      
	        view.include(request, response);
			break;
		case "update":
			dispatcher = request.getRequestDispatcher("updateFloor.jsp");
			break;
		case "delete":
			dispatcher = request.getRequestDispatcher("deleteFloor.jsp");
			break;
		case "sendDataForInsert":
			String name = request.getParameter("floorName");
			String description = request.getParameter("floorDescription");
			String bid = (String) request.getAttribute("buildingId");
			FloorService newFloorService = new FloorService();
			Floor f = new Floor();
			f.setNomeFloor(name);
			f.setDescrizione(description);
			f.setIdBuilding(bid);
			newFloorService.insertFloor(f);
			dispatcher = request.getRequestDispatcher("floorManager.jsp");
			break;
		case "sendDataForUpdate":
			String newName = request.getParameter("floorName");
			String newDescription = request.getParameter("floorDescription");
			String buildingid = (String) request.getAttribute("buildingId");
			String floorId = request.getParameter("floorid");
			Floor newFloor = new Floor();
			newFloor.setId(floorId);
			newFloor.setNomeFloor(newName);
			newFloor.setDescrizione(newDescription);
			newFloor.setIdBuilding(buildingid);
			fs.update(newFloor);
			dispatcher = request.getRequestDispatcher("floorManager.jsp");
			break;
		case "home":
			dispatcher = request.getRequestDispatcher("floorManager.jsp");
			break;
		case "sendDataForDelete":
			int id = Integer.parseInt(request.getParameter("floorid"));
			fs.deleteById(id);
			dispatcher = request.getRequestDispatcher("floorManager.jsp");
			break;
		}
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		} 
		//	response.getWriter().append("Non capisco. Che fai?");
	}

}
