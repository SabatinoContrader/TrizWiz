package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Assegnazione;
import main.model.Asset;
import main.model.User;
import main.dao.UserDAO;
import main.service.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AssegnazioneBadgeUserView implements View{

    private Request request;
     
    public AssegnazioneBadgeUserView () {

    }

    @Override
    public void showResults(Request request) {
       this.request = request;
    }

    @Override
    public void showOptions() {    	
    	System.out.println("Inserisci dati dell'user da assegnare e del badge:");
    	System.out.println("Id Utente:");
    	int iduser = Integer.parseInt(getInput());
    	System.out.println("Id Badge:");
    	int idbadge= Integer.parseInt(getInput());
    	String data= LocalDate.now().toString();
    	this.request = new Request();
    	this.request.put("newAssegnazione",new Assegnazione(iduser,idbadge,data));
    	this.request.put("choice", "assegnaBadge");
    }
    

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
  }

    @Override
    public void submit() {
    	MainDispatcher.getInstance().callAction("Assegnazione", "doControl", this.request);
    }

}

