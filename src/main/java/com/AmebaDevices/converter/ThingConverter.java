package com.AmebaDevices.converter;

import com.AmebaDevices.dto.ThingDTO;
import com.AmebaDevices.model.Thing;

public class ThingConverter {

	public static ThingDTO convertToDto(Thing t) {
		ThingDTO thing = new ThingDTO();
		thing.setId(t.getId());
		thing.setPrezzo(t.getPrezzo());
		thing.setNumUscite(t.getNumUscite());
		if(t.getBuilding()!=null)
		thing.setBuilding(BuildingConverter.convertToDto(t.getBuilding()));
		return thing;
	}

	public static Thing convertToThing(ThingDTO t) {
		Thing thing = new Thing();
		thing.setId(t.getId());
		thing.setPrezzo(t.getPrezzo());
		thing.setNumUscite(t.getNumUscite());
		if(t.getBuilding()!=null)
		thing.setBuilding(BuildingConverter.convertToBuilding(t.getBuilding()));
		return thing;
	}

}
