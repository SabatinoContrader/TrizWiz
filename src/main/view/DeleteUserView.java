package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Asset;
import main.model.User;
import main.dao.UserDAO;
import main.service.UserService;

import java.util.List;
import java.util.Scanner;

public class DeleteUserView implements View{

    private Request request;
     
    public DeleteUserView () {

    }

    @Override
    public void showResults(Request request) {
       this.request = request;
    }

    @Override
    public void showOptions() {    	
    	System.out.println("Inserisci l'id dell'utente da eliminare:");
        System.out.println("IdUser:");
        int idUser = Integer.parseInt(getInput());
        this.request = new Request();
        this.request.put("delUser",idUser);
    	this.request.put("choice", "deleteUser");
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
  }

    @Override
    public void submit() {
    	MainDispatcher.getInstance().callAction("User", "doControl", this.request);
    }

}
