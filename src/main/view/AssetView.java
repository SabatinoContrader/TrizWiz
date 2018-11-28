package main.view;
import main.MainDispatcher;
import main.controller.AssetController;
import main.controller.Request;
import main.model.Asset;
import main.dao.AssetDAO;
import main.service.AssetService;

import java.util.List;
import java.util.Scanner;

public class AssetView implements View {

    private AssetService assetService;
    private String mode;
    private String tipo;
    private List<Asset> listAsset;
    private Request request;

  public AssetView () {
      this.assetService = new AssetService();
      this.mode = "all";
  }

    @Override
    public void showResults(Request request) {
       this.mode  = request.get("mode").toString();
       this.listAsset = (List<Asset>) request.get("visualizzaAssets");
    }

    @Override
    public void showOptions() {
        switch (mode) {
            case "getList":
                System.out.println("----- Asset disponibili -----");
                System.out.println();
                this.listAsset.forEach(asset -> System.out.println(asset));
                this.request = new Request();
                this.request.put("choice", "getListAssets");
            	MainDispatcher.getInstance().callAction("Asset", "doControl", this.request);
                break;
            case "insert":
            	System.out.println("inserisci dati del nuovo asset");
            	System.out.println("tipo");
            	int id=0;
            	String tipo= getInput();
            	System.out.println("prezzo");
            	double prezzo = Double.parseDouble(getInput());
            	System.out.println("descrizione");
            	String descrizione= getInput();
            	//assetService.insertAsset(new Asset(id,tipo,prezzo,descrizione));
            	request = new Request();
            	request.put("asset",new Asset(id,tipo,prezzo,descrizione));
            	request.put("choice", "insertAsset");
            	MainDispatcher.getInstance().callAction("Asset", "doControl", request);
            	//assetService.insertAsset(new Asset(id,tipo,prezzo,descrizione));
            	break;
            case "delete":
            	listAsset.forEach(asset -> System.out.println(asset));
            	//List<Asset> asset = assetService.getAllAssets();
            	//asset.forEach(u->System.out.println(u));
            	System.out.println("inserire l'asset da eliminare");
            	System.out.println("Id:");
            	int idasset = Integer.parseInt(getInput());
            	//assetService.DeleteAsset(idasset);
            	request = new Request();
            	request.put("delAsset",idasset);
            	request.put("choice", "deleteAsset");
            	MainDispatcher.getInstance().callAction("Asset", "doControl", request);
            	System.out.println("Asset eliminato,ritorno al menu");
            	break;
            case "update":
            	listAsset.forEach(asset -> System.out.println(asset));
            	//listAsset = assetService.getAllAssets();
                System.out.println();
                
                
                try {
                	System.out.println("Inserisci l'id dell'asset che vuoi aggiornare:");
                	idasset = Integer.parseInt(getInput());
                }catch(Exception e) {//Controllo id valido
           		 System.out.println("L'ID dell'asset deve essere un intero");break;
           	 	}
                
                System.out.println("Inserisci il numero del campo che vuoi modificare:");
           	 	int num=Integer.parseInt(getInput());
           	 	String campo="";
           	 
           	 	switch(num) {
           	 		case 1: campo="tipo";break;
           	 		case 2: campo="prezzo";break;
           	 		case 3: campo="descrizione";break;
           	 	}
           	 	
           	 	System.out.println("Inserisci il nuovo "+campo+" dell'asset:");
           	 	String newCampo=getInput();
        	 
             
             
             
           	 	Request request = new Request();
           	 	request.put("idasset", idasset);
           	 	request.put("newCampo", newCampo);
           	 	request.put("campo", campo);
                request.put("choice", "updateAsset");
           	 	MainDispatcher.getInstance().callAction("Asset", "doControl", request);
           	 	
           	 	/*
           	 	boolean flag = assetService.UpdateAsset(request);
           	 	if(!flag)System.out.println("Id "+ idasset+" non trovato");
           	 	break;
           	 	*/
            	
        }
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
  }

    @Override
    public void submit() {
        MainDispatcher.getInstance().callAction("Home", "doControl", null);
    }



}
