package com.AmebaDevices.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.AmebaDevices.dto.ItemTypeDTO;
import com.AmebaDevices.model.Building;
import com.AmebaDevices.model.Floor;

import com.AmebaDevices.model.ItemType;
import com.AmebaDevices.model.Room;
import com.AmebaDevices.services.ItemTypeService;
import com.AmebaDevices.services.RoomService;

@Controller
@RequestMapping("/ItemType")
public class ItemTypeController  {
	private ItemTypeService itemTypeService;

	@Autowired
	public ItemTypeController(ItemTypeService itemTypeService) {
		this.itemTypeService =itemTypeService; 
	}

	@RequestMapping(value = "insertForm", method = RequestMethod.GET)
	public String insertForm(HttpServletRequest request) {
		return "CensimentoItemTypeForm";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		String marca = request.getParameter("marca");
		String modello = request.getParameter("modello");
		String categoria = request.getParameter("categoria");
		String descrizione = request.getParameter("descrizione");


		ItemTypeDTO item = new ItemTypeDTO();

		item.setCategoria(categoria);
		item.setMarca(marca);
		item.setModello(modello);
		item.setDescrizione(descrizione);
		itemTypeService.insertItemType(item);
		List <ItemTypeDTO> catalogo = new ArrayList<>();
		catalogo = itemTypeService.getAllItemType();
		request.setAttribute("items", catalogo);

		return "ItemTypeMenu";
	}

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(HttpServletRequest request) {


		List<ItemTypeDTO> catalogo= new ArrayList<>();
		catalogo= itemTypeService.getAllItemType(); // fare metodo per ricercare gli item per room
		request.setAttribute("items", catalogo);

		//Room room= roomService.findByPrimaryKey(roomId);
		List<ItemTypeDTO> listaPerRoom= new ArrayList<>();
		listaPerRoom= itemTypeService.getAllItemType(); 
		request.setAttribute("items", listaPerRoom);

		return "ItemTypeMenu";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(HttpServletRequest request) {
		List<ItemTypeDTO> items = itemTypeService.getAllItemType();
		request.setAttribute("items", items);
		return "VisualizzaItemsType";
	}

	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm(HttpServletRequest request) {

		return "ModificaItemTypeForm";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		Long id= Long.parseLong(request.getParameter("id"));
		String marca = request.getParameter("marca");
		String modello = request.getParameter("modello");
		String categoria = request.getParameter("categoria");
		String descrizione = request.getParameter("descrizione");

		String roomdiD= request.getParameter("roomId");
		//Room room= roomService.findByPrimaryKey(Long.parseLong(roomdiD));

		ItemTypeDTO item = new ItemTypeDTO(id, categoria, marca, modello, descrizione);

		item.setId(id);

		item.setMarca(marca);
		item.setModello(modello);
		item.setCategoria(categoria);
		item.setDescrizione(descrizione);

		itemTypeService.updateItemType(item);
		List<ItemTypeDTO> listaPerRoom= new ArrayList<>();
		itemTypeService.updateItemType(item);
		listaPerRoom= itemTypeService.getAllItemType(); 
		request.setAttribute("items", listaPerRoom);

		ItemTypeDTO updatedItem = itemTypeService.searchItemType(id);
		request.setAttribute("item", updatedItem);

		//ItemType updatedItem = itemTypeService.searchItemType(id);
		//request.setAttribute("item", updatedItem);
		return "ItemTypeMenu";

	}

	@RequestMapping(value = "/deleteForm", method = RequestMethod.GET)
	public String deleteForm(HttpServletRequest request) {
		return "EliminaItemTypeForm";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		String deleteId = request.getParameter("id");

		itemTypeService.deleteItemType((long) Integer.parseInt(deleteId));
		List<ItemTypeDTO> catalogo= new ArrayList<>();
		
		catalogo= itemTypeService.getAllItemType(); 
		request.setAttribute("items", catalogo);
		return "ItemTypeMenu";
	}

	@RequestMapping(value = "/goBack", method = RequestMethod.GET)
	public String goBack(HttpServletRequest request) {
		return "ItemTypeMenu";
	}
}
