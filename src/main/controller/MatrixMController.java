package main.controller;
import main.MainDispatcher;
//import main.model.User;

public class MatrixMController implements Controller{


	    public void doControl(Request request) {
	            MainDispatcher.getInstance().callView("MatrixM", request);
	    }
	}

