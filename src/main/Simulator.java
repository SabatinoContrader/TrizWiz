package main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.model.Assegnazione;
import main.model.Movimento;
import main.service.AssegnazioneService;
import main.service.MovimentoService;

public class Simulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		MovimentoService movimentoService = new MovimentoService();
		AssegnazioneService assegnazioneService = new AssegnazioneService();
		List<Movimento> listMovimenti = new ArrayList<>();
		List<Assegnazione> listAssegnazioni = new ArrayList<>();
		String message;
		int idUser = 0;
		boolean found;
		boolean access;
		while (true) {
			found = false;
			System.out.println("-------SIMULATOR-------");
	        System.out.println("");
	        System.out.println("Inserimento Badge Reader");
	        int idBadgeReader = Integer.parseInt(scanner.nextLine());
	        System.out.println("Inserimento Badge");
	        int idBadge = Integer.parseInt(scanner.nextLine());
	        String dateNow = LocalDateTime.now().toString();
	        listMovimenti = movimentoService.getAllMovimenti();
	        for (Movimento movimento : listMovimenti) {
	        	if ((movimento.getIdbadgereader() == idBadgeReader) && (movimento.getDatafine() == null)) {
	        		if (movimento.getIdbadge() == idBadge) {
	        			message = "Uscita Badge " + idBadge;
	        			System.out.println(message);
	        			if (movimentoService.updateMovimento(movimento.getIdbadgereader(), movimento.getIdbadge(), movimento.getDatainizio(), dateNow)) {
	        				message = "Uscita Badge " + idBadge + " Avvenuta Correttamente";
	        			}
	        			else {
	        				message = "Errore Uscita Badge " + idBadge;
	        			}
	        			System.out.println(message);
	        			found = true;
	        			break;
	        		}
	        		else {
	        			access = false;
	        			listAssegnazioni = assegnazioneService.getAllAssegnazioni();
	    	            for (Assegnazione assegnazione : listAssegnazioni) {
	    	            	if ((assegnazione.getIdBadge() == idBadge) && (assegnazione.getIdUtente() == idUser)) {
	    	            		access = true;
	    	            		message = "Badge Appartenente Organizzazione, Accesso Consentito";
	    	        			System.out.println(message);
	    	            		break;
	    	            	}	
	    	            }
	    	            if (! access) {
	    	            	message = "Asset Occupato, Impossibile Accedere";
	    	            	System.out.println(message);
	    	            	found = true;
	    	            	break;
	    	            }
	        		}
	        	}
	        }	
	        if (! found) {
	        	message = "Ingresso Badge " + idBadge;
	            System.out.println(message);
	            listAssegnazioni = assegnazioneService.getAllAssegnazioni();
	            for (Assegnazione assegnazione : listAssegnazioni) {
	            	if (assegnazione.getIdBadge() == idBadge) {
	            		idUser = assegnazione.getIdUtente();
	            		break;
	            	}	
	            }
	        	Movimento movimento = new Movimento(idBadgeReader, idBadge, dateNow, null);
	            if (movimentoService.insertMovimento(movimento)) {
	            	message = "Ingresso Badge " + idBadge + " Avvenuto correttamente";
	            }
	            else {
	            	message = "Errore Ingresso Badge " + idBadge;
	            }
	            System.out.println(message);
	        }
		}
	}

}
