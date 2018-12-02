package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Principio;

import java.util.List;

//ciao

public class MatrixView implements View {

    private List<Principio> listPrincipio;
	private Request request;
	
	public void showResults(Request request){
		this.request=request;
		if(this.request.get("message")!= null){
			System.out.println(this.request.get("message"));
		}

    	this.listPrincipio= (List<Principio>) this.request.get("visualizzaMatrix");
    	System.out.println();
    	System.out.println();
        System.out.println("----- LISTA Principi da utilizzare-----");
        System.out.println();
        System.out.format("+-----------------------+-----------------+-----------------+-------------------+---------+%n");
        System.out.format("| nomePrincipio         | nomePrincipioIta| domande         | steps             | esempi  |%n");
        System.out.format("+-----------------------+-----------------+-----------------+-------------------+---------+%n");
		String leftAlignFormat2 ="| %-8s | %-21s | %-10s | %-10s | %-10s |%n";
		for (Principio report : this.listPrincipio) {
			int id = report.getId();
            String np = report.getNomePrincipio();
			String ds = report.getNomePrincipioIta();
			String npt = report.getDomande();
			String di = report.getSteps();
			String ic = report.getEsempi();
            
            try{
            	System.out.format(leftAlignFormat2 ,np,ds,npt,di,ic);
            }catch (Exception e) {
				// TODO: handle exception
			}
            System.out.format("+----------+-----------------------+------------+------------+------------+%n");
            
		}
		MainDispatcher.getInstance().callAction("Reindirizza", "doControl", null);

}


	


	public void showOptions() {
		// TODO Auto-generated method stub
		
	}


	public String getInput() {
		// TODO Auto-generated method stub
		return null;
	}


	public void submit() {
		// TODO Auto-generated method stub
		
	}
}