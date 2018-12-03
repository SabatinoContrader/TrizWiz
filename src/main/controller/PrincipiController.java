package main.controller;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import main.MainDispatcher;

import main.service.VprincipioService;

public class PrincipiController implements Controller {
	
	private VprincipioService vPrincipioService;
	private String message;
    
	

    public void doControl(Request request)  {
    	this.vPrincipioService= new VprincipioService();
    	this.message= "";
    	String choice = request.get("choice").toString();
        if (choice != null ) {
        	switch (choice) {//se problemi da verificare
            
        		case "Vprincipi":
        		
        			request.put("visualizzaPrincipi",this.vPrincipioService.getAllPrincipio());
        			MainDispatcher.getInstance().callView("Principio", request); 
        			break;
            	
        		case "SelPrincipio":
        			request.put("visualizzaPrincipio",this.vPrincipioService.getAllPrincipio());
                	MainDispatcher.getInstance().callView("SelezionaPrincipio", request); 
                	break;
                
        		case "VPrincipio":
        			String id = request.get("idPrincipio").toString();
        			//int id=	(Integer) request.get("idParametro");
        			System.out.println(id);
        			request.put("valoriPrincipio", this.vPrincipioService.getPrincipioID(id));
        			MainDispatcher.getInstance().callView("VDettaglioPrincipio", request);
        			
        			break;
        		
        		
        	}
        	
        	
        			
        }
        
        else {
      	  MainDispatcher.getInstance().callView("Home", null);
        }
      
    }
}