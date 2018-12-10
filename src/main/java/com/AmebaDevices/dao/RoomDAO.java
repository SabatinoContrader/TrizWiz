package com.AmebaDevices.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AmebaDevices.model.Floor;
import com.AmebaDevices.model.Room;

@Repository
@Transactional
public interface RoomDAO extends CrudRepository<Room, Long> {

	public List<Room> findByFloor(Floor f);

}