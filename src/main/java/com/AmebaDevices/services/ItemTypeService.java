package com.AmebaDevices.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmebaDevices.converter.ItemTypeConverter;
import com.AmebaDevices.dao.ItemTypeDao;
import com.AmebaDevices.dto.ItemTypeDTO;
import com.AmebaDevices.model.Customer;
import com.AmebaDevices.model.Floor;
import com.AmebaDevices.model.ItemType;
import com.AmebaDevices.model.Room;

@Service
public class ItemTypeService {
	
	private ItemTypeDao itemTypeDao;
	@Autowired
	public ItemTypeService(ItemTypeDao itemTypeDao) {
		this.itemTypeDao=itemTypeDao;
	}
	
	public List<ItemTypeDTO> getAllItemType () {
		List<ItemTypeDTO> items = new ArrayList<>();
		itemTypeDao.findAll().forEach(c -> {
			items.add(ItemTypeConverter.convertToDto(c));	});
		return items;
	}

	
	public void insertItemType(ItemTypeDTO item) {
		 this.itemTypeDao.save(ItemTypeConverter.convertToItem(item));
	}
	
	public ItemTypeDTO searchItemType(Long id) {
		return ItemTypeConverter.convertToDto(this.itemTypeDao.findOne(id));
	}
	
	public void updateItemType(ItemTypeDTO item) {
		if (itemTypeDao.findOne(item.getId())!=null)
		this.itemTypeDao.save(ItemTypeConverter.convertToItem(item));
	}
	
	public void deleteItemType(Long id) {
		ItemType item = itemTypeDao.findOne(id);
		itemTypeDao.delete(item);
		
	}

	public ItemTypeDTO findByPrimaryKey(long itemTypeId) {
		ItemTypeDTO item= ItemTypeConverter.convertToDto(itemTypeDao.findOne(itemTypeId));
		return item;
	}


	/*
	public List<Item> getByBuilding(int buildingId) {
		return itemDao.getByBuilding(buildingId);
	}

	public List<Item> getAllByRoom(int id) {
		return itemDao.getAllByRoom(id);
	}
	*/

}
