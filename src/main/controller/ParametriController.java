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
            
            	request.put("visualizzaParametri",this.VparametroService.getAllParametro());
            	MainDispatcher.getInstance().callView("Parametro", request);   
        }
        
       // else 
      // MainDispatcher.getInstance().callView("Home", null);
    }
}