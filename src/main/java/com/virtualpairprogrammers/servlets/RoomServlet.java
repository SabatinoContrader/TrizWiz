package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.Room;
import com.virtualpairprogrammers.service.RoomService;

/**
 * Servlet implementation class RoomServlet
 */
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int floorId;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int floorId =Integer.parseInt(request.getParameter("floorId"));
		request.setAttribute("floorId",String.valueOf(floorId));
		String choice = request.getParameter("richiesta");
		RoomService fs = new RoomService();
		List <Room> listaPerFloor = new ArrayList<>();
		listaPerFloor = fs.getAllByFloor(floorId);
		request.setAttribute("rooms", listaPerFloor);
        	switch (choice) {
        	case "InsertForm":
        		getServletContext().getRequestDispatcher("/InsertRoom.jsp").forward(request,response);
        		break;
        	case "InsertRoom":
        	
            	String nome = (String) request.getParameter("nome");
            	String descrizione = (String) request.getParameter("description");
            	String id2 = (String) request.getAttribute("floorId");
            	RoomService newRoomService = new RoomService();

    			Room f = new Room();
    			f.setNomeRoom(nome);
    			f.setDescrizione(descrizione);
    			f.setIdFloor(id2);
    			newRoomService.insertRoom(f);
    			getServletContext().getRequestDispatcher("/RoomHome.jsp").forward(request,response);

            	break;
            	
        	case "ReadRoom":
        		request.setAttribute("rooms",listaPerFloor );
        		RequestDispatcher view = request.getRequestDispatcher("/ReadRoom.jsp");      
    	        view.include(request, response);
        		break;
        		
        	case "Return":
        		getServletContext().getRequestDispatcher("/ReadHome.jsp").forward(request,response);
        		break;
        		
        	case "home":
        		if(this.floorId == 0) {
        			this.floorId = Integer.parseInt(request.getParameter("floorId"));
        		}
        		getServletContext().getRequestDispatcher("/RoomHome.jsp").forward(request,response);
        	break;
        		
        	case "DeleteForm":
        		getServletContext().getRequestDispatcher("/DeleteForm.jsp").forward(request,response);
        		break;
        	
        	case "DeleteRoom":
        		int idRoom= Integer.parseInt(request.getParameter("id_room"));
        		//System.out.println(idRoom);
        		RoomService newRoomService2 = new RoomService();
        		newRoomService2.delete(idRoom);
        		getServletContext().getRequestDispatcher("/RoomHome.jsp").forward(request,response);
        		break;
        		
        	/*case "SearchForm":
        		request.setAttribute("rooms",rooms );
        		getServletContext().getRequestDispatcher("/SearchFormRoom.jsp").forward(request,response);
        		break;
        	
        	case "UpdateRoom":
        		int id = Integer.parseInt(request.getParameter("idselected"));
    			//System.out.println(request.getParameter("selected"));
    			//System.out.println(id);
    			Room room;
    			
    			room= roomService.searchRoom(id);
        		switch (Integer.parseInt(request.getParameter("campi"))) {

    			case 1:
    				room.setNomeRoom(request.getParameter("value"));
    				break;
    			case 2:
    				room.setDescrizione(request.getParameter("value"));
    				break;
    			}
        		
    			roomService.update(room);
    			
    			getServletContext().getRequestDispatcher("/RoomHome.jsp").forward(request, response);
    			break;
    			*/
        	case "update":
        		getServletContext().getRequestDispatcher("/UpdateRoom.jsp").forward(request, response);
        		break;
        	case "sendDataForUpdate":
    			String newName = request.getParameter("roomName");
    			String newDescription = request.getParameter("roomDescription");
    			String roomid = (String) request.getParameter("roomId");
    			String floorid=(String) request.getAttribute("floorId");
    			Room newRoom = new Room();
    			newRoom.setId(Integer.parseInt(roomid));
    			newRoom.setNomeRoom(newName);
    			newRoom.setDescrizione(newDescription);
    			newRoom.setIdFloor(floorid);
    			fs.update(newRoom);
    			getServletContext().getRequestDispatcher("/RoomHome.jsp").forward(request, response);

    			break;
        	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}
}
