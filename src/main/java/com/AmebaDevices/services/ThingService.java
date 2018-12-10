package com.AmebaDevices.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.controller.BuildingController;
import com.AmebaDevices.converter.BuildingConverter;
import com.AmebaDevices.converter.ItemConverter;
import com.AmebaDevices.converter.ThingConverter;
import com.AmebaDevices.dao.ItemDAO;
import com.AmebaDevices.dao.ThingDAO;
import com.AmebaDevices.dto.BuildingDTO;
import com.AmebaDevices.dto.ItemDTO;
import com.AmebaDevices.dto.ThingDTO;
import com.AmebaDevices.model.Item;
import com.AmebaDevices.model.Thing;

@Service
public class ThingService {

	private ThingDAO thingDAO;
	private ItemDAO itemDAO;

	@Autowired
	public ThingService(ThingDAO thingdao, ItemDAO itemdao) {
		this.thingDAO = thingdao;
		this.itemDAO = itemdao;
	}

	public List<ItemDTO> getAllItems(ThingDTO thing) {
		List<ItemDTO> toRet = new ArrayList<>();
		List<Item> items = itemDAO.findByThing(ThingConverter.convertToThing(thing));
		for (int i = 0; i < items.size(); i++) {
			toRet.add(ItemConverter.convertToDto(items.get(i)));
		}

		return toRet;
	}

	public ThingDTO create(ThingDTO t) {
		return ThingConverter.convertToDto(thingDAO.save(ThingConverter.convertToThing(t)));

	}

	public ThingDTO searchThing(long id) {
		return ThingConverter.convertToDto(thingDAO.findOne(id));

	}

	public List<ThingDTO> searchThingsByBuilding(BuildingDTO building) {
		List<ThingDTO> toReturn = new ArrayList<>();
		thingDAO.findByBuilding(BuildingConverter.convertToBuilding(building)).forEach(t -> {

			toReturn.add(ThingConverter.convertToDto(t));
		});
		return toReturn;
	}

	public void delete(long id) {
		thingDAO.delete(id);
	}

	public void update(ThingDTO newThing) {
		this.thingDAO.save(ThingConverter.convertToThing(newThing));
	}

}
