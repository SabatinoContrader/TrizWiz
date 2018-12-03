package main.controller;

import main.MainDispatcher;

public class PrincipiMenuController implements Controller {

	    public void doControl(Request request) {
	            MainDispatcher.getInstance().callView("PrincipiMenu", request);
	    }
	}
