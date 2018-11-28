package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Badge;
import main.model.Movimento;
import main.model.User;

import java.util.List;
import java.util.Scanner;

public class MovimentoHomeView implements View{

	private int choice;
    private Request request;
    private List<Badge> listBadge;
	private List<Movimento> listMovimento;
    
    public void showResults(Request request) {
    	this.request = request;
    	if (this.request.get("message") != null) {
    		System.out.println(this.request.get("message"));
    	}	
        this.listMovimento = (List<Movimento>) this.request.get("visualizzaMovimenti");
    	System.out.println();
    	System.out.println();
        System.out.println("Movimenti Management Base");
    	System.out.println();
    	System.out.println("Gestione Movimenti");
    	System.out.println("");
        System.out.println("----- LISTA MOVIMENTI -----");
        System.out.println();
        //this.listUser.forEach(user -> System.out.println(user));
        System.out.format("+--------------- +----------------+----------------------------+---------------------------+%n");
		System.out.format("| IDbadgereader  | Idbadge        | Datainizio                 | Datafine                  |%n");
		System.out.format("+----------------+----------------+----------------------------+---------------------------+%n");
		String leftAlignFormat2 ="| %-14s | %-15s| %-27s| %-26s|%n";
		for (Movimento report : this.listMovimento) {
			int idBadgereader = report.getIdbadgereader();
			int idBadge = report.getIdbadge();
			String datainizio = report.getDatainizio();
			String datafine = report.getDatafine();
            try{
            	System.out.format(leftAlignFormat2,idBadgereader, idBadge ,datainizio,datafine);
            }catch (Exception e) {
				// TODO: handle exception
			}
            System.out.format("+----------------+----------------+----------------------------+---------------------------+%n");

		}
        System.out.println();
    }
    
    public void showOptions() {
    	System.out.println("-------MENU-------");
        System.out.println("");
        System.out.println("1) Inserimento Movimento");
        System.out.println("2) Modifica Movimento");
        System.out.println("3) Cancellazione Movimento");
        System.out.println("4) Indietro");
        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
        if (choice < 1 || choice > 4) {
        	this.request = new Request();
        	this.request.put("choice", "movimentiManagement");
            MainDispatcher.getInstance().callAction("Movimento", "doControl", this.request);
        }
        else if (choice == 4) {
          	this.request.put("choice", "logs");
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
        	MainDispatcher.getInstance().callAction("Movimento", "doControl", request);        		
        }
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
