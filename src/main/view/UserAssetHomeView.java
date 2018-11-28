package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.User;
//import sun.applet.Main;
import main.model.UserAsset;

import java.util.List;
import java.util.Scanner;

public class UserAssetHomeView implements View {

    private int choice;
    private Request request;
    private List<UserAsset> listUserAsset;
    private List<User> users;
    
    public void showResults(Request request) {
    	this.request = request;
    	if (this.request.get("message") != null) {
    		System.out.println(this.request.get("message"));
    	}	
        this.listUserAsset = (List<UserAsset>) this.request.get("visualizzaUtentiAssets");
        this.users = (List<User>) this.request.get("visualizzaClienti");

        System.out.println();
    	System.out.println();
        System.out.println("Asset Management Base");
    	System.out.println();
    	System.out.println("Gestione User Asset");
    	System.out.println("");
    	System.out.println("----- Asset assegnati -----");
        System.out.println();
        System.out.format("+--------+---------+------------------------+-------------------------------+%n");
		System.out.format("| IDuser | IDasset | ORAinizio              | ORAfine                       |%n");
		System.out.format("+--------+---------+------------------------+-------------------------------+%n");
		String leftAlignFormat ="| %-6s | %-7s | %-22s | %-29s |%n";
        //this.listUserAsset.forEach(userasset -> System.out.println(userasset));
		for (UserAsset report : this.listUserAsset) {
			int id = report.getIduser();
            int idA = report.getIdasset();
			String oraI = report.getOrainizio();
			String oraF = report.getOrafine();
            
            try{
            	System.out.format(leftAlignFormat, id ,idA,oraI,oraF);
            }catch (Exception e) {
				// TODO: handle exception
			}
    		System.out.format("+--------+---------+------------------------+-------------------------------+%n");

		}
        System.out.println();
        System.out.println("I clienti con un asset prenotato sono:");
        System.out.println();
        //this.users.forEach(user -> System.out.println(user.stampa()));
        System.out.format("+----------+-----------------------+------------+------------+--------------+%n");
		System.out.format("| IDutente | UserName              | Nome       | Cognome    | partitaIva   |%n");
        System.out.format("+----------+-----------------------+------------+------------+--------------+%n");
		String leftAlignFormat2 ="| %-8s | %-21s | %-10s | %-10s | %-12s |%n";
		for (User report : this.users) {
			int id = report.getIdutente();
            String usN = report.getUsername();
			//String passW = report.getPassword();
			String nome = report.getNome();
			String cogn = report.getCognome();
			//String tel = report.getTelefono();
			//String email = report.getMail();
			String piva = report.getPartitaiva();
			//String ruolo = report.getRuolo();
			//System.out.println(ruolo);
            
            try{
            	System.out.format(leftAlignFormat2, id ,usN,nome,cogn,piva);
            }catch (Exception e) {
				// TODO: handle exception
			}
            System.out.format("+----------+-----------------------+------------+------------+--------------+%n");

		}
    }

    public void showOptions() {
    	System.out.println("-------MENU-------");
        System.out.println("");
        System.out.println("1) Associazione Asset Utente");
        System.out.println("2) Esportazione Asset Assegnati");
        System.out.println("3) Disassociazione Asset Utente");
        System.out.println("4) Indietro");
        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
        if (choice < 1 || choice > 4) {
        	this.request = new Request();
        	this.request.put("choice", "usersAssetsManagement");
            MainDispatcher.getInstance().callAction("UserAsset", "doControl", this.request);
        }
        else if (choice == 4) {
            MainDispatcher.getInstance().callAction("Home", "doControl", null);
        }
        else {
        	Request request = new Request();
        	if (this.choice == 1) {
        		request.put("choice", "insert");
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
        	}
        	else if (this.choice == 3) {
        		request.put("choice",  "delete");
        	}
        	MainDispatcher.getInstance().callAction("UserAsset", "doControl", request);   
        }
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
