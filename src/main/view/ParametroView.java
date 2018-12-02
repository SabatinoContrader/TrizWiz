package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Parametro;
import main.model.Principio;

import java.util.List;
import java.util.Scanner;

//ciao

public class ParametroView implements View {

    private List<Parametro> listParametro;
	private Request request;
	
	public void showResults(Request request){
		this.request=request;
		if(this.request.get("message")!= null){
			System.out.println(this.request.get("message"));
		}

    	this.listParametro= (List<Parametro>) ((Request) this.request).get("visualizzaParametri");
    	System.out.println();
    	System.out.println();
        System.out.println("----- LISTA PARAMETRI -----");
        System.out.println();
        System.out.format("+----------+-----------------------+------------------------+%n");
        System.out.format("| ID       | nomeParametro         | nome Parametro Ita     |%n");
        System.out.format("+----------+-----------------------+------------------------+%n");
		String leftAlignFormat2 ="| %-8s | %-21s | %-10s |%n";
		for (Parametro report : this.listParametro) {
			int id = report.getId();
            String nomeParametro = report.getNomeParametro();
            //System.out.println(nomeParametro);
			String nomeParametroIta = report.getNomeParametroIta();
			//System.out.println(nomeParametroIta);
			//String descrizione = report.getDescrizione();
			//System.out.println(descrizione);
			//String descrizioneIta = report.getDescrizioneIta();
			//System.out.println(descrizioneIta);
			//String icona = report.getIcona();
			//System.out.println(icona);
            
            try{
            	System.out.format(leftAlignFormat2, id ,nomeParametro);
            }catch (Exception e) {
				// TODO: handle exception
			}
            System.out.format("+----------+-----------------------+------------+%n");
            
		}
		MainDispatcher.getInstance().callAction("Reindirizza", "doControl", null);
		
		//System.out.println("Pagina Parametri");

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