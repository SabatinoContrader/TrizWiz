package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Principio;

public class SelezionaPrincipioView implements View{

	    private List<Principio> listPrincipio;
		private Request request;
		private int choice;
		private int idPrincipio;
		
		@Override
		public void showResults(Request request) {
			// TODO Auto-generated method stub
			
			//System.out.println("INSERIRE IL NUMERO DEL PARAMETRO DA  VISUALIZZARE");
			this.request=request;
			
			
			
		}
		@Override
		public void showOptions() {
			System.out.println("PAGINA SELEZIONA PRINCIPIO");
			this.listPrincipio= (List<Principio>) ((Request) this.request).get("visualizzaPrincipio");
	    	System.out.println();
	    	System.out.println();
	        System.out.println("----- SELEZIONA NUMERO PRINCIPIO DA VISUALIZZARE -----");
	        System.out.println();
	        System.out.format("+----------+------------------------%n");
	        System.out.format("| ID       | nome Principio         |%n");
	        System.out.format("+----------+------------------------%n");
			String leftAlignFormat2 ="| %-8s | %-21s |%n";
			for (Principio report : this.listPrincipio) {
				int id = report.getId();
	            String nomePrincipio = report.getNomePrincipio();
	            //System.out.println(nomeParametro);
				//String nomeParametroIta = report.getNomeParametroIta();
				
				 try{
		            	System.out.format(leftAlignFormat2, id ,nomePrincipio);
		            }catch (Exception e) {
						// TODO: handle exception
					}
		            System.out.format("+----------+-----------------------+%n");
			}
			
			this.idPrincipio = Integer.parseInt(getInput());
			
		}
		@Override
		public String getInput() {
			
			Scanner scanner = new Scanner(System.in);
	        return scanner.nextLine();
			
		}
		@Override
		public void submit() {
			if ( idPrincipio>=1 || idPrincipio <= 40) {
				String idPrinc= Integer.toString(idPrincipio);
			        request.put("idPrincipio", idPrinc);
			        request.put("choice", "VPrincipio");
	            MainDispatcher.getInstance().callAction("Principi", "doControl", this.request);
	        }
			
		}
}
