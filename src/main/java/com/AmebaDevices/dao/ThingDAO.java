package com.AmebaDevices.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AmebaDevices.model.Building;
import com.AmebaDevices.model.Thing;

@Repository
public interface ThingDAO extends CrudRepository<Thing, Long> {
	
	public List<Thing> findByBuilding(Building building);
	
}
