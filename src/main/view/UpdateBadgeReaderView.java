package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Badge;

public class UpdateBadgeReaderView implements View{

    private Request request;
    
    public UpdateBadgeReaderView () {

    }

    @Override
    public void showResults(Request request) {
       this.request = request;
    }
    
    @Override
    public void showOptions() {    	
    	System.out.println("Inserisci dati del nuovo BadgeReader");
    	System.out.println("Inserisci l'id del BadgeReader che vuoi modificare:");
    	int idBadgeReader=Integer.parseInt(getInput());
    	
    	System.out.println("Inserisci l'id dell'Asset al quale vuoi associare il BadgeReader con id" + idBadgeReader); 
    	int idAsset= Integer.parseInt(getInput());
    	
    	this.request = new Request();
    	this.request.put("newIdBadgeReader", idBadgeReader);
    	this.request.put("newIdAsset", idAsset);
    	this.request.put("choice", "updateBadgeReader");
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
