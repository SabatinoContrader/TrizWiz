package com.AmebaDevices.converter;

import com.AmebaDevices.dto.FloorDTO;
import com.AmebaDevices.model.Floor;

public class FloorConverter {

	public static FloorDTO convertToDto(Floor f) {
		FloorDTO floor= new FloorDTO();
		floor.setId(f.getId());
		floor.setDescrizione(f.getDescrizione());
		floor.setNomeFloor(f.getNomeFloor());
		floor.setBuilding(BuildingConverter.convertToDto(f.getBuilding()));
		return floor;
	}
	
	public static Floor convertToFloor(FloorDTO f) {
		Floor floor= new Floor();
		floor.setId(f.getId());
		floor.setDescrizione(f.getDescrizione());
		floor.setNomeFloor(f.getNomeFloor());
		floor.setBuilding(BuildingConverter.convertToBuilding(f.getBuilding()));
		return floor;
	}
}
