package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.model.Room;
import com.virtualpairprogrammers.model.Thing;
import com.virtualpairprogrammers.service.RoomService;
import com.virtualpairprogrammers.service.ThingService;

/**
 * Servlet implementation class ThingManager
 */
public class ThingManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
  //  int idThing=1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThingManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = null;
		String operation = request.getParameter("operation");
		System.out.println(operation);
		ThingService ts = new ThingService();
		List <Thing> listaPerBuilding = new ArrayList<>();
		listaPerBuilding = ts.getAllItem();
		request.setAttribute("things", listaPerBuilding);
		switch (operation) {
		case "create":
			getServletContext().getRequestDispatcher("/newThing.jsp").forward(request,response);
			break;
		case "sendDataForInsert":
			String nomeThing = request.getParameter("thingName");
			int numeroUscite = Integer.parseInt(request.getParameter("numeroUscite"));
			Thing thing = new Thing(numeroUscite);
			thing.setNome(nomeThing);
			ts.create(thing);
			getServletContext().getRequestDispatcher("/thingManager.jsp").forward(request,response);
			break;
		case "home":
			getServletContext().getRequestDispatcher("/thingManager.jsp").forward(request,response);
			break;
		case "DeleteFormThing":
			getServletContext().getRequestDispatcher("/DeleteFormThing.jsp").forward(request,response);
			break;
    	
    	case "DeleteThing":
    		int idThing= Integer.parseInt(request.getParameter("id_thing"));
    		ThingService thingService = new ThingService();
    		thingService.delete(idThing);
    		getServletContext().getRequestDispatcher("/thingManager.jsp").forward(request,response);
    		break;
    	case "update":
    		getServletContext().getRequestDispatcher("/UpdateThing.jsp").forward(request, response);
    		break;
    	
    	case "sendDataForUpdate":
			int numberPort =Integer.parseInt(request.getParameter("numberPort"));
			String nameThing = request.getParameter("nameThing");
			String roomid = (String) request.getParameter("thingId");
			Thing newThing = new Thing();
			newThing.setId(roomid);
			newThing.setNumUscite(numberPort);
			newThing.setNome(nameThing);
			ts.update(newThing);
			getServletContext().getRequestDispatcher("/thingManager.jsp").forward(request, response);

			break;
    	
    	case "ReadThing":
    		request.setAttribute("things",listaPerBuilding);
    		RequestDispatcher view = request.getRequestDispatcher("/ReadThing.jsp");      
	        view.include(request, response);
    		break;
		}
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}


