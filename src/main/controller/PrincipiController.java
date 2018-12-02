package main.controller;

import main.MainDispatcher;
import main.service.VprincipioService;

public class PrincipiController implements Controller {
	
	private VprincipioService VprincipioService;
    

    public void doControl(Request request)  {
    	this.VprincipioService= new VprincipioService();
   
    	String choice = request.get("choice").toString();
        if (choice != null) {
            	//List Principi=(List) VprincipioService.getAllPrincipio();
            	request.put("visualizzaPrincipi",this.VprincipioService.getAllPrincipio());
            	MainDispatcher.getInstance().callView("Principio", request);   
        }
    }
}
