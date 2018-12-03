package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Principio;

import java.util.List;
import java.util.Scanner;

//ciao

public class PrincipioView implements View {

    private List<Principio> listPrincipio;
	private Request request;
	private int choice;

	
	public void showResults(Request request){
		this.request=request;
		if(this.request.get("message")!= null){
			System.out.println(this.request.get("message"));
		}

    	this.listPrincipio= (List<Principio>) ((Request) this.request).get("visualizzaPrincipi");
    	System.out.println();
    	System.out.println();
        System.out.println("----- LISTA Principi -----");
        System.out.println();
        System.out.format("+----------+-----------------------+--------------------------------------%n");
        System.out.format("| ID       |      nomePrincipio    |        domande                      |%n");
        System.out.format("+----------+-----------------------+--------------------------------------%n");
		String leftAlignFormat2 ="| %-8s | %-21s | %-10s %n";
		for (Principio report : this.listPrincipio) {
			int id = report.getId();
            String np = report.getNomePrincipio();
			//String ds = report.getNomePrincipioIta();
			String npt = report.getDomande();
			//String di = report.getSteps();
			//String ic = report.getEsempi();
            
            try{
            	System.out.format(leftAlignFormat2, id ,np,npt);
            }catch (Exception e) {
				// TODO: handle exception
			}
            System.out.format("+----------+--------------------+------------------------------------------+%n");
            
		}
		//MainDispatcher.getInstance().callAction("Reindirizza", "doControl", null);
	}
	   @Override
		public void showOptions() {
			System.out.println("");
	        System.out.println("");
	        System.out.println("-------MENU PRINCIPI-------");
	        System.out.println("");
	        System.out.println("1) Visualizza dettaglio principio");
	        System.out.println("2) Torna al menu");
	        
	        this.choice = Integer.parseInt(getInput());
		}
		@Override
		public String getInput() {
			Scanner scanner = new Scanner(System.in);
	        return scanner.nextLine();
		}


		@Override
		public void submit() {
			this.request = new Request();
	        if (choice < 1 || choice > 1) {
	        	MainDispatcher.getInstance().callAction("Reindirizza", "doControl", null);
	        }
	        
	         if (choice == 1) {
	        	this.request.put("choice", "SelPrincipio");
	            MainDispatcher.getInstance().callAction("Principi", "doControl", this.request);
	        }
			
		}
}