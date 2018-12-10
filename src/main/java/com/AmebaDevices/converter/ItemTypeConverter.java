package com.AmebaDevices.converter;

import com.AmebaDevices.dto.ItemTypeDTO;
import com.AmebaDevices.model.ItemType;

public class ItemTypeConverter {

	public static ItemTypeDTO convertToDto(ItemType i) {
		ItemTypeDTO item = new ItemTypeDTO();
		item.setId(i.getId());
		item.setDescrizione(i.getDescrizione());
		item.setCategoria(i.getCategoria());
		item.setMarca(i.getMarca());
		item.setModello(i.getModello());
		return item;
	}

	public static ItemType convertToItem(ItemTypeDTO i) {
		ItemType item = new ItemType();
		item.setId(i.getId());
		item.setDescrizione(i.getDescrizione());
		item.setCategoria(i.getCategoria());
		item.setMarca(i.getMarca());
		item.setModello(i.getModello());
		return item;
	}
}
