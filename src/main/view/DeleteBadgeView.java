package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Badge;
import main.dao.BadgeDAO;
import main.service.BadgeService;

import java.util.List;
import java.util.Scanner;


public class DeleteBadgeView implements View{
	private Request request;
    
    public DeleteBadgeView () {

    }
    
    @Override
    public void showResults(Request request) {
       this.request = request;
    }
    
    @Override
    public void showOptions() {    	
    	System.out.println("Inserire l'id del badge da eliminare");
    	System.out.println("Id:");
    	int idBadge = Integer.parseInt(getInput());
    	this.request = new Request();
    	this.request.put("delBadge",idBadge);
    	this.request.put("choice", "deleteBadge");
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
