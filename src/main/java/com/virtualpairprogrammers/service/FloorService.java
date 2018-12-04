package com.virtualpairprogrammers.service;

import java.util.List;

import com.virtualpairprogrammers.dao.FloorDAO;
import com.virtualpairprogrammers.model.Floor;

public class FloorService {
	
	private FloorDAO floordao;
	
	public FloorService() {
		floordao = new FloorDAO();
	}
	
	
	public boolean insertFloor(Floor f) {
		return this.floordao.insertFloor(f);
	}
	
	public List <Floor> getAllByBuilding (int buildingid){
		return floordao.getAllByBuilding(buildingid);
	}
	
	public void delete(Floor f) {
		this.floordao.delete(f);
	}
		
	public void update (Floor f) {
		this.floordao.update(f);
	}
	
	public Floor findByPrimaryKey(int id) {
		return this.floordao.findByPrimaryKey(id);
	}


	public void deleteById(int id) {
		this.floordao.deleteById(id);
		
	}

	
}
