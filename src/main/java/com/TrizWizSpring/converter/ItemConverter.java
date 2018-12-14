package com.TrizWizSpring.converter;

import com.TrizWizSpring.dto.ItemDTO;
import com.TrizWizSpring.model.Item;

public class ItemConverter {
	
	public static ItemDTO convertToDto(Item i) {
		ItemDTO itemDTO=new ItemDTO();
		itemDTO.setIdItems(i.getIdItems());
		itemDTO.setCommento(i.getCommento());
		return itemDTO;
		//c
	}
	
	public static Item convertToItem(ItemDTO i) {
		Item item = new Item();
		item.setIdItems(i.getIdItems());
		item.setCommento(i.getCommento());
		return item;
	}
}
