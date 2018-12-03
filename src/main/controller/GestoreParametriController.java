package main.controller;

import java.util.List;

import main.MainDispatcher;
import main.model.Parametro;
import main.model.Principio;
import main.service.VparametroService;

public class GestoreParametriController implements Controller{
	
	private VparametroService VparametroService;
	private String message;


	 public void doControl(Request request)  {
	    	
		    this.VparametroService= new VparametroService();
	    	String choice = request.get("choice").toString();
	        if (choice != null ) {//se problemi da verificare
	        	switch (choice) {//se problemi da verificare
	            
	    		case "InsParametri":
	    			MainDispatcher.getInstance().callView("InsertParametro", request);
	            	break;
	            
	    		case "insertParametro":
	    			if (this.VparametroService.insertParametro((Parametro)request.get("insertParametro"))) {
	            		this.message = "Parametro inserito con successo...";            		
	            	}
	            	else {
	            		this.message = "Errore durante l'inserimento del Parametro...!!!";
	            	}
	            	
	            	request.put("message", this.message);
	            	MainDispatcher.getInstance().callView("ParametrilMenu", request);
	            	break;
	            
	    		case "CanParametri":
	    			
	    			request.put("visualizzaParametri",this.VparametroService.getAllParametro());
	    			MainDispatcher.getInstance().callView("DeleteParametro", request);
	    			break;
	    			
	    		case "deleteParametro":
	    			
	    			if(this.VparametroService.deleteParametro(Integer.parseInt(request.get("deleteIdParametro").toString()))){
	    				this.message = "CANCELLAZIONE PARAMETRO AVVENUTA CON SUCCESSO";
	    			}
	    			else {
	    				this.message = "CANCELLAZIONE PARAMETRO NON AVVENUTA CON SUCCESSO";
	    			}
	    			request.put("message", this.message);
	    			MainDispatcher.getInstance().callView("ParametriMenu", request);
	    			break;
	    			
	            case "AggParametri":
	            	MainDispatcher.getInstance().callView("AggParametro", request);
	            	break;
	            case "updateParametri":
	            	if (this.VparametroService.updateParametri((Parametro)request.get("updateParametri"))) {
	            		this.message = "Principio modificato con successo..."; 
	            	}
	            	else {
	            		this.message = "Errore durante la modifica del Principio...!!!";
	            	}
	            	request.put("message", this.message);
	        		MainDispatcher.getInstance().callView("ParametriMenu", request);
	            	break;
	    		
	    		
	    	}
	            	
	        }
	        
	      else {
	    	  MainDispatcher.getInstance().callView("Home", null);
	      }
	      
	    }
}