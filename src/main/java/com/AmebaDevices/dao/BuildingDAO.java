package com.AmebaDevices.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AmebaDevices.model.Building;
import com.AmebaDevices.model.Customer;
 @Repository
 @Transactional
public interface BuildingDAO extends CrudRepository<Building, Long>{

	public List<Building> findByOwner(Customer ownerC);
	public Building findByAddressAndCityAndCapAndInterno(String address, String city, String cap, long interno);
	public List<Building> findByInstaller (Customer installer);
 }