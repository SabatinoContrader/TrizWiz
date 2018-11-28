package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Badge;
import main.model.User;

import java.util.List;
import java.util.Scanner;

public class BadgeHomeView implements View{

	private int choice;
    private Request request;
    private List<Badge> listBadge;
    
    public void showResults(Request request) {
    	this.request = request;
    	if (this.request.get("message") != null) {
    		System.out.println(this.request.get("message"));
    	}	
        this.listBadge = (List<Badge>) this.request.get("visualizzaBadges");
    	System.out.println();
    	System.out.println();
        System.out.println("Badge Management Base");
    	System.out.println();
    	System.out.println("Gestione Badge");
    	System.out.println("");
        System.out.println("----- LISTA BADGE -----");
        System.out.println();
        //this.listUser.forEach(user -> System.out.println(user));
        System.out.format("+----------+--------------------------+------------------+%n");
		System.out.format("| IDbadge  | 1) Descrizione           | 2) Tipologia     |%n");
        System.out.format("+----------+--------------------------+------------------+%n");
		String leftAlignFormat2 ="| %-8s | %-24s | %-16s |%n";
		for (Badge report : this.listBadge) {
			int idBadge = report.getIdBadge();
			String tipologia = report.getTipologia();
			String descrizione = report.getDescrizione();
            
            try{
            	System.out.format(leftAlignFormat2, idBadge ,tipologia,descrizione);
            }catch (Exception e) {
				// TODO: handle exception
			}
            System.out.format("+----------+--------------------------+------------------+%n");

		}
        System.out.println();
    }
    
    public void showOptions() {
    	System.out.println("-------MENU-------");
        System.out.println("");
        System.out.println("1) Inserimento Badge");
        System.out.println("2) Modifica Badge");
        System.out.println("3) Cancellazione Badge");
        System.out.println("4) Indietro");
        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
        if (choice < 1 || choice > 4) {
        	this.request = new Request();
        	this.request.put("choice", "badgesManagement");
            MainDispatcher.getInstance().callAction("Badge", "doControl", this.request);
        }
        else if (choice == 4) {
        	this.request.put("choice", "customers");
            MainDispatcher.getInstance().callAction("Menu", "doControl", this.request);
        }
        else {
        	Request request = new Request();
        	if (this.choice == 1) {
        		request.put("choice", "insert");
        	}
        	else if (this.choice == 2) {
        		request.put("choice", "update");
        	}
        	else if (this.choice == 3) {
        		request.put("choice", "delete");
        	}
        	MainDispatcher.getInstance().callAction("Badge", "doControl", request);        		
        }
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
