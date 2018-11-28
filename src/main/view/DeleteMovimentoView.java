package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Asset;
import main.model.Movimento;
import main.model.User;
import main.model.UserAsset;
import main.dao.UserDAO;
import main.service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DeleteMovimentoView implements View{

    private Request request;
    private int idbadgereader;
    private int idbadge;
    private String datainizio;
    private String datafine;
    private List<Movimento> listMovimento;

    public DeleteMovimentoView() {

    }

    @Override
    public void showResults(Request request) {
    	this.request = request;
	    if (this.request.get("message") != null) {
	   		System.out.println(this.request.get("message"));
	   	}	
	    this.listMovimento = (List<Movimento>) this.request.get("visualizzaMovimenti");
	   	System.out.println();
	   	System.out.println();
	    System.out.println("Movimenti Management Base");
	   	System.out.println();
	   	System.out.println("Gestione Movimenti");
	   	System.out.println("");
	    System.out.println("----- LISTA MOVIMENTI -----");
	    System.out.println();
	    //this.listUser.forEach(user -> System.out.println(user));
	    System.out.format("+----------------+----------------+-------------------+------------+%n");
		System.out.format("| IDbadgereader  | Idbadge        | Datainizio        | Datafine   |%n");
		System.out.format("+----------------+----------------+-------------------+------------+%n");
		String leftAlignFormat2 ="| %-8s | %-21s | %-10s | %-10s|%n";
		for (Movimento report : this.listMovimento) {
			int idBadgereader = report.getIdbadgereader();
			int idBadge = report.getIdbadge();
			String datainizio = report.getDatainizio();
			String datafine = report.getDatafine();
	        try{
	          	System.out.format(leftAlignFormat2,idBadgereader, idBadge ,datainizio,datafine);
	        }catch (Exception e) {
	        // TODO: handle exception
		}
	    System.out.format("+----------------+----------------+-------------------+------------+%n");
		}
	    System.out.println();
    }

    @Override
    public void showOptions() {    	
    	System.out.println("Inserisci il movimento da eliminare:");
        System.out.println("Id badgereader:");
        idbadgereader = Integer.parseInt(getInput());
        System.out.println("inserisci id badge:");
        idbadge = Integer.parseInt(getInput());
        System.out.println("inserisci la data di inizio del movimento che vuoi eliminare:");
        datainizio = getInput();
        
        for(Movimento movimento: listMovimento) {
        	if(idbadgereader==movimento.getIdbadgereader() && idbadge==movimento.getIdbadgereader() && datainizio.equals(movimento.getDatainizio()))
        	if(!verificaPrenotazioni(movimento.getDatainizio())) {
        		System.out.println("La data deve essere maggiore rispetto a quella odierna");
        		request = new Request();
        		request.put("choice","movimentiManagement");
        		
        		MainDispatcher.getInstance().callAction("Movimento", "doControl", request);
        		
        	}
        }
        
        this.request = new Request();
        this.request.put("delIdBadgeReader",idbadgereader);
        this.request.put("delIdBadge",idbadge);
        this.request.put("delDatainizio", datainizio);
        this.request.put("choice", "deleteMovimento");
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {
    	MainDispatcher.getInstance().callAction("Movimento", "doControl", this.request);
    }

    private boolean verificaPrenotazioni(String date) {
    	String dateNow=stringDate(LocalDateTime.now().toString());
    	//System.out.println(dateNow);
    	//MyData dateNow=new MyData(LocalDateTime.now());
    	if( dateNow.compareTo( date )<0 ){
    		return true;
    	}
    	return false;
    }
    
    public String stringDate(String date){
		//String date = LocalDateTime.now().toString();
		StringTokenizer st=new StringTokenizer(date,"T ");
		//ArrayList<String> dateList=new ArrayList<>();
		String dateS="";
		
		//VECCHIA DATA
		//LocalDateTime --> yyyy-mm-ggThh:mm:ss.mls (es. 2018-09-29T10:29:51.025)
		while(st.hasMoreTokens()) {
			String tk=st.nextToken();
			tk+=" ";
			if(tk.length()>=3 && tk.charAt(2)==('.')) {
				String temp=tk.substring(0, 1);
				tk=temp+tk.substring(1,2);
				dateS+=tk;
				break;
			}
			dateS+=tk;
		}
		//NUOVA DATA
		//dateList --> yyyy mm gg hh mm ss (es. 2018 09 29 10 29 51)
		return dateS;
	}

}
