package main.controller;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import main.MainDispatcher;
import main.service.VparametroService;

public class ParametriController implements Controller {
	
	private VparametroService VparametroService;
	private String message;
    
	

    public void doControl(Request request)  {
    	this.VparametroService= new VparametroService();
    	this.message= "";
    	String choice = request.get("choice").toString();
        if (choice != null ) {//se problemi da verificare
        	switch (choice) {//se problemi da verificare
            
    		case "Vparametri":
    		
    			request.put("visualizzaParametri",this.VparametroService.getAllParametro());
    			MainDispatcher.getInstance().callView("Parametro", request); 
    			break;
        	
    		case "SelParametro":
    			request.put("visualizzaParametri",this.VparametroService.getAllParametro());
            	MainDispatcher.getInstance().callView("SelezionaParametro", request); 
            	break;
            
    		case "VParametro":
    			String id = request.get("idParametro").toString();
    			//int id=	(Integer) request.get("idParametro");
    			System.out.println(id);
    			request.put("valoriParametro", this.VparametroService.getParametroID(id));
    			MainDispatcher.getInstance().callView("VDettaglioParametro", request);
    			
    			break;
    		
    		
    	}
            	
        }
        
      else {
    	  MainDispatcher.getInstance().callView("Home", null);
      }
      
    }
}