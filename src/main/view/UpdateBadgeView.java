package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Badge;
import main.dao.BadgeDAO;
import main.service.BadgeService;
import java.util.List;
import java.util.Scanner;

public class UpdateBadgeView implements View{
	private Request request;
    
    public UpdateBadgeView () {
    	
    }
    
    @Override
    public void showResults(Request request) {
       this.request = request;
    }

    @Override
    public void showOptions() {    	
    	int idBadge = 0;
        try {
        	System.out.println("Inserisci l'id del badge da aggiornare:");
        	idBadge = Integer.parseInt(getInput());
        }catch(Exception e) {//Controllo id valido
   		 	System.out.println("L'ID del badge deve essere un intero");
   	 	}
        
        System.out.println("Inserisci il numero del campo che vuoi modificare:");
   	 	int num=Integer.parseInt(getInput());
   	 	String campo="";
   	 
   	 	switch(num) {
   	 		case 2: campo="tipologia";break;
   	 		case 1: campo="descrizione";break;
   	 	}
   	 	
   	 	System.out.println("Inserisci il nuovo campo "+ campo +" del badge:");
   	 	String newData = getInput();
   	 	this.request = new Request();
   	 	this.request.put("idBadge", idBadge);
   	 	this.request.put("newData", newData);
   	 	this.request.put("campo", campo);
   	 	this.request.put("choice", "updateBadge");
    }
    
    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {
    	MainDispatcher.getInstance().callAction("Badge", "doControl", this.request);
    }

}



