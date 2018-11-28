package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Asset;
import main.model.User;
import main.model.UserAsset;
import main.dao.UserDAO;
import main.service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InsertUserAssetView implements View{

    private Request request;
    private List<Asset> userAssetsNonPrenotati;
    private List<UserAsset> userAssets;
    private List<User> users;
    private String orainizio;
    
    public InsertUserAssetView () {

    }

    @Override
    public void showResults(Request request) {
       this.request = request;
       this.userAssetsNonPrenotati = (List<Asset>) this.request.get("visualizzaAssetsSenzaPrenotazioni");
       this.userAssets = (List<UserAsset>) this.request.get("visualizzaUtentiAssets");
       this.users = (List<User>) this.request.get("visualizzaClienti");
       System.out.println("----- Asset senza prenotazioni -----");
   	   System.out.println();
   	   this.userAssetsNonPrenotati.forEach(asset -> System.out.println(asset));
   	   System.out.println();
   	   System.out.println("----- Asset con prenotazioni -----");
   	   System.out.println();
   	   this.userAssets.forEach(asset -> System.out.println(asset));
   	   System.out.println();
   	   System.out.println("----- Clienti -----");
   	   System.out.println();
   	   //this.users.forEach(user -> System.out.println(user));
   	System.out.format("+----------+-----------------------+------------+------------+------------+------------+-------------------------------+--------------+-------------+%n");
	System.out.format("| IDutente |UserName               | password   | Nome       |Cognome     |Telefono    |  e-mail                       | partitaIva   |RUOLO        |%n");
    System.out.format("+----------+-----------------------+------------+------------+------------+------------+-------------------------------+--------------+-------------+%n");
	String leftAlignFormat2 ="| %-8s | %-21s | %-10s | %-10s | %-10s | %-10s | %-29s | %-12s | %-11s |%n";
	for (User report : this.users) {
		int id = report.getIdutente();
        String usN = report.getUsername();
		String passW = report.getPassword();
		String nome = report.getNome();
		String cogn = report.getCognome();
		String tel = report.getTelefono();
		String email = report.getMail();
		String piva = report.getPartitaiva();
		String ruolo = report.getRuolo();
        
        try{
        	System.out.format(leftAlignFormat2, id ,usN,passW,nome,cogn,tel,email,piva,ruolo);
        }catch (Exception e) {
			// TODO: handle exception
		}
        System.out.format("+----------+-----------------------+------------+------------+------------+------------+-------------------------------+--------------+-------------+%n");

	}
   	}

    @Override
    public void showOptions() {    	
    	System.out.println("\nInserisci dati");
    	System.out.println("Inserisci id utente");
    	int iduser=Integer.parseInt(getInput());
    	System.out.println("Inserisci id asset");
    	int idasset=Integer.parseInt(getInput());
    	System.out.println("Inserisci la data di inizio prenotazione(yyyy-mm-gg hh:mm:ss):");
    	this.orainizio=getInput();
    	
    	while(!verificaPrenotazioni(orainizio) && !orainizio.equals("")) {
    		System.out.println("La data deve essere maggiore rispetto a quella odierna");
    		orainizio=getInput();
    	}

    	while(  !orainizio.equals("") &&  !controlloAssetDisponibile(idasset,userAssets, orainizio, true)  ) {
    		System.out.println("L'asset con id "+idasset+" è già prenotato per la data: "+orainizio+ "!");
    		System.out.println("Scegli un altra data di inizio prenotazione o premi invio per annullare la prenotazione:");
    		orainizio=getInput();
    	}

    	if(orainizio.equals("")) {
    		request=new Request();
    		request.put("choice", "userAssetHome");
    		MainDispatcher.getInstance().callAction("UserAsset", "doControl", request);
    	}

    	System.out.println("Data inizio correttamente inserita ("+orainizio+")");
    	System.out.println("Inserisci la data di fine prenotazione(yyyy-mm-gg hh:mm:ss):");
    	String orafine= getInput();

    	while( !orafine.equals("") && ( orafine.compareTo(orainizio)<=0 || ( !controlloAssetDisponibile(idasset,userAssets, orafine, false) ) ) ) {
    		if(orafine.compareTo(orainizio)<=0) {
    			System.out.println("La data di fine prenotazione non può essere antecedente alla data di inizio ("+orainizio+")!");
    			System.out.println("Inserisci una data corretta o premi invio per annullare la prenotazione:");
    		}else {
    			System.out.println("L'asset con id "+idasset+" è già prenotato per la data: "+orafine+ "!");
    			System.out.println("Scegli un altra data di fine prenotazione o premi invio per annullare la prenotazione:");
    		}

    		orafine=getInput();
    	}

    	if(orafine.equals("")) {
    		request.put("choice", "userAssetHome");
    		MainDispatcher.getInstance().callAction("UserAsset", "doControl", request);
    	}

    	this.request = new Request();
    	this.request.put("newUserAsset",new UserAsset(iduser,idasset,orainizio,orafine));
    	this.request.put("choice", "insertUserAsset");
    }
    

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {
    	MainDispatcher.getInstance().callAction("UserAsset", "doControl", this.request);
    }
    
    private boolean controlloAssetDisponibile(int idasset,List<UserAsset> userAsset, String date, boolean dateInizio) {

    	//MyData date=new MyData(d);

    	for(UserAsset ua: userAsset) {
    		if(dateInizio) {
    			if( ua.getIdasset()==idasset && date.compareTo(ua.getOrainizio())>=0 && date.compareTo(ua.getOrafine())<0 ) {
    				return false;
    			}
    		}else {
    			if( ua.getIdasset()==idasset && date.compareTo(ua.getOrainizio())>0 && date.compareTo(ua.getOrafine())<=0 ) {
    				return false;
    			}
    			if( ua.getIdasset()==idasset && orainizio.compareTo(ua.getOrainizio())<=0 && date.compareTo(ua.getOrafine())>=0 ){
    				return false;
    			}
    		}
    	}
    	return true;
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
