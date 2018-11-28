package main.controller;
import main.MainDispatcher;
import main.model.Badge;
import main.service.BadgeService;


public class BadgeController implements Controller{
	private BadgeService badgeService;
	private String message;


@Override
public void doControl(Request request)  {
	this.badgeService = new BadgeService();
	this.message = "";
	String choice = request.get("choice").toString();
    if (choice != null) {
    	switch (choice) {
        case "badgesManagement":
        	request.put("visualizzaBadges", this.badgeService.getAllBadges());
        	MainDispatcher.getInstance().callView("BadgeHome", request);
        	break;
        case "insert":
            MainDispatcher.getInstance().callView("InsertBadge", request);
            break;
        case "update":
        	MainDispatcher.getInstance().callView("UpdateBadge", request);
            break;
        case "delete":
            MainDispatcher.getInstance().callView("DeleteBadge", request);
            break;
        case "insertBadge":
        	if (this.badgeService.insertBadge((Badge)request.get("newBadge"))) {
        		this.message = "Inserimento badge avvenuto correttamente";
        	}
        	else {
        		this.message = "Errore durante la procedura di inserimento badge";
        	}
        	request.put("message", this.message);
        	request.put("visualizzaBadges", this.badgeService.getAllBadges());
        	MainDispatcher.getInstance().callView("BadgeHome", request);
        	break;
        case "deleteBadge":
        	if (this.badgeService.deleteBadge((Integer) request.get("delBadge"))) {
        		this.message = "Cancellazione badge avvenuto correttamente";
        	}
        	else {
        		this.message = "Errore durante la procedura di cancellazione badge";
        	}
        	request.put("message", this.message);
        	request.put("visualizzaBadges", this.badgeService.getAllBadges());
        	MainDispatcher.getInstance().callView("BadgeHome", request);
        	break;
        case "updateBadge":
        	if (this.badgeService.updateBadge(request)) {
        		this.message = "Aggiornamento badge avvenuto correttamente";
        	}
        	else {
        		this.message = "Errore durante la procedura di aggiornamento badge";
        	}
        	request.put("message", this.message);
        	request.put("visualizzaBadges", this.badgeService.getAllBadges());
    		MainDispatcher.getInstance().callView("BadgeHome", request);
        	break;
        }
    }
    else {
    	MainDispatcher.getInstance().callView("BadgeHome", null);
    }
}
}
