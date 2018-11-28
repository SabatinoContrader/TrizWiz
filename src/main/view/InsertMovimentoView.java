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

public class InsertMovimentoView implements View{

    private Request request;
    private List<Asset> userAssetsNonPrenotati;
    private List<UserAsset> userAssets;
    private List<User> users;
    private List<Movimento> listMovimento;
    private String datainizio;
    private String datafine;
    
    public InsertMovimentoView () {

    }

    @Override
    public void showResults(Request request) {
    	this.request = request;
	    this.listMovimento = (List<Movimento>) this.request.get("visualizzaMovimenti");
	   	System.out.println("----- Movimenti -----");
	   	System.out.println();
	   	//this.users.forEach(user -> System.out.println(user));
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
    	System.out.println("\nInserisci dati");
    	System.out.println("Inserisci id badgereader");
    	int idbadgereader=Integer.parseInt(getInput());
    	System.out.println("Inserisci id badge");
    	int idbadge=Integer.parseInt(getInput());
    	System.out.println("Inserisci la data di inizio movimento(yyyy-mm-gg hh:mm:ss):");
    	this.datainizio=getInput();
    	System.out.println("Inserisci la data di fine movimento(yyyy-mm-gg hh:mm:ss):");
    	this.datafine=getInput();
    	
    	while(!verificaMovimenti(datainizio) && !datainizio.equals("")) {
    		System.out.println("La data deve essere maggiore rispetto a quella odierna");
    		datainizio=getInput();
    	}

//    	while(  !datainizio.equals("") &&  !controlloMovimentiPossibili(idbadgereader,idbadge,listMovimento, datainizio, datafine, true)  ) {
//  		System.out.println("Il badge con id "+idbadge+" è già prenotato per la data: "+datainizio+ "!");
//    		System.out.println("Scegli un altra data di inizio prenotazione o premi invio per annullare la prenotazione:");
//    		datainizio=getInput();
//    	}

    	if(datainizio.equals("")) {
    		request=new Request();
    		request.put("choice", "MovimentoHome");
    		MainDispatcher.getInstance().callAction("Movimento", "doControl", request);
    	}

//    	System.out.println("Data inizio correttamente inserita ("+datainizio+")");
//    	System.out.println("Inserisci la data di fine movimento(yyyy-mm-gg hh:mm:ss):");
//    	String datafine= getInput();

//    	while( !datafine.equals("") && ( datafine.compareTo(datainizio)<=0 || ( !controlloMovimentiPossibili(idbadgereader,idbadge, listMovimento, datainizio, false) ) ) ) {
//    		if(datafine.compareTo(datainizio)<=0) {
//    			System.out.println("La data di fine movimento non può essere antecedente alla data di inizio ("+datainizio+")!");
//    			System.out.println("Inserisci una data corretta o premi invio per annullare il movimento:");
//    		}else {
//    			System.out.println("L'asset con id "+idasset+" è già prenotato per la data: "+orafine+ "!");
//    			System.out.println("Scegli un altra data di fine prenotazione o premi invio per annullare la prenotazione:");
//    		}
//
//    		datafine=getInput();
//    	}

    	if(datafine.equals("")) {
    		request.put("choice", "MovimentoHome");
    		MainDispatcher.getInstance().callAction("Movimento", "doControl", request);
    	}

    	this.request = new Request();
    	this.request.put("newMovimento",new Movimento(idbadgereader,idbadge,datainizio,datafine));
    	this.request.put("choice", "insertMovimento");
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
    
//    private boolean controlloMovimentiPossibili(int idbadgereader,int idbadge,List<Movimento> movimento, String datafine, String datafine2, boolean datainizio) {
//
//    	//MyData date=new MyData(d);
//
//    	for(Movimento ua: movimento) {
//    		if(datainizio) {
//    			if( ua.getIdbadgereader()==idbadgereader && date.compareTo(ua.getDatainizio())>=0 && date.compareTo(ua.getDatafine())<0 ) {
//    				return false;
//    			}
//    		}else {
//    			if( ua.getIdbadgereader()==idbadgereader && date.compareTo(ua.getDatainizio())>0 && date.compareTo(ua.getDatafine())<=0 ) {
//    				return false;
//    			}
//    			if( ua.getIdasset()==idasset && orainizio.compareTo(ua.getOrainizio())<=0 && date.compareTo(ua.getOrafine())>=0 ){
//    				return false;
//    			}
//    		}
//    	}
//    	return true;
//    }

    private boolean verificaMovimenti(String date) {
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
