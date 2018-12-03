package main.view;

import main.MainDispatcher;
import main.controller.Request;
//import sun.applet.Main;

import java.util.Scanner;

public class ParametriMenuView implements View {

    private int choice;
    private Request request;
    
    public void showResults(Request request) {
    	
    }


    public void showOptions() {
    		
    	System.out.println("");
        System.out.println("");
        System.out.println("-------MENU Parametri-------");
        System.out.println("");
        System.out.println("1) Visualizza parametri");
        System.out.println("2) Inserisci parametri");
        System.out.println("3) Cancella parametri");
        System.out.println("4) Aggiorna parametri");
        System.out.println("5) Indietro");
        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
    	this.request = new Request();
        if (choice < 1 || choice > 5) {
        	MainDispatcher.getInstance().callAction("Reindirizza", "doControl", null);
        }
        else if (choice == 1) {
        	this.request.put("choice", "Vparametri");
            MainDispatcher.getInstance().callAction("Parametri", "doControl", this.request);
        }
        else if (choice == 2) {
        	this.request.put("choice", "InsParametri");
        	MainDispatcher.getInstance().callAction("InsParametri", "doControl", this.request);
        }
        else if (choice == 3) {
        	this.request.put("choice", "CanParametri");
        	MainDispatcher.getInstance().callAction("CanParametri", "doControl", this.request);
        }
        else if (choice == 4) {
        	this.request.put("choice", "AggParametri");
        	MainDispatcher.getInstance().callAction("AggParametri", "doControl", this.request);
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
