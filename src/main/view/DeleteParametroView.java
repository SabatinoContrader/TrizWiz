package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Parametro;

public class DeleteParametroView implements View{
	
	private List<Parametro> listParametro;
	private Request request;
	private int choice;
	private int idParametro;
	
	public void showResults(Request request) {
		
		// TODO Auto-generated method stub
		
		//System.out.println("INSERIRE IL NUMERO DEL PARAMETRO DA  VISUALIZZARE");
		this.request=request;
		
		this.listParametro= (List<Parametro>) ((Request) this.request).get("visualizzaParametri");
    	System.out.println();
    	System.out.println();
        System.out.println("----- SELEZIONA NUMERO PARAMETRO DA VISUALIZZARE -----");
        System.out.println();
        System.out.format("+----------+-----------------------+------------------------+%n");
        System.out.format("| ID       | nomeParametro         |%n");
        System.out.format("+----------+-----------------------+------------------------+%n");
		String leftAlignFormat2 ="| %-8s | %-21s | %-10s |%n";
		for (Parametro report : this.listParametro) {
			int id = report.getId();
            String nomeParametro = report.getNomeParametro();
			
			 try{
	            	System.out.format(leftAlignFormat2, id ,nomeParametro);
	            }catch (Exception e) {
					// TODO: handle exception
				}
	            System.out.format("+----------+-----------------------+%n");
		}
		
		
		
	}
	public void showOptions() {
		System.out.println("INSERISCI NUMERO ID PARAMETRO DA ELIMINARE");
		System.out.println("Id");
		int idParametro=Integer.parseInt(getInput());
		this.request= new Request();
		this.request.put("deleteIdParametro", idParametro);
		this.request.put("choice", "deleteParametro");
		
		//this.idParametro = Integer.parseInt(getInput());
		
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
