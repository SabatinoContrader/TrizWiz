package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Asset;
//import sun.applet.Main;
import main.model.BadgeReader;

import java.util.List;
import java.util.Scanner;

public class MovimentiExportHomeView implements View {

    
    private int choice;
    private Request request;
    private List<Asset> listAsset;
    private List<BadgeReader> listBadgeReader;
    
    public void showResults(Request request) {
    	this.request = request;
    	if (this.request.get("message") != null) {
    		System.out.println(this.request.get("message"));
    	}	
    }

    public void showOptions() {
    	System.out.println("");
        System.out.println("-------MENU-------");
        System.out.println("");
        System.out.println("1) Logs");
        System.out.println("2) Export");
        System.out.println("3) Indietro");
        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
        if (choice < 1 || choice > 3) {
        	this.request = new Request();
        	this.request.put("choice", "logs");
            MainDispatcher.getInstance().callAction("Menu", "doControl", this.request);
        }
        else if (choice == 3) {
            MainDispatcher.getInstance().callAction("Home", "doControl", null);
        }
        else {
        	Request request = new Request();
        	if (this.choice == 1) {
        		request.put("choice", "movimentiManagement");
        		MainDispatcher.getInstance().callAction("Movimento", "doControl", request); 
        	}
        	else if (this.choice == 2) {
            	request.put("choice", "export");
               	System.out.println("Inserire percorso dove si vuole esportare");
               	String path= getInput();
               	System.out.println("Inserire nome file di output");
               	String nome= getInput();
               	request.put("path", path);
               	request.put("nome", nome);
               	System.out.println("Se si vuole esportare i movimenti relativi ad un utente specifico inserire l'id, altrimenti premere invio");
               	String iduser = "";
               	iduser = getInput();
               	if (iduser != ""){
               		request.put("iduser", iduser);
               	}
           		MainDispatcher.getInstance().callAction("Movimento", "doControl", request); 
           	}
        }	       		
    }
    

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
