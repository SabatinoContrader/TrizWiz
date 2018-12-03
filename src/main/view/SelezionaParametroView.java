package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Parametro;

public class SelezionaParametroView implements View{

	    private List<Parametro> listParametro;
		private Request request;
		private int choice;
		private int idParametro;
		
		@Override
		public void showResults(Request request) {
			// TODO Auto-generated method stub
			
			//System.out.println("INSERIRE IL NUMERO DEL PARAMETRO DA  VISUALIZZARE");
			this.request=request;
			
			
			
		}
		@Override
		public void showOptions() {
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
	            //System.out.println(nomeParametro);
				//String nomeParametroIta = report.getNomeParametroIta();
				
				 try{
		            	System.out.format(leftAlignFormat2, id ,nomeParametro);
		            }catch (Exception e) {
						// TODO: handle exception
					}
		            System.out.format("+----------+-----------------------+%n");
			}
			
			this.idParametro = Integer.parseInt(getInput());
			
		}
		@Override
		public String getInput() {
			
			Scanner scanner = new Scanner(System.in);
	        return scanner.nextLine();
			
		}
		@Override
		public void submit() {
			if ( idParametro>=1 || idParametro <= 39) {
				String idParam= Integer.toString(idParametro);
			        request.put("idParametro", idParam);
			        request.put("choice", "VParametro");
	            MainDispatcher.getInstance().callAction("Parametri", "doControl", this.request);
	        }
			
		}
}
