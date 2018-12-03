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
	    /*        case "AggPrincipi":
	            	List<Sintomo> sintomo2 = sintomoService.getAllSympthom();
	            	request.put("listaSintomi", sintomo2);
	            	MainDispatcher.getInstance().callView("UpdateSintomo", request);
	            	break;
	            case "updatePrincipi":
	            	if (sintomoService.updateSypthom(request)) {
	            		this.message = "Sintomo modificato con successo..."; 
	            	}
	            	else {
	            		this.message = "Errore durante la modifica del Sintomo...!!!";
	            	}
	            	request.put("message", this.message);
	        		MainDispatcher.getInstance().callView("Sintomo", request);
	            	break;
	    */
	    /////////////////////// --- DELETE --- /////////////////////////////	
	    /*        case "CanPrincipi":
	            	List<Sintomo> sintomo3 = sintomoService.getAllSympthom();
	            	request.put("listaSintomi", sintomo3);
	            	MainDispatcher.getInstance().callView("DeleteSintomo", request);
	            	break;
	            case "deletePrincipi":
	            	if (this.sintomoService.DeleteSintomo((Integer) request.get("deleteSintomo"))) {
	            		this.message = "Cancellazione sintomo avvenuta correttamente";
	            	}
	            	else {
	            		this.message = "Errore durante la procedura di cancellazione sintomo";
	            	}
	            	request.put("message", this.message);
	            	MainDispatcher.getInstance().callView("Sintomo", request);
	            	break;
	      */
	            
	        }
        
	}

}
