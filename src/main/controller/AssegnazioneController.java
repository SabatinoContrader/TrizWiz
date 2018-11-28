package main.controller;

import main.MainDispatcher;
import main.model.Assegnazione;
import main.model.User;
import main.service.AssegnazioneService;
import main.service.BadgeService;
import main.service.UserService;

public class AssegnazioneController implements Controller {

	private AssegnazioneService assegnazioneService;
	private UserService userService;
	private BadgeService badgeService;
	private String message;
	
    @Override
    public void doControl(Request request)  {
    	this.assegnazioneService = new AssegnazioneService();
    	this.userService = new UserService();
    	this.badgeService = new BadgeService();
    	this.message = "";
    	String choice = request.get("choice").toString();
        if (choice != null) {
        	switch (choice) {
           case "assegnazioneManagement":
            	request.put("visualizzaAssegnazioni", this.assegnazioneService.getAllAssegnazioni());
            	request.put("visualizzaUtenti", this.userService.getAllUsers());
            	request.put("visualizzaBadges", this.badgeService.getAllBadges());
            	MainDispatcher.getInstance().callView("AssegnazioneHome", request);
            	break;
//            case "insert":
//                MainDispatcher.getInstance().callView("InsertUser", request);
//                break;
//            case "update":
//            	MainDispatcher.getInstance().callView("UpdateUser", request);
//                break;
            case "delete":
                MainDispatcher.getInstance().callView("DeleteAssegnazione", request);
                break;
//            case "insertUser":
//            	if (this.userService.insertUser((User)request.get("newUser"))) {
//            		this.message = "Inserimento utente avvenuto correttamente";
//            	}
            case "assegna":
            	MainDispatcher.getInstance().callView("AssegnazioneBadgeUser", request);
            	break;
//            	request.put("message", this.message);
//            	request.put("visualizzaUtenti", this.userService.getAllUsers());
//        		MainDispatcher.getInstance().callView("UserHome", request);
//            	break;
            case "assegnaBadge":
            	if (this.assegnazioneService.assegnaBadge((Assegnazione)request.get("newAssegnazione"))) 
            	{
            		this.message="ok";
            	}
            	else {
            		this.message = "Errore durante la procedura di assegnazione";
            	}
            	request.put("message",this.message);
            	request.put("visualizzaAssegnazioni", this.assegnazioneService.getAllAssegnazioni());
            	request.put("visualizzaUtenti", this.userService.getAllUsers());
            	request.put("visualizzaBadges", this.badgeService.getAllBadges());
            	MainDispatcher.getInstance().callView("AssegnazioneHome", request);
            	break;
            	
            case "deleteAssegnazione":
            	if (this.assegnazioneService.deleteAssegnazione((int)request.get("delASSidu"),(int)request.get("delASSidb"))) 
            			{
            		this.message = "Cancellazione badge avvenuta correttamente";
            	}
            	else {
            		this.message = "Errore durante la procedura di cancellazione utente";
            	}
            	request.put("message", this.message);
            	request.put("visualizzaAssegnazioni", this.assegnazioneService.getAllAssegnazioni());
            	request.put("visualizzaUtenti", this.userService.getAllUsers());
            	request.put("visualizzaBadges", this.badgeService.getAllBadges());
            	MainDispatcher.getInstance().callView("AssegnazioneHome", request);
            	break;
//            case "updateUser":
//            	if (this.userService.updateUser(request)) {
//            		this.message = "Aggiornamento utente avvenuto correttamente";
//            	}
//            	else {
//            		this.message = "Errore durante la procedura di aggiornamento utente";
//            	}
//            	request.put("message", this.message);
//            	request.put("visualizzaUtenti", this.userService.getAllUsers());
//        		MainDispatcher.getInstance().callView("UserHome", request);
//            	break;
//            }
//        }
//        else {
//        	MainDispatcher.getInstance().callView("UserHome", null);
//        }
        	}}}}

