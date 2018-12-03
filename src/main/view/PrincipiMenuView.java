package main.view;

import main.MainDispatcher;
import main.controller.Request;
//import sun.applet.Main;

import java.util.Scanner;

public class PrincipiMenuView implements View {

    private int choice;
    private Request request;
    
    public void showResults(Request request) {
    	
    }


    public void showOptions() {
    		
    	System.out.println("");
        System.out.println("");
        System.out.println("-------MENU Principi-------");
        System.out.println("");
        System.out.println("1) Visualizza principi");
        System.out.println("2) Inserisci principio");
        System.out.println("3) Cancella principio");
        System.out.println("4) Aggiorna principio");
        System.out.println("5) Indietro");
        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
    	this.request = new Request();
        if (choice < 1 || choice > 5) {
        	MainDispatcher.getInstance().callAction("Reindirizza", "doControl", null);
        }
        else if (choice == 1) {
        	this.request.put("choice", "Vprincipi");
            MainDispatcher.getInstance().callAction("Principi", "doControl", this.request);
        }
        else if (choice == 2) {
        	this.request.put("choice", "InsPrincipi");
        	MainDispatcher.getInstance().callAction("InsPrincipi", "doControl", this.request);
        }
        else if (choice == 3) {
        	this.request.put("choice", "CanPrincipi");
        	MainDispatcher.getInstance().callAction("CanPrincipi", "doControl", this.request);
        }
        else if (choice == 4) {
        	this.request.put("choice", "AggPrincipi");
        	MainDispatcher.getInstance().callAction("AggPrincipi", "doControl", this.request);
        }
        else if (choice == 5) {
        	MainDispatcher.getInstance().callAction("Reindirizza", "doControl", null);
        }
      
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
