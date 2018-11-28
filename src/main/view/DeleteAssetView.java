package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Asset;
import main.model.User;
import main.dao.UserDAO;
import main.service.UserService;

import java.util.List;
import java.util.Scanner;

public class DeleteAssetView implements View{

    private Request request;
     
    public DeleteAssetView () {

    }

    @Override
    public void showResults(Request request) {
       this.request = request;
    }

    @Override
    public void showOptions() {    	
    	System.out.println("Inserire l'id dell'asset da eliminare");
    	System.out.println("Id:");
    	int idasset = Integer.parseInt(getInput());
    	this.request = new Request();
    	this.request.put("delAsset",idasset);
    	this.request.put("choice", "deleteAsset");
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
