package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;

public class DeleteBadgeReaderView implements View{
	private Request request;
    
    public DeleteBadgeReaderView () {

    }
    
    @Override
    public void showResults(Request request) {
       this.request = request;
    }
    
    @Override
    public void showOptions() {    	
    	System.out.println("Inserire l'id del BadgeReader da eliminare");
    	System.out.println("Id:");
    	int idBadgeReader = Integer.parseInt(getInput());
    	this.request = new Request();
    	this.request.put("delBadgeReader",idBadgeReader);
    	this.request.put("choice", "deleteBadgeReader");
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
