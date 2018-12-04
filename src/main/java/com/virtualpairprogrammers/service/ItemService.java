package com.virtualpairprogrammers.service;

import java.util.List;

import com.virtualpairprogrammers.dao.ItemDao;
import com.virtualpairprogrammers.model.Item;

public class ItemService {
	
	private ItemDao itemDao;
	
	public ItemService() {
		this.itemDao=new ItemDao();
	}
	
	public List<Item> getAllItem () {
        return this.itemDao.getAllItem();
    }
	
	public boolean insertItem(Item item) {
		return this.itemDao.insertItem(item);
	}
	
	public Item searchItem(String id) {
		return this.itemDao.searchItem(id);
	}
	
	public void updateItem(Item item) {
		itemDao.updateItem(item);
	}
	
	public void deleteItem(String id) {
		itemDao.deleteItem(id);
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
