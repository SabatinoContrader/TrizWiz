package main.controller;

import java.util.List;

import main.MainDispatcher;

import main.model.Principio;
import main.service.CrudPrincipiService;

public class CrudPrincipiController implements Controller{
	
	private CrudPrincipiService CrudPrincipiService;
	private String message;

	
	@Override
	public void doControl(Request request) {
		
		this.CrudPrincipiService = new CrudPrincipiService();
        String choice = request.get("choice").toString();
        this.message = "";
        
        switch (choice) {
        /////////////////////// --- INSERT --- /////////////////////////////
	            case "InsPrincipi":
	            	MainDispatcher.getInstance().callView("InsertPrincipio", request);
	            	break;
	            case "insertPrincipio":
	            	if (this.CrudPrincipiService.insertPrincipio((Principio)request.get("insertPrincipio"))) {
	            		this.message = "Principio inserito con successo...";            		
	            	}
	            	else {
	            		this.message = "Errore durante l'inserimento del Principio...!!!";
	            	}
	            	
	            	request.put("message", this.message);
	            	MainDispatcher.getInstance().callView("PrincipiMenu", request);
	            	break;
	            	
		/////////////////////// --- UPDATE --- /////////////////////////////
	            	
	            case "AggPrincipi":
	            	MainDispatcher.getInstance().callView("AggPrincipio", request);
	            	break;
	            case "updatePrincipi":
	            	if (this.CrudPrincipiService.updatePrincipi((Principio)request.get("updatePrincipi"))) {
	            		this.message = "Principio modificato con successo..."; 
	            	}
	            	else {
	            		this.message = "Errore durante la modifica del Principio...!!!";
	            	}
	            	request.put("message", this.message);
	        		MainDispatcher.getInstance().callView("PrincipiMenu", request);
	            	break;
	    
	    /////////////////////// --- DELETE --- /////////////////////////////	
	    
	            case "CanPrincipi":
	            	MainDispatcher.getInstance().callView("DelPrincipio", request);
	            	break;
	            case "deletePrincipio":
	            	if (this.CrudPrincipiService.deletePrincipio((Integer) request.get("deletePrincipio"))) {
	            		this.message = "Cancellazione principio avvenuta correttamente";
	            	}
	            	else {
	            		this.message = "Errore durante la procedura di cancellazione principio";
	            	}
	            	request.put("message", this.message);
	            	MainDispatcher.getInstance().callView("PrincipiMenu", request);
	            	break;
	      
	            
	        }
        
	}

}
