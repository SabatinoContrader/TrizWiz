package com.virtualpairprogrammers.service;

import java.util.List;

import com.virtualpairprogrammers.model.Building;
import com.virtualpairprogrammers.model.Thing;

public class ThingService {
	
	private ThingDAO thingDAO;
	
	
	public ThingService() {	
		thingDAO = new ThingDAO();	
	}
	
	public void create(Thing t) {
		thingDAO.create(t);
		
	}
	
	public List<Thing> getAllItem(){
		return this.thingDAO.getAllItem();
	}
	
	/*public List<Thing> getAllByBuilding(int buildingId) {
		return thingDAO.getAllByBuilding(buildingId);
	}
	
	public Thing searchThing(String id) {
		return thingDAO.searchThing(id);
	}*/
	
	public void delete(int id) {
		thingDAO.delete(id);
	}

	public void update(Thing newThing) {
		this.thingDAO.update(newThing);
	}
	
	

}
