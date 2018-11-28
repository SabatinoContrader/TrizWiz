package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Assegnazione;
import main.model.Badge;
//import sun.applet.Main;
import main.model.User;

import java.util.List;
import java.util.Scanner;

public class AssegnazioneHomeView implements View {

    private int choice;
    private Request request;
    private List<Assegnazione> listAssegnazioni;
    private List<User> listUser;
    private List<Badge> listBadge;
    
    public void showResults(Request request) {
    	this.request = request;
    	if (this.request.get("message") != null) {
    		System.out.println(this.request.get("message"));
    	}
    	
    	this.listUser = (List<User>) this.request.get("visualizzaUtenti");
    	System.out.println();
    	System.out.println();
        System.out.println("----- LISTA UTENTI -----");
        System.out.println();
        //this.listUser.forEach(user -> System.out.println(user));
        System.out.format("+----------+-----------------------+------------+------------+------------+------------+-------------------------------+--------------------+----------------+%n");
        System.out.format("| IDutente | UserName              | Password   | Nome       | Cognome    | Telefono   | E-mail                        | Partita Iva        | Ruolo          |%n");
        System.out.format("+----------+-----------------------+------------+------------+------------+------------+-------------------------------+--------------------+----------------+%n");
		String leftAlignFormat2 ="| %-8s | %-21s | %-10s | %-10s | %-10s | %-10s | %-29s | %-18s | %-14s |%n";
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
            System.out.format("+----------+-----------------------+------------+------------+------------+------------+-------------------------------+--------------------+----------------+%n");

		}
		System.out.println();
		
		 this.listBadge = (List<Badge>) this.request.get("visualizzaBadges");
	    	System.out.println();
	    	System.out.println();
	        System.out.println("----- LISTA BADGE -----");
	        System.out.println();
	        //this.listUser.forEach(user -> System.out.println(user));
	        System.out.format("+----------+-----------------------+------------------+%n");
			System.out.format("| IDbadge  | Descrizione           | Tipologia        |%n");
	        System.out.format("+----------+-----------------------+------------------+%n");
			String leftAlignFormat4 ="| %-8s | %-21s | %-16s |%n";
			for (Badge report : this.listBadge) {
				int idBadge = report.getIdBadge();
				String tipologia = report.getTipologia();
				String descrizione = report.getDescrizione();
	            
	            try{
	            	System.out.format(leftAlignFormat4, idBadge ,tipologia,descrizione);
	            }catch (Exception e) {
					// TODO: handle exception
				}
	            System.out.format("+----------+-----------------------+------------------+%n");

			}
	        System.out.println();
        
    	
        this.listAssegnazioni = (List<Assegnazione>) this.request.get("visualizzaAssegnazioni");
    	System.out.println();
    	System.out.println();
    	System.out.println("Gestione Assegnazioni");
    	System.out.println("");
        System.out.println("----- LISTA ASSEGNAZIONI -----");
        System.out.println();
        //this.listUser.forEach(user -> System.out.println(user));
        System.out.format("+----------+----------+---------------------+%n");
		System.out.format("| IDutente | ID Badge | Data assegnazione   |%n");
        System.out.format("+----------+----------+---------------------+%n");
		String leftAlignFormat3 ="| %-8s | %-8s | %-19s |%n";
		for (Assegnazione report : this.listAssegnazioni) {
			int iduser = report.getIdUtente();
			int idbadge = report.getIdBadge();
            String data = report.getData();
            
            try{
            	System.out.format(leftAlignFormat3, iduser , idbadge , data);
            }catch (Exception e) {
				// TODO: handle exception
			}
            System.out.format("+----------+----------+---------------------+%n");

		}
        System.out.println();
    }
    

    public void showOptions() {
    	System.out.println("-------MENU-------");
        System.out.println("");
        System.out.println("1) Assegna badge");
        System.out.println("2) Rimuovi badge all'organizzazione");
        System.out.println("3) Indietro");
        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
        if (choice < 1 || choice > 3) {
        	this.request = new Request();
        	this.request.put("choice", "assegnazioneManagement");
            MainDispatcher.getInstance().callAction("Assegnazione", "doControl", this.request);
        }
        else if (choice == 3) {
            MainDispatcher.getInstance().callAction("Home", "doControl", null);
        }
        else {
        	Request request = new Request();
        	if (this.choice == 1) {
        		request.put("choice", "assegna");
        	}
        	else if (this.choice == 2) {
        		request.put("choice", "delete");
        	}
        	MainDispatcher.getInstance().callAction("Assegnazione", "doControl", request);        		
        }
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
