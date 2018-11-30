package main.view;

import main.MainDispatcher;
import main.controller.Request;
//import sun.applet.Main;

import java.util.Scanner;

public class HomeView implements View {

    private int choice;
    private Request request;
    private String username;
    
    public void showResults(Request request) {
    	this.request = request;
    	if(request != null) {
    		this.username=request.get("nomeUtente").toString();
    	}
    }


    public void showOptions() {
    	if(this.request != null) {
    		if(this.username != null) {
    			System.out.println("Benvenuto/a " + username);
    		}
    	}	
    	System.out.println("");
        System.out.println("");
        System.out.println("-------MENU-------");
        System.out.println("");
        System.out.println("1) Visualizza i parametri");
        System.out.println("2) Visualizza i principi");
        System.out.println("3) Consulta Contraddiction Matrix");
        System.out.println("4) Inserisci esperienza parametro");
        System.out.println("5) Inserisci esperienza principio");
        System.out.println("6) Esci");
        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
    	this.request = new Request();
        if (choice < 1 || choice > 6) {
        	MainDispatcher.getInstance().callAction("Reindirizza", "doControl", null);
        }
        else if (choice == 1) {
        	this.request.put("choice", "Vparametri");
            MainDispatcher.getInstance().callAction("Menu", "doControl", this.request);
        }
        else if (choice == 2) {
        	this.request.put("choice", "Vprincipi");
        	MainDispatcher.getInstance().callAction("Menu", "doControl", this.request);
        }
        else if (choice == 3) {
        	this.request.put("choice", "matrix");
        	MainDispatcher.getInstance().callAction("Menu", "doControl", this.request);
        }
        else if (choice == 4) {
        	this.request.put("choice", "expe");
        	MainDispatcher.getInstance().callAction("Menu", "doControl", this.request);
        }
        else if (choice == 5) {
        	this.request.put("choice", "expr");
        	MainDispatcher.getInstance().callAction("Menu", "doControl", this.request);
        }
      
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
