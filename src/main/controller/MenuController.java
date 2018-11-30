package main.controller;

import main.MainDispatcher;
import main.model.Parametri;
import main.service.VparametriService;
import main.service.AssegnazioneService;
import main.service.LoginService;
import main.service.UserService;
import main.service.VparametriService;


public class MenuController implements Controller {
	private VparametriService VparametriService;
    public MenuController() {
        VparametriService = new VparametriService();
    }
	
	
    @Override
    public void doControl(Request request)  {
    	String choice = request.get("choice").toString();
        if (choice != null) {
        	switch (choice) {
            case "Vparametri":
            	this.VparametriService = new VparametriService();
            	request.put("visuali", this.VparametriService.getAllParametri());
            	MainDispatcher.getInstance().callView("Visuali", request);
            	//VparametriService.visualizza();
            	
                //MainDispatcher.getInstance().callView("Home", request);
                
                
            	break;
            case "Vprincipi":
            	MainDispatcher.getInstance().callView("UserBadgeHome", request);
            	break;
            case "matrix":
            	MainDispatcher.getInstance().callView("UserBadgeHome", request);
            	break;
            case "expe":
            	MainDispatcher.getInstance().callView("UserBadgeHome", request);
            	break;
            case "expr":
            	MainDispatcher.getInstance().callView("MovimentiExportHome", request);
            	break;
            }
        }
        else {
        	MainDispatcher.getInstance().callView("UserHome", null);
        }
    }
}
