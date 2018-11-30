package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Principio;

import java.util.List;
import java.util.Scanner;

public class PrincipioView implements View {

    private List<Principio> listPrincipio;
	private Request request;
	
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
        System.out.format("+----------+-----------------------+-----------------+-----------------+-------------------+---------+%n");
        System.out.format("| ID       | nomePrincipio         | nomePrincipioIta| domande         | steps             | esempi  |%n");
        System.out.format("+----------+-----------------------+-----------------+-----------------+-------------------+---------+%n");
		String leftAlignFormat2 ="| %-8s | %-21s | %-10s | %-10s | %-10s |%n";
		for (Principio report : this.listPrincipio) {
			int id = report.getId();
            String np = report.getNomePrincipio();
			String ds = report.getNomePrincipioIta();
			String npt = report.getDomande();
			String di = report.getSteps();
			String ic = report.getEsempi();
            
            try{
            	System.out.format(leftAlignFormat2, id ,np,ds,npt,di,ic);
            }catch (Exception e) {
				// TODO: handle exception
			}
            System.out.format("+----------+-----------------------+------------+------------+------------+------------+-------------------------------+--------------------+----------------+%n");

		}

}


	


	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getInput() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void submit() {
		// TODO Auto-generated method stub
		
	}
}