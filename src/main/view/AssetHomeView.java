package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Asset;
//import sun.applet.Main;
import main.model.BadgeReader;

import java.util.List;
import java.util.Scanner;

public class AssetHomeView implements View {

    
    private int choice;
    private Request request;
    private List<Asset> listAsset;
    private List<BadgeReader> listBadgeReader;
    
    public void showResults(Request request) {
    	this.request = request;
    	if (this.request.get("message") != null) {
    		System.out.println(this.request.get("message"));
    	}	        
    	this.listAsset = (List<Asset>) this.request.get("visualizzaAssets");
    	this.listBadgeReader = (List<BadgeReader>) this.request.get("visualizzaBadgeReader");
        System.out.println();
        System.out.println();
        System.out.println("Asset Management Base");
    	System.out.println();
    	System.out.println("Gestione Asset");
    	System.out.println();
    	System.out.println("----- ASSET DISPONIBILI -----");
        System.out.println();
        System.out.format("+------+-----------+-----------------+----------------+--------------------------------------------------------------------------------+%n");
		System.out.format("| ID   | 1) TIPO   | 2) PREZZO       | 3) DESCRIZIONE | 4) ID BADGE READER                                                             |%n");
		System.out.format("+------+-----------+-----------------+----------------+--------------------------------------------------------------------------------+%n");
		
		String leftAlignFormat ="| %-4s | %-9s | %-15s | %-14s | %-78s |%n";
        //this.listAsset.forEach(asset -> System.out.println(asset));
		
        for (Asset report : this.listAsset) {
			int id = report.getId();
            String tipo = report.getTipo();
			double prezzo = report.getPrezzo();
			String description = report.getDescrizione();
            int idBadgeReader = -1;
			
			for(BadgeReader br: this.listBadgeReader) {
				if(br.getIdAsset()==id) {
					idBadgeReader=br.getIdBadgeReader();
				}
				
			}
			
			
			
            try{
            	System.out.format(leftAlignFormat, id ,tipo,prezzo,description, idBadgeReader);
            }catch (Exception e) {
				// TODO: handle exception
			}
            System.out.format("+------+-----------+-----------------+----------------+--------------------------------------------------------------------------------+%n");

		}
        System.out.println();

    }

    public void showOptions() {
    	System.out.println("-------MENU-------");
        System.out.println("");
        System.out.println("1) Inserimento Asset");
        System.out.println("2) Modifica Asset");
        System.out.println("3) Cancellazione Asset");
        System.out.println("4) Indietro");
        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
        if (choice < 1 || choice > 4) {
        	this.request = new Request();
        	this.request.put("choice", "assetsManagement");
            MainDispatcher.getInstance().callAction("Asset", "doControl", this.request);
        }
        else if (choice == 4) {
        	this.request.put("choice", "myAssets");
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
        	MainDispatcher.getInstance().callAction("Asset", "doControl", request);        		
        }
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
