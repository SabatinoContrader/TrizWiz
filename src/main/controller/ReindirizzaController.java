package main.controller;

import main.MainDispatcher;
//import main.model.User;

public class ReindirizzaController implements Controller {

	    public void doControl(Request request) {
	            MainDispatcher.getInstance().callView("Home", request);
	    }
	}
