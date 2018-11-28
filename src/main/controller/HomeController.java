package main.controller;

import main.MainDispatcher;
import main.model.User;
import main.service.LoginService;
import main.service.UserService;

public class HomeController implements Controller {

    private LoginService loginService;
    private UserService userService;

    public HomeController() {
        loginService = new LoginService();
    }

    public void doControl(Request request) {
        if (request != null) {
            String nomeUtente = request.get("nomeUtente").toString();
            String password = request.get("password").toString();
 
            if (loginService.login(nomeUtente, password,"segretaria")) {
                MainDispatcher.getInstance().callView("Home", request);
            }
            else {
            	request=new Request();
            	request.put("controlloAccesso", "ERROR");
                MainDispatcher.getInstance().callAction("Login", "doControl", request);
            }
        }
        else {
        	MainDispatcher.getInstance().callView("Home", null);
        }

    }
}
