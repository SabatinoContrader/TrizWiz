package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Badge;
import main.dao.BadgeDAO;
import main.service.BadgeService;
import java.util.List;
import java.util.Scanner;

public class InsertBadgeView implements View{
	
	private Request request;
    
    public InsertBadgeView () {

    }

    @Override
    public void showResults(Request request) {
       this.request = request;
    }
    
    @Override
    public void showOptions() {    	
    	System.out.println("inserisci dati del nuovo badge");
    	System.out.println("tipologia");
    	int idBadge=0;
    	String tipologia= getInput();
    	System.out.println("descrizione");
    	String descrizione= getInput();
    	this.request = new Request();
    	this.request.put("newBadge",new Badge(idBadge,descrizione,tipologia));
    	this.request.put("choice", "insertBadge");
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
