package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Asset;
import main.model.User;
import main.dao.UserDAO;
import main.service.UserService;

import java.util.List;
import java.util.Scanner;

public class UpdateAssetView implements View{

    private Request request;
     
    public UpdateAssetView () {
    	
    }

    @Override
    public void showResults(Request request) {
       this.request = request;
    }

    @Override
    public void showOptions() {    	
    	int idAsset = 0;
        try {
        	System.out.println("Inserisci l'id dell'asset da aggiornare:");
        	idAsset = Integer.parseInt(getInput());
        }catch(Exception e) {//Controllo id valido
   		 	System.out.println("L'ID dell'asset deve essere un intero");
   	 	}
        
        System.out.println("Inserisci il numero del campo che vuoi modificare:");
   	 	int num=Integer.parseInt(getInput());
   	 	String campo="";
   	 
   	 	switch(num) {
   	 		case 1: campo="tipo";break;
   	 		case 2: campo="prezzo";break;
   	 		case 3: campo="descrizione";break;
   	 	}
   	 	
   	 	System.out.println("Inserisci il nuovo campo "+ campo +" dell'asset:");
   	 	String newData = getInput();
   	 	this.request = new Request();
   	 	this.request.put("idAsset", idAsset);
   	 	this.request.put("newData", newData);
   	 	this.request.put("campo", campo);
   	 	this.request.put("choice", "updateAsset");
    }
    
    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {
    	MainDispatcher.getInstance().callAction("Asset", "doControl", this.request);
    }

}
