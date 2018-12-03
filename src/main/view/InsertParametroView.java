package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Parametro;
import main.model.Principio;

public class InsertParametroView implements View{

	private Request request;

	
	public void showResults(Request request) {
		this.request = request;
		        
	}

	public void showOptions() {
		System.out.println("Inserire nome parametro in inglese:");
		String nomeParametro = getInput();
		System.out.println("Inserire descrizione parametro:");
    	String descrizione = getInput();
		System.out.println("Inserire nome parametro in italiano:");
		String nomeParametroIta = getInput();
		System.out.println("Inserire descrizione parametro in Italiano:");
		String descrizioneIta = getInput();
		System.out.println("Inserire icona:");
		String icona = getInput();
    	
    	Parametro insertParametro = new Parametro(0,nomeParametro,descrizione,nomeParametroIta,descrizioneIta,icona);
    	request = new Request();
        this.request.put("insertParametro", insertParametro);
        this.request.put("choice", "insertParametro");
	}

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
	}

	public void submit() {
		MainDispatcher.getInstance().callAction("GestoreParametri", "doControl", this.request);
	}

}

