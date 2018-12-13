/*package com.AmebaDevices.converter;

import com.AmebaDevices.dto.TrizCustomerDTO;
import com.AmebaDevices.model.Customer;

public class TrizCustomerConverter {

	public static TrizCustomerDTO convertToDto(TrizCustomer c) {
		TrizCustomerDTO trizcustomerDTO=new TrizCustomerDTO();
		TrizCustomerDTO.setId(c.getId());
		TrizCustomerDTO.setNome(c.getNome());
		TrizCustomerDTO.setCognome(c.getCognome());
		
		return trizcustomerDTO;
	}
	
	public static TrizCustomer convertToTrizCustomer(TrizCustomerDTO c) {
		TrizCustomer trizcustomer= new TrizCustomer();
		trizcustomer.setIdCustomer(c.getIdCustomer());
		trizcustomer.setNome(c.getNome());
		trizcustomer.setCognome(c.getCognome());
		
		return trizcustomer;
	}
	
}
*/
package com.AmebaDevices.converter;

import com.AmebaDevices.dao.TrizCustomerDAO;
import com.AmebaDevices.dto.BuildingDTO;
import com.AmebaDevices.dto.TrizCustomerDTO;
import com.AmebaDevices.dto.utentiLocaliDTO;
import com.AmebaDevices.model.Building;
import com.AmebaDevices.model.trizcustomer;
import com.AmebaDevices.model.utentiLocali;

public class TrizCustomerConverter {
	public static TrizCustomerDTO convertToDto(trizcustomer t) {
		TrizCustomerDTO trizCustomerDTO=new TrizCustomerDTO();
		trizCustomerDTO.setCognome(t.getCognome());
		trizCustomerDTO.setNome(t.getNome());
		trizCustomerDTO.setIdCustomer(t.getIdCustomer());
		//trizCustomerDTO.setUsername(t.getUsername());
		return trizCustomerDTO;
}
	
	public static trizcustomer convertTotrizcustomer (TrizCustomerDTO c) {
		trizcustomer trizcustomer= new trizcustomer();
		trizcustomer.setCognome(c.getCognome());
        trizcustomer.setNome(c.getNome());
      //  trizcustomer.setUsername(c.getUsername());
		trizcustomer.setIdCustomer(c.getIdCustomer());
		return trizcustomer;
	}


		
		
		
		//trizCustomerDTO.setUsername(t.getUsername());

		//utentiLocaliDTO.setpasswordLogin(c.getPasswordLogin());
		/*
		if (t.getIdCustomer() != null) 
			trizcustomer.setUsername(TrizCustomerConverter.convertToDto(trizcustomer));    
		return trizcustomer;*/
	}

	



