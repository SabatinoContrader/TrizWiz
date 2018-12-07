package com.virtualpairprogrammers.service;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;
import com.virtualpairprogrammers.dao.VparametroDAO;
import com.virtualpairprogrammers.dto.ParametroDTO;
import com.virtualpairprogrammers.dto.ParametroNomeDTO;
import com.virtualpairprogrammers.model.Parametro;

public class VparametroServiceDTO {

	private VparametroDAO vParametroDAO;
	private List <ParametroDTO> listParametroDTO;
	private List <ParametroNomeDTO> listParametroNomeDTO;
	
	public VparametroServiceDTO(){
		this.vParametroDAO=new VparametroDAO();
		//listParametroDTO= new ArrayList<ParametroDTO>();
		
	}
	
	public VparametroServiceDTO(VparametroDAO vParametroDAO){
	
	this.vParametroDAO=vParametroDAO;
	//listParametroDTO= new ArrayList<ParametroDTO>();
		
	}
	
	public List<ParametroDTO> getAllParametroDTO () { //ritorna tutti i valori di Parametro in una lista Parametro DTO
		
		List <Parametro> listaParametri= this.vParametroDAO.getAllParametro();
		
		//listaParametri= this.vParametroDAO.getAllParametro();
		//ListIterator <Parametro> itParametro= (ListIterator<Parametro>) listaParametri.listIterator();
		for (Parametro parametroDAO: listaParametri) {
			
			ParametroDTO parametroDTO= new ParametroDTO();
			parametroDTO.setIdDTO(parametroDAO.getId());
			parametroDTO.setNomeParametroDTO(parametroDAO.getNomeParametro());
			parametroDTO.setNomeParametroItaDTO(parametroDAO.getNomeParametroIta());
			parametroDTO.setDescrizioneDTO(parametroDAO.getDescrizione());
			parametroDTO.setDescrizioneItaDTO(parametroDAO.getDescrizioneIta());
			parametroDTO.setIconaDTO(parametroDAO.getIcona());
			
			listParametroDTO.add(parametroDTO);
			
			
		}
       
       return listParametroDTO;
    }
	
public List<ParametroNomeDTO> getAllParametroNomeDTO () {//ritorna solo alcuni valori Parametro in una lista ParametroNomeDTO
		
		List <Parametro> listaParametri= this.vParametroDAO.getAllParametro();
		listParametroNomeDTO= new ArrayList<ParametroNomeDTO>();
		//listaParametri= this.vParametroDAO.getAllParametro();
		//ListIterator <Parametro> itParametro= (ListIterator<Parametro>) listaParametri.listIterator();
		for (Parametro parametroDAO: listaParametri) {
			
			ParametroNomeDTO parametroDTO= new ParametroNomeDTO();
			parametroDTO.setIdDTO(parametroDAO.getId());
			parametroDTO.setNomeParametroDTO(parametroDAO.getNomeParametro());
			
			listParametroNomeDTO.add(parametroDTO);
			
			
		}
       
       return listParametroNomeDTO;
    }

	 public ParametroDTO getParametroDTOID(String id) {
	  
		 Parametro parametroDAO= this.vParametroDAO.getParametroID(id);
		 
		 ParametroDTO parametroDTO=new ParametroDTO();
		 
		    parametroDTO.setIdDTO(parametroDAO.getId());
			parametroDTO.setNomeParametroDTO(parametroDAO.getNomeParametro());
			parametroDTO.setNomeParametroItaDTO(parametroDAO.getNomeParametroIta());
			parametroDTO.setDescrizioneDTO(parametroDAO.getDescrizione());
			parametroDTO.setDescrizioneItaDTO(parametroDAO.getDescrizioneIta());
			parametroDTO.setIconaDTO(parametroDAO.getIcona());
			
			return parametroDTO;
	 }
	 
	 public ParametroNomeDTO getParametroNomeDTOID(String id) {
		  
		 Parametro parametroDAO= this.vParametroDAO.getParametroID(id);
		 
		 ParametroNomeDTO parametroNomeDTO=new ParametroNomeDTO();
		 
		    parametroNomeDTO.setIdDTO(parametroDAO.getId());
			parametroNomeDTO.setNomeParametroDTO(parametroDAO.getNomeParametro());
			
			return parametroNomeDTO;
}


	
}
