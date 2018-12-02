package main.controller;

import main.MainDispatcher;
import main.service.MatrixService;

public class MatrixController implements Controller {

    private MatrixService MatrixService;

    public MatrixController() {
        MatrixService = new MatrixService();
    }

    public void doControl(Request request) {
        if (request != null) {
            String param1 = request.get("param1").toString();
            String param2 = request.get("param2").toString();
        	this.MatrixService= new MatrixService();
            	request.put("visualizzaMatrix",this.MatrixService.getAllMatrix(param1, param2));
            	MainDispatcher.getInstance().callView("Matrix", request);
        }
        else { MainDispatcher.getInstance().callView("Matrix", null);
        }
    }
}
