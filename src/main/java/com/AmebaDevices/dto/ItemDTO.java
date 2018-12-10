package com.AmebaDevices.dto;

import com.AmebaDevices.model.ItemType;
import com.AmebaDevices.model.Room;

public class ItemDTO {

		private long id;
		private String seriale;
		private String consumoEnergetico;
		private RoomDTO room;
		private ItemTypeDTO itemType;
		private ThingDTO thing;
		
		public ItemDTO(long id, String seriale, String consumoEnergetico, RoomDTO room, ItemTypeDTO itemType, ThingDTO thing) {
			super();
			this.id = id;
			this.seriale=seriale;
			this.consumoEnergetico=consumoEnergetico;
			this.room=room;
			this.itemType=itemType;
			this.thing = thing;
		}
		
		
		public ThingDTO getThing() {
			return thing;
		}



		public void setThing(ThingDTO thing) {
			this.thing = thing;
		}



		public ItemDTO() {

		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getSeriale() {
			return seriale;
		}

		public void setSeriale(String seriale) {
			this.seriale = seriale;
		}

		public String getConsumoEnergetico() {
			return consumoEnergetico;
		}

		public void setConsumoEnergetico(String consumoEnergetico) {
			this.consumoEnergetico = consumoEnergetico;
		}

		public RoomDTO getRoom() {
			return room;
		}

		public void setRoom(RoomDTO roomDTO) {
			this.room = roomDTO;
		}

		public ItemTypeDTO getItemType() {
			return itemType;
		}

		public void setItemType(ItemTypeDTO itemType) {
			this.itemType = itemType;
		}
		
		

		
}
