package main.controller;

import main.MainDispatcher;
import main.model.User;
import main.service.UserService;

public class UserController implements Controller {

	private UserService userService;
	private String message;
	
    @Override
    public void doControl(Request request)  {
    	this.userService = new UserService();
    	this.message = "";
    	String choice = request.get("choice").toString();
        if (choice != null) {
        	switch (choice) {
            case "usersManagement":
            	request.put("visualizzaUtenti", this.userService.getAllUsers());
            	MainDispatcher.getInstance().callView("UserHome", request);
            	break;
            case "insert":
                MainDispatcher.getInstance().callView("InsertUser", request);
                break;
            case "update":
            	MainDispatcher.getInstance().callView("UpdateUser", request);
                break;
            case "delete":
                MainDispatcher.getInstance().callView("DeleteUser", request);
                break;
            case "insertUser":
            	if (this.userService.insertUser((User)request.get("newUser"))) {
            		this.message = "Inserimento utente avvenuto correttamente";
            	}
            	else {
            		this.message = "Errore durante la procedura di inserimento utente";
            	}
            	request.put("message", this.message);
            	request.put("visualizzaUtenti", this.userService.getAllUsers());
        		MainDispatcher.getInstance().callView("UserHome", request);
            	break;
            case "deleteUser":
            	if (this.userService.deleteUser((int)request.get("delUser"))) {
            		this.message = "Cancellazione utente avvenuta correttamente";
            	}
            	else {
            		this.message = "Errore durante la procedura di cancellazione utente";
            	}
            	request.put("message", this.message);
            	request.put("visualizzaUtenti", this.userService.getAllUsers());
        		MainDispatcher.getInstance().callView("UserHome", request);
            	break;
            case "updateUser":
            	if (this.userService.updateUser(request)) {
            		this.message = "Aggiornamento utente avvenuto correttamente";
            	}
            	else {
            		this.message = "Errore durante la procedura di aggiornamento utente";
            	}
            	request.put("message", this.message);
            	request.put("visualizzaUtenti", this.userService.getAllUsers());
        		MainDispatcher.getInstance().callView("UserHome", request);
            	break;
            }
        }
        else {
        	MainDispatcher.getInstance().callView("UserHome", null);
        }
    }
}
