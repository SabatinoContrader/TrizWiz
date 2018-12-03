package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Principio;

public class AggPrincipioView implements View{
	
	private Request request;

	@Override
	public void showResults(Request request) {
		this.request = request;
		        
	}

	@Override
	public void showOptions() {
		System.out.println("Inserire id principio da modificare:");
		int Id = Integer.parseInt(getInput());
		System.out.println("Inserire modifica nome principio in inglese:");
		String NomePrincipio = getInput();
		System.out.println("Inserire modifica nome principio in italiano:");
    	String NomePrincipioIta = getInput();
		System.out.println("Inserire modifica domande:");
		String Domande = getInput();
		System.out.println("Inserire modifica steps:");
		String Steps = getInput();
		System.out.println("Inserire modifica esempi:");
		String Esempi = getInput();
    	
    	Principio updatePrincipi = new Principio(Id,NomePrincipio,NomePrincipioIta,Domande,Steps,Esempi);
    	request = new Request();
        this.request.put("updatePrincipi", updatePrincipi);
        this.request.put("choice", "updatePrincipi");
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
