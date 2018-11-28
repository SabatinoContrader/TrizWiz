package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Asset;
import main.model.Badge;
import main.model.BadgeReader;

public class InsertBadgeReaderView implements View{

	private Request request;
	private int choice;
    private List<Asset> listAsset;
    private List<BadgeReader> listBadgeReader;
    
    public InsertBadgeReaderView () {

    }

    @Override
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
       
       
       
       
       
       
       
       System.out.println("----- ASSET TOTALI -----");
       System.out.println();
       System.out.format("+------+---------+--------------+-------------+--------------------------------------------------------------------------------+%n");
		System.out.format("| ID   |  TIPO   | PREZZO       | DESCRIZIONE |                                                               		       |%n");
		System.out.format("+------+---------+--------------+-------------+--------------------------------------------------------------------------------+%n");
		
		leftAlignFormat ="| %-4s | %-7s | %-12s | %-11s |%n";
       //this.listAsset.forEach(asset -> System.out.println(asset));
		for (Asset report : this.listAsset) {
			int id = report.getId();
           String tipo = report.getTipo();
			double prezzo = report.getPrezzo();
			String description = report.getDescrizione();
           int idBadgeReader = -1;
			
           /*
			for(BadgeReader br: this.listBadgeReader) {
				if(br.getIdAsset()==id && id==-1) {
					idBadgeReader=br.getIdBadgeReader();
				}
				
			}
			*/
			
			
           try{
           	System.out.format(leftAlignFormat, id ,tipo,prezzo,description);
           }catch (Exception e) {
				// TODO: handle exception
			}
			System.out.format("+------+---------+--------------+-------------+--------------------------------------------------------------------------------+%n");

		}
       System.out.println();
       
    }
    
    @Override
    public void showOptions() {    	
    	System.out.println("Inserisci i dati del badge reader:");
    	System.out.println("ID Asset a cui associare il BadgeReader:");
    	int idAsset=Integer.parseInt(getInput());
    	System.out.println("Descrizione:");
    	int idBadgeReader=0;
    	String descrizione= getInput();
    	System.out.println("Tipologia");
    	String tipologia= getInput();
    	this.request = new Request();
    	this.request.put("newBadgeReader",new BadgeReader(idBadgeReader,idAsset,descrizione,tipologia));
    	this.request.put("choice", "insertBadgeReader");
    }
    
    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
  }
    
    @Override
    public void submit() {
    	MainDispatcher.getInstance().callAction("BadgeReader", "doControl", this.request);
    }
	
}
