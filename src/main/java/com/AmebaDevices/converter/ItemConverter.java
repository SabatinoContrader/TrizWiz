package com.AmebaDevices.converter;

import com.AmebaDevices.dto.ItemDTO;
import com.AmebaDevices.dto.ItemTypeDTO;
import com.AmebaDevices.model.Item;
import com.AmebaDevices.model.ItemType;

public class ItemConverter{ 

public static ItemDTO convertToDto(Item i) {
	ItemDTO item= new ItemDTO();
	item.setId(i.getId());
	item.setConsumoEnergetico(i.getConsumoEnergetico());
	item.setSeriale(i.getSeriale());
	item.setRoom(RoomConverter.convertToDto(i.getRoom()));
	item.setItemType(ItemTypeConverter.convertToDto(i.getItemType()));
	if(i.getThing()!=null)
	item.setThing(ThingConverter.convertToDto(i.getThing()));
	return item;
	
	}

public static Item convertToItem(ItemDTO i) {
	Item item = new Item();
	item.setId(i.getId());
	item.setConsumoEnergetico(i.getConsumoEnergetico());
	item.setSeriale(i.getSeriale());
	item.setRoom(RoomConverter.convertToRoom(i.getRoom()));
	item.setItemType(ItemTypeConverter.convertToItem(i.getItemType()));
	if(i.getThing()!=null)
	item.setThing(ThingConverter.convertToThing(i.getThing()));
	return item;
  	}
}
