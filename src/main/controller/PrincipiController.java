package main.controller;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import main.MainDispatcher;
import main.service.VprincipioService;

public class PrincipiController implements Controller {
	
	private VprincipioService VprincipioService;
	private String message;
    
	

    public void doControl(Request request)  {
    	this.VprincipioService= new VprincipioService();
    	this.message= "";
    	String choice = request.get("choice").toString();
        if (choice != null) {
            	//List Principi=(List) VprincipioService.getAllPrincipio();
            	request.put("visualizzaPrincipi",this.VprincipioService.getAllPrincipio());
            	MainDispatcher.getInstance().callView("Principio", request);   
        }
    }
}
