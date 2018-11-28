package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Asset;
//import sun.applet.Main;
import main.model.BadgeReader;

import java.util.List;
import java.util.Scanner;

public class UserBadgeHomeView implements View {

    
    private int choice;
    private Request request;
    private List<Asset> listAsset;
    private List<BadgeReader> listBadgeReader;
    
    public void showResults(Request request) {
    	this.request = request;
    	

    }

    public void showOptions() {
    	System.out.println("");
        System.out.println("-------MENU-------");
        System.out.println("");
        System.out.println("1) Users");
        System.out.println("2) Badges");
        System.out.println("3) Indietro");
        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
        if (choice < 1 || choice > 3) {
        	this.request = new Request();
        	this.request.put("choice", "myAssets");
            MainDispatcher.getInstance().callAction("Menu", "doControl", this.request);
        }
        else if (choice == 3) {
        	
            MainDispatcher.getInstance().callAction("Home", "doControl", null);
        }
        else {
        	Request request = new Request();
        	if (this.choice == 1) {
        		request.put("choice", "usersManagement");
        		MainDispatcher.getInstance().callAction("User", "doControl", request); 
        	}
        	else if (this.choice == 2) {
        		request.put("choice", "badgesManagement");
        		MainDispatcher.getInstance().callAction("Badge", "doControl", request); 
        	}
        	       		
        }
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
