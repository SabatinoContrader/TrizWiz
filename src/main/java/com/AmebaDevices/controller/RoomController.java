package com.AmebaDevices.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.AmebaDevices.dto.FloorDTO;
import com.AmebaDevices.dto.RoomDTO;
import com.AmebaDevices.model.Building;
import com.AmebaDevices.model.Floor;
import com.AmebaDevices.model.Room;
import com.AmebaDevices.services.FloorService;
import com.AmebaDevices.services.RoomService;

@Controller
@RequestMapping("/Room")
public class RoomController {
	
    private RoomService rs;
    private FloorService fs;
    
@Autowired
    public RoomController(RoomService rs, FloorService fs) {
	this.rs=rs;
	this.fs = fs;
	
	}

@RequestMapping(value="/insertForm", method=RequestMethod.GET)
	public String insertForm(HttpServletRequest request) {
	String id = (String) request.getAttribute("floorId");
		return "InsertRoom";
	}

@RequestMapping(value="/insert", method=RequestMethod.POST)
public String insert(HttpServletRequest request) {
	String nome = (String) request.getParameter("nome");
	String descrizione = (String) request.getParameter("description");
	String id = (String) request.getParameter("floorId");
	FloorDTO f = fs.findByPrimaryKey(Long.parseLong(id));
	RoomDTO room = new RoomDTO();
	room.setNomeRoom(nome);
	room.setDescrizione(descrizione);
	room.setFloor(f);
	rs.insertRoom(room);
	request.setAttribute("floorId", id);
	List <RoomDTO> listaPerFloor = new ArrayList<>();
	listaPerFloor = rs.getAllByFloor(f);
	request.setAttribute("rooms", listaPerFloor);
	return "RoomHome";
}

@RequestMapping(value = "/menu", method = RequestMethod.GET)
public String menu(HttpServletRequest request) {
	long floorId =Long.parseLong(request.getParameter("floorId"));
	FloorDTO f = fs.findByPrimaryKey(floorId);
	request.setAttribute("floorId",String.valueOf(floorId));
	List <RoomDTO> listaPerFloor = new ArrayList<>();
	listaPerFloor = rs.getAllByFloor(f);
	request.setAttribute("rooms", listaPerFloor);
	return "RoomHome";
}



@RequestMapping(value="/updateForm", method= RequestMethod.GET)
public String updateForm(HttpServletRequest request) {
	long floorId =Long.parseLong(request.getParameter("floorId"));
	FloorDTO f = fs.findByPrimaryKey(floorId);
	request.setAttribute("floorId",String.valueOf(floorId));
	List <RoomDTO> listaPerFloor = new ArrayList<>();
	listaPerFloor = rs.getAllByFloor(f);
	request.setAttribute("rooms", listaPerFloor);
	return "UpdateRoom";
}

@RequestMapping(value="/update", method=RequestMethod.POST)
public String update(HttpServletRequest request) {
	String newName = request.getParameter("roomName");
	String newDescription = request.getParameter("roomDescription");
	String roomid = (String) request.getParameter("roomId");
	String floorid=(String) request.getParameter("floorId");
	FloorDTO f = fs.findByPrimaryKey(Long.parseLong(floorid));
	RoomDTO newRoom = new RoomDTO();
	newRoom.setId(Integer.parseInt(roomid));
	newRoom.setNomeRoom(newName);
	newRoom.setDescrizione(newDescription);
	newRoom.setFloor(f);
	rs.update(newRoom);	
	List <RoomDTO> listaPerFloor = new ArrayList<>();
	listaPerFloor = rs.getAllByFloor(f);
	request.setAttribute("rooms", listaPerFloor);
	System.out.println(listaPerFloor.size());
	return "RoomHome";	
}

@RequestMapping(value="/deleteForm",method=RequestMethod.GET)
public String deleteForm(HttpServletRequest request) {
	long floorId =Long.parseLong(request.getParameter("floorId"));
	FloorDTO f = fs.findByPrimaryKey(floorId);
	request.setAttribute("floorId",String.valueOf(floorId));
	List <RoomDTO> listaPerFloor = new ArrayList<>();
	listaPerFloor = rs.getAllByFloor(f);
	request.setAttribute("rooms", listaPerFloor);
	return "DeleteForm";
}

@RequestMapping(value="/delete", method=RequestMethod.POST)
public String delete(HttpServletRequest request) {
	String idRoom= request.getParameter("roomid");
	if (idRoom!= null) System.out.println(idRoom);
	else System.out.println("idroom is null");
	long floorId = Long.parseLong(request.getParameter("floorId"));
	FloorDTO f = fs.findByPrimaryKey(floorId);
	rs.delete(Integer.parseInt(idRoom));
	List <RoomDTO> listaPerFloor = rs.getAllByFloor(f);
	request.setAttribute("rooms", listaPerFloor);
	return "RoomHome";
}
	

}
