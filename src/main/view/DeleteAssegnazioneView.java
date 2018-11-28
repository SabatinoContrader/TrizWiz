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

public class DeleteAssegnazioneView implements View{

    private Request request;
     
    public DeleteAssegnazioneView () {

    }

    @Override
    public void showResults(Request request) {
       this.request = request;
    }

    @Override
    public void showOptions() {    	
    	System.out.println("Inserisci dati per la rimozione del badge dall'organizzazione:");
    	System.out.println("Id Utente organizzazione:");
    	int iduser = Integer.parseInt(getInput());
    	System.out.println("Id Badge:");
    	int idbadge= Integer.parseInt(getInput());
    	this.request = new Request();
    	this.request.put("delASSidu",iduser);
    	this.request.put("delASSidb",idbadge);
    	this.request.put("choice", "deleteAssegnazione");
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

