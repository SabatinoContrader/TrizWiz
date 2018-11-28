package main.view;

import main.MainDispatcher;
import main.controller.Request;
//import sun.applet.Main;
import main.model.User;

import java.util.List;
import java.util.Scanner;

public class UserHomeView implements View {

    private int choice;
    private Request request;
    private List<User> listUser;
    
    public void showResults(Request request) {
    	this.request = request;
    	if (this.request.get("message") != null) {
    		System.out.println(this.request.get("message"));
    	}	
        this.listUser = (List<User>) this.request.get("visualizzaUtenti");
    	System.out.println();
    	System.out.println();
        System.out.println("Asset Management Base");
    	System.out.println();
    	System.out.println("Gestione User");
    	System.out.println("");
        System.out.println("----- LISTA UTENTI -----");
        System.out.println();
        //this.listUser.forEach(user -> System.out.println(user));
        System.out.format("+----------+-------------------------+--------------+--------------+--------------+--------------+---------------------------------+----------------------+------------------+%n");
        System.out.format("| IDutente | 1)UserName              | 2)Password   | 3)Nome       | 4)Cognome    | 5)Telefono   | 6)E-mail                        | 7)Partita Iva        | 8)Ruolo          |%n");
        System.out.format("+----------+-------------------------+--------------+--------------+--------------+--------------+---------------------------------+----------------------+------------------+%n");
		String leftAlignFormat2 ="| %-8s | %-23s | %-12s | %-12s | %-12s | %-12s | %-31s | %-20s | %-16s |%n";
		for (User report : this.listUser) {
			int id = report.getIdutente();
            String usN = report.getUsername();
			String passW = report.getPassword();
			String nome = report.getNome();
			String cogn = report.getCognome();
			String tel = report.getTelefono();
			String email = report.getMail();
			String piva = report.getPartitaiva();
			String ruolo = report.getRuolo();
            
            try{
            	System.out.format(leftAlignFormat2, id ,usN,passW,nome,cogn,tel,email,piva,ruolo);
            }catch (Exception e) {
				// TODO: handle exception
			}
            System.out.format("+----------+-------------------------+--------------+--------------+--------------+--------------+---------------------------------+----------------------+------------------+%n");

		}
        System.out.println();
    }

    public void showOptions() {
    	System.out.println("-------MENU-------");
        System.out.println("");
        System.out.println("1) Inserimento Utente");
        System.out.println("2) Modifica Utente");
        System.out.println("3) Cancellazione Utente");
        System.out.println("4) Indietro");
        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
        if (choice < 1 || choice > 4) {
        	this.request = new Request();
        	this.request.put("choice", "usersManagement");
            MainDispatcher.getInstance().callAction("User", "doControl", this.request);
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
        	MainDispatcher.getInstance().callAction("User", "doControl", request);        		
        }
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
