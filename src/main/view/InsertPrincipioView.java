package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Principio;

public class InsertPrincipioView implements View{
	
	private Request request;

	@Override
	public void showResults(Request request) {
		this.request = request;
		        
	}

	@Override
	public void showOptions() {
		System.out.println("Inserire nome principio in inglese:");
		String NomePrincipio = getInput();
		System.out.println("Inserire nome principio in italiano:");
    	String NomePrincipioIta = getInput();
		System.out.println("Inserire domande:");
		String Domande = getInput();
		System.out.println("Inserire inserire steps:");
		String Steps = getInput();
		System.out.println("Inserire inserire esempi:");
		String Esempi = getInput();
    	
    	Principio insertPrincipio = new Principio(0,NomePrincipio,NomePrincipioIta,Domande,Steps,Esempi);
    	request = new Request();
        this.request.put("insertPrincipio", insertPrincipio);
        this.request.put("choice", "insertPrincipio");
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
