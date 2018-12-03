package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Principio;

public class DelPrincipioView implements View {

	private Request request;
	
	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {    	
    	System.out.println("Inserire l'id del principio da eliminare");
    	System.out.println("Id:");
    	int id = Integer.parseInt(getInput());
    	this.request = new Request();
    	this.request.put("deletePrincipio",id);
    	this.request.put("choice", "deletePrincipio");
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    	
    	
	}
	@Override
	public void submit() {
		MainDispatcher.getInstance().callAction("CrudPrincipi", "doControl", this.request);
		
	}
	

}
