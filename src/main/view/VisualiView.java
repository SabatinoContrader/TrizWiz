package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Parametri;
import main.model.Badge;
//import sun.applet.Main;
import main.model.User;

import java.util.List;
import java.util.Scanner;

public class VisualiView implements View {

    private List<Parametri> listParametri;
	private Object request;


    public void visualizza () {
    	this.listParametri= (List<Parametri>) ((Request) this.request).get("visuali");
    	System.out.println();
    	System.out.println();
        System.out.println("----- LISTA Parametri -----");
        System.out.println();
        System.out.format("+----------+-----------------------+------------+-----------------+-------------------+---------+%n");
        System.out.format("| ID       | nomeParametro         | descrizione| nomeParametroIta| descrizioneIta    | icona   |%n");
        System.out.format("+----------+-----------------------+------------+-----------------+-------------------+---------+%n");
		String leftAlignFormat2 ="| %-8s | %-21s | %-10s | %-10s | %-10s |%n";
		for (Parametri report : this.listParametri) {
			int id = report.getId();
            String np = report.getNomeParametro();
			String ds = report.getDescrizione();
			String npt = report.getNomeParametroIta();
			String di = report.getDescrizioneIta();
			String ic = report.getIcona();
            
            try{
            	System.out.format(leftAlignFormat2, id ,np,ds,npt,di,ic);
            }catch (Exception e) {
				// TODO: handle exception
			}
            System.out.format("+----------+-----------------------+------------+------------+------------+------------+-------------------------------+--------------------+----------------+%n");

		}

}


	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub
		
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