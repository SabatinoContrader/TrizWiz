package main.view;


	import java.util.List;

	import main.MainDispatcher;
	import main.controller.Request;
	import main.model.Principio;

	public class VDettaglioPrincipioView implements View{

		
		private Principio principio;
		private Request request;
		
		@Override
		public void showResults(Request request) {
			principio=new Principio();
			System.out.println("PAGINA VISUALIZZA DETTAGLIO PRINCIPIO");
			this.principio= (Principio) ((Request) request).get("valoriPrincipio");
			if (principio==null) {
				System.out.println("nessun valore in principio");
			}
			else {
	    	System.out.println();
	    	System.out.println();
	        System.out.println("----- DETTAGLIO PRINCIPIO -----");
	        System.out.println();
	       // System.out.format("+----------+-----------------------+------------------------+%n");
	       // System.out.format("| ID       | nomeParametro         | nome Parametro Ita     |%n");
	       // System.out.format("+----------+-----------------------+------------------------+%n");
			//String leftAlignFormat2 ="| %-8s | %-21s | %-10s |%n";
			//for (Parametro report : this.listParametro) {
				int id = principio.getId();
				System.out.println("ID PRINCIPIO:" +id);
	            String nomePrincipio = principio.getNomePrincipio();
	            System.out.println("NOME PRINCIPIO:" +nomePrincipio);
				String nomePrincipioIta = principio.getNomePrincipioIta();
				System.out.println("NOME PRINCIPIO ITALIANO:" +nomePrincipioIta);
				String domande = principio.getDomande();
				System.out.println("DOMANDE:" +domande);
				String steps = principio.getSteps();
				System.out.println("STEPS:" +steps);
				String esempi = principio.getEsempi();
				System.out.println("ESEMPI:" +esempi);
	            
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


