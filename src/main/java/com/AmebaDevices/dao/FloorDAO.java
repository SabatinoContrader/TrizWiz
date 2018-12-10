package com.AmebaDevices.dao;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.AmebaDevices.model.Building;
import com.AmebaDevices.model.Floor;

@Repository
@Transactional
public interface FloorDAO extends CrudRepository<Floor, Long> {

	public List<Floor> findByBuilding(Building b);
	
	}
