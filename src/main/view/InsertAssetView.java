package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Asset;
import main.model.User;
import main.dao.UserDAO;
import main.service.UserService;

import java.util.List;
import java.util.Scanner;

public class InsertAssetView implements View{

    private Request request;
     
    public InsertAssetView () {

    }

    @Override
    public void showResults(Request request) {
       this.request = request;
    }

    @Override
    public void showOptions() {    	
    	System.out.println("inserisci dati del nuovo asset");
    	System.out.println("tipo");
    	int id=0;
    	String tipo= getInput();
    	System.out.println("prezzo");
    	double prezzo = Double.parseDouble(getInput());
    	System.out.println("descrizione");
    	String descrizione= getInput();
    	this.request = new Request();
    	this.request.put("newAsset",new Asset(id,tipo,prezzo,descrizione));
    	this.request.put("choice", "insertAsset");
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
