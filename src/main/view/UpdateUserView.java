package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Asset;
import main.model.User;
import main.dao.UserDAO;
import main.service.UserService;

import java.util.List;
import java.util.Scanner;

public class UpdateUserView implements View{

    private Request request;
     
    public UpdateUserView () {
    	
    }

    @Override
    public void showResults(Request request) {
       this.request = request;
    }

    @Override
    public void showOptions() {    	
    	/*
   	 	System.out.println(listUser.isEmpty());
   	 	for(User u: userService.getAllUsers()) {
   		 	System.out.println(u);
   	 	}*/

    	int idUtente=0;
    	try {
    		System.out.println("Inserisci l'id riferito all'utente da aggiornare:");
    		idUtente=Integer.parseInt(getInput());
    	}catch(Exception e) {//Controllo id valido
    		System.out.println("L'ID Utente deve essere un intero");
    	}

//    	boolean trovato=false;
//    	for(User u: userService.getAllUsers()) {
//    		if(u.getIdutente() == idutente) {
//    			trovato=true;
//    		}
//    	}
    	/*
        if(!trovato) {//Controllo id presente nel db
       	 System.out.println("ID "+idutente+" non trovato!"); 
       	 break;
        }
    	 */

    	//Cambia il numero con il nome e effettua i controlli
    	System.out.println("Inserisci il numero del campo che vuoi modificare:");
    	int num=Integer.parseInt(getInput());
    	String campo="";
if (num <1 || num > 8)
{
	while (num <1 || num > 8) {
	System.out.println("il numero deve essere compreso tra 1 e 8");
	System.out.println("inserire nuovamente la scelta:");
	num = Integer.parseInt(getInput());
	}
}
    	switch(num) {
    		case 1: campo="username";break;
    		case 2: campo="password";break;
    		case 3: campo="nome";break;
    		case 4: campo="cognome";break;
    		case 5: campo="telefono";break;
    		case 6: campo="mail";break;
    		case 7: campo="partitaiva";break;
    		case 8: campo="ruolo";break;
    	}

    	System.out.println("Inserisci il nuovo campo "+ campo +" dell'utente:");
    	String newData=getInput();

    	this.request = new Request();
    	this.request.put("idUtente", idUtente);
    	this.request.put("newData", newData);
    	this.request.put("campo", campo);
    	this.request.put("choice", "updateUser");
    }
    
    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {
    	MainDispatcher.getInstance().callAction("User", "doControl", this.request);
    }

}
