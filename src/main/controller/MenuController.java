package main.controller;

import main.MainDispatcher;
import main.model.User;
import main.service.UserService;

public class MenuController implements Controller {

	
	
    @Override
    public void doControl(Request request)  {
    	String choice = request.get("choice").toString();
        if (choice != null) {
        	switch (choice) {
            case "myAssets":
            	MainDispatcher.getInstance().callView("AssetBadgeReaderHome", request);
            	break;
            case "customers":
            	MainDispatcher.getInstance().callView("UserBadgeHome", request);
            	break;
            case "logs":
            	MainDispatcher.getInstance().callView("MovimentiExportHome", request);
            	break;
            }
        }
        else {
        	MainDispatcher.getInstance().callView("UserHome", null);
        }
    }
}
