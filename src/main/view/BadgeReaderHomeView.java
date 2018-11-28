package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Asset;
import main.model.BadgeReader;

public class BadgeReaderHomeView implements View{

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
    	this.listBadgeReader = (List<BadgeReader>) this.request.get("visualizzaBadgeReaders");
        System.out.println();
        System.out.println();
        System.out.println("Asset Management Base");
    	System.out.println();
    	System.out.println("Gestione Asset");
    	System.out.println();
    	System.out.println("----- ASSET CON ID BADGE READER ASSOCIATO -----");
        System.out.println();
        System.out.format("+------+---------+--------------+-------------+--------------------------------------------------------------------------------+%n");
		System.out.format("| ID   |  TIPO   | PREZZO       | DESCRIZIONE | ID BADGE READER | TIPOLOGIA | DESCRIZIONE                                      |%n");
		System.out.format("+------+---------+--------------+-------------+-----------------+-----------+--------------------------------------------------+%n");
		String leftAlignFormat ="| %-4s | %-7s | %-12s | %-11s | %-15s | %-9s | %-48s |%n";
        //this.listAsset.forEach(asset -> System.out.println(asset));
		for (Asset report : this.listAsset) {
			int id = report.getId();
            String tipo = report.getTipo();
			double prezzo = report.getPrezzo();
			String description = report.getDescrizione();
            int idBadgeReader = -1;
            String tipologia = "";
            String descrizione = "";
			
			for(BadgeReader br: this.listBadgeReader) {
				if(br.getIdAsset()==id) {
					idBadgeReader=br.getIdBadgeReader();
					tipologia=br.getTipologia();
					descrizione=br.getDescrizione();
					
					try{
			            System.out.format(leftAlignFormat, id ,tipo,prezzo,description, idBadgeReader,tipologia,descrizione);
			        }catch (Exception e) {
						// TODO: handle exception
					}
					System.out.format("+------+---------+--------------+-------------+-----------------+-----------+--------------------------------------------------+%n");
				}
				
			}
			
			
			/*
            try{
            	System.out.format(leftAlignFormat, id ,tipo,prezzo,description, idBadgeReader,tipologia,descrizione);
            }catch (Exception e) {
				// TODO: handle exception
			}
			System.out.format("+------+---------+--------------+-------------+-----------------+-----------+--------------------------------------------------+%n");
			*/
		}
        System.out.println();
    }
    
    
    public void showOptions() {
    	System.out.println("-------MENU-------");
        System.out.println("");
        System.out.println("1) Inserimento BadgeReader");
        System.out.println("2) Modifica BadgeReader");
        System.out.println("3) Cancellazione BadgeReader");
        System.out.println("4) Indietro");
        this.choice = Integer.parseInt(getInput());
    }
    
    
    public void submit() {
    	if (choice < 1 || choice > 4) {
        	this.request = new Request();
        	this.request.put("choice", "badgesReaderManagement");
            MainDispatcher.getInstance().callAction("BadgeReader", "doControl", this.request);
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
        	MainDispatcher.getInstance().callAction("BadgeReader", "doControl", request);        		
        }
    }
    
    
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
	
}
