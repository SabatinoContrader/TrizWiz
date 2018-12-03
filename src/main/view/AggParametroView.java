package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Parametro;;

public class AggParametroView implements View{
	
	private Request request;

	@Override
	public void showResults(Request request) {
		this.request = request;
		        
	}

	@Override
	public void showOptions() {
		System.out.println("Inserire id parametro da modificare:");
		int Id = Integer.parseInt(getInput());
		System.out.println("Inserire modifica nome parametro in inglese:");
		String NomeParametro = getInput();
		System.out.println("Inserire modifica nome parametro in italiano:");
    	String NomeParametroIta = getInput();
		System.out.println("Inserire descrizone:");
		String descrizione = getInput();
		System.out.println("Inserire descrizione in italiano:");
		String descrizioneIta = getInput();
		System.out.println("Inserire icona:");
		String icona = getInput();
    	
    	Parametro updateParametri = new Parametro(Id,NomeParametro,NomeParametroIta,descrizione,descrizioneIta,icona);
    	request = new Request();
        this.request.put("updateParametri", updateParametri);
        this.request.put("choice", "updateParametri");
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
	}

	@Override
	public void submit() {
		MainDispatcher.getInstance().callAction("GestoreParametri", "doControl", this.request);
	}

}
