package com.AmebaDevices.dao;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AmebaDevices.model.ItemType;
import com.AmebaDevices.model.Room;

@Repository
public interface ItemTypeDao extends CrudRepository<ItemType,Long> {
	
	
}