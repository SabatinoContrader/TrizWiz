package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Asset;
import main.model.User;
import main.dao.UserDAO;
import main.service.UserService;

import java.util.List;
import java.util.Scanner;

public class InsertUserView implements View{

    private Request request;
     
    public InsertUserView () {

    }

    @Override
    public void showResults(Request request) {
       this.request = request;
    }

    @Override
    public void showOptions() {    	
    	System.out.println("Inserisci i dati dell'utente:");
    	System.out.println("Username:");
    	String username = getInput();
    	System.out.println("Password:");
    	String password = getInput();
    	System.out.println("Nome:");
    	String nome = getInput();
    	System.out.println("Cognome:");
    	String cognome = getInput();
    	System.out.println("Telefono:");
    	String telefono = getInput();
    	System.out.println("Mail:");
    	String mail = getInput();
    	System.out.println("Partita iva:");
    	String partitaiva = getInput();
    	System.out.println("Ruolo:");
    	String ruolo = getInput();
    	this.request = new Request();
    	this.request.put("newUser",new User(0,username,password,nome,cognome,telefono,mail,partitaiva,ruolo));
    	this.request.put("choice", "insertUser");
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

