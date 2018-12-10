package com.AmebaDevices.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.AmebaDevices.dto.BuildingDTO;
import com.AmebaDevices.dto.BuildingTreeDTO;
import com.AmebaDevices.dto.ItemDTO;
import com.AmebaDevices.dto.ThingDTO;
import com.AmebaDevices.services.BuildingService;
import com.AmebaDevices.services.FloorService;
import com.AmebaDevices.services.ItemService;
import com.AmebaDevices.services.RoomService;
import com.AmebaDevices.services.ThingService;
import com.AmebaDevices.utils.SolutionGenerator;

@Controller
@RequestMapping("/BuildingTree")
public class ThingItemsController {

	private FloorService floorService;
	private RoomService roomService;
	private ItemService itemService;
	private BuildingService buildingService;
	private ThingService thingService;
	long building;
	List<ThingDTO> things;

	@Autowired
	public ThingItemsController(FloorService _floorService, RoomService _roomService, ItemService _itemService,
			BuildingService _buildingService, ThingService ts) {
		this.floorService = _floorService;
		this.roomService = _roomService;
		this.itemService = _itemService;
		this.buildingService = _buildingService;
		this.thingService = ts;
	}

	@RequestMapping(value = "getTree", method = RequestMethod.GET)
	public String getAllThree(HttpServletRequest request) {
		long buildingId = Long.parseLong(request.getParameter("buildingId"));
		this.building = buildingId;
		BuildingTreeDTO buildingTree = this.BuildingTreeFromBuildingId(buildingId);

		things = thingService.searchThingsByBuilding(buildingService.findByPrimaryKey(buildingId));
		if (things.size() == 0) {
			SolutionGenerator s = new SolutionGenerator(thingService);
			things = s.generate(buildingTree.getItems().size());
			
		}
		things.forEach(t -> {

			t.setBuilding(buildingService.findByPrimaryKey(buildingId));
			thingService.update(t);
		});
		request.setAttribute("items", buildingTree.getItems());
		request.setAttribute("things", things);
		request.setAttribute("buildingTree", buildingTree);
		return "ThingTree";
	}

	@RequestMapping(value = "updateAssociation", method = RequestMethod.POST)
	public String updateAssociation(HttpServletRequest request) {
		long thingId = Long.parseLong(request.getParameter("thingId"));
		long itemId = Long.parseLong(request.getParameter("itemId"));
		ItemDTO item = itemService.searchItem(itemId);
		ThingDTO thing = thingService.searchThing(thingId);
		item.setThing(thing);
		itemService.updateItem(item);
		System.out.println("Thing id= " + thingId + "- item id= " + itemId);

		BuildingTreeDTO buildingTree = this.BuildingTreeFromBuildingId(building);

		request.setAttribute("items", buildingTree.getItems());
		request.setAttribute("things", things);
		request.setAttribute("buildingTree", buildingTree);
		return "ThingTree";
	}

	private BuildingTreeDTO BuildingTreeFromBuildingId(long _buildingId) {
		BuildingTreeDTO buildingTree = new BuildingTreeDTO();
		BuildingDTO building = buildingService.findByPrimaryKey(_buildingId);
		buildingTree.setBuilding(building);

		buildingTree.setFloors(this.floorService.getAllByBuilding(_buildingId));

		buildingTree.getAllFloors().forEach(floor -> {
			buildingTree.setRoomsByFloor(floor.getId(), roomService.getAllByFloor(floor));

			buildingTree.getRoomsByFloor(floor.getId()).forEach(room -> {
				buildingTree.setItemsByRoom(room.getId(), itemService.getAllByRoom(room));
			});
		});

		return buildingTree;
	}

}
