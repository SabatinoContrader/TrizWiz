package main.controller;

import main.MainDispatcher;

public class ParametriMenuController implements Controller {

	    public void doControl(Request request) {
	            MainDispatcher.getInstance().callView("ParametriMenu", request);
	    }
	}
