package main.view;

import java.util.List;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Parametro;

public class VDettaglioParametroView implements View{

	
	private Parametro parametro;
	private Request request;
	
	public void showResults(Request request) {
		parametro=new Parametro();
		System.out.println("PAGINA VISUALIZZA DETTAGLIO PARAMETRO");
		this.parametro= (Parametro) ((Request) request).get("valoriParametro");
		if (parametro==null) {
			System.out.println("nessun valore in parametro");
		}
		else {
    	System.out.println();
    	System.out.println();
        System.out.println("----- DETTAGLIO PARAMETRO -----");
        System.out.println();
       // System.out.format("+----------+-----------------------+------------------------+%n");
       // System.out.format("| ID       | nomeParametro         | nome Parametro Ita     |%n");
       // System.out.format("+----------+-----------------------+------------------------+%n");
		//String leftAlignFormat2 ="| %-8s | %-21s | %-10s |%n";
		//for (Parametro report : this.listParametro) {
			int id = parametro.getId();
			System.out.println("ID PARAMETRO:" +id);
            String nomeParametro = parametro.getNomeParametro();
            System.out.println("NOME PARAMETRO:" +nomeParametro);
			String nomeParametroIta = parametro.getNomeParametroIta();
			System.out.println("NOME PARAMETRO ITALIANO:" +nomeParametroIta);
			String descrizione = parametro.getDescrizione();
			System.out.println("DESCRIZIONE:" +descrizione);
			String descrizioneIta = parametro.getDescrizioneIta();
			System.out.println("DESCRIZIONE ITA:" +descrizioneIta);
			String icona = parametro.getIcona();
			System.out.println("ICONA:" +icona);
            
           // try{
            	//System.out.format(leftAlignFormat2, id ,nomeParametro,nomeParametroIta);
           // }catch (Exception e) {
				// TODO: handle exception
			//}
            //System.out.format("+----------+------------------------------------+%n");
            
		}
		MainDispatcher.getInstance().callAction("Reindirizza", "doControl", null);
		
		//System.out.println("Pagina Parametri");
		
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
