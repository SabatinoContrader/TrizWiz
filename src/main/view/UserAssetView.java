package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Asset;
import main.model.User;
import main.model.UserAsset;
import main.dao.UserAssetDAO;
import main.service.AssetService;
import main.service.UserService;
import main.service.UserAssetService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;import java.util.Scanner;
import java.util.StringTokenizer;

public class UserAssetView implements View {

    private UserAssetService userAssetService;
    private String username;
    private String mode;
    private UserService userService;
    private List<UserAsset> listUserAsset;
    private Request request;
    private int iduser;
    private int idasset;
    private String iddata;
    String orainizio;

	public UserAssetView () {
	    this.userAssetService = new UserAssetService();
	    this.userService = new UserService();
	    this.request = new Request();
	    this.mode = "all";
	}

    @Override
    public void showResults(Request request) {
        this.mode  = request.get("mode").toString();
        this.listUserAsset = (List<UserAsset>) request.get("visualizzaUtentiAssets");
    }

    @Override
    public void showOptions() {
		switch (mode) {
        case "getList":
        	System.out.println("----- Asset assegnati -----");
            System.out.println();
            this.listUserAsset.forEach(userasset -> System.out.println(userasset));
            request=new Request();
           	request.put("choice", "getClienti");
           	MainDispatcher.getInstance().callAction("UserAsset", "doControl", request);
            List<User> users = (List<User>) request.get("visualizzaClienti");
            System.out.println("\n\ni clienti con un asset prenotato sono:");
            System.out.println();
            users.forEach(user -> System.out.println(user.stampa()));
            this.request = new Request();
            this.request.put("choice", "getListUsersAssets");
        	MainDispatcher.getInstance().callAction("UserAsset", "doControl", this.request);
            break;
        case "insert":
        	
           	request=new Request();
           	request.put("choice", "getListSenzaPrenotazioni");
           	MainDispatcher.getInstance().callAction("UserAsset", "doControl", request);
           	List<Asset> userAssetsNonPrenotati = (List<Asset>)request.get("visualizzaAssetsSenzaPrenotazioni");
           	
           	System.out.println("----- Asset senza prenotazioni -----");
        	System.out.println();
        	userAssetsNonPrenotati.forEach(asset -> System.out.println(asset));
        	
        	
        	request=new Request();
           	request.put("choice", "getList2");
           	MainDispatcher.getInstance().callAction("UserAsset", "doControl", request);
           	List<UserAsset> userAssets = (List<UserAsset>)request.get("visualizzaUtentiAssets");
        	
        	System.out.println("----- Asset con prenotazioni -----");
        	System.out.println();
        	userAssets.forEach(asset -> System.out.println(asset));
        	
        	List<User> users2 = userService.getAllClienti();	//DA MODIFICARE
        	System.out.println("----- Clienti -----");
        	System.out.println();
        	users2.forEach(user -> System.out.println(user));
        	
        	System.out.println("\nInserisci dati");
        	System.out.println("Inserisci id utente");
        	int iduser=Integer.parseInt(getInput());
        	System.out.println("Inserisci id asset");
        	int idasset=Integer.parseInt(getInput());
        	System.out.println("Inserisci la data di inizio prenotazione(yyyy-mm-gg hh:mm:ss):");
        	orainizio=getInput();
        	
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
        	
        		
        	request = new Request();
            request.put("newUserAsset",new UserAsset(iduser,idasset,orainizio,orafine));
            request.put("choice", "insertUserAsset");
            	
            	
            MainDispatcher.getInstance().callAction("UserAsset", "doControl", request);
            break;
        	
        	case "delete":
            	this.listUserAsset.forEach(userasset -> System.out.println(userasset));
            	//List<User> listUser = userService.getAllUsers();
            	//listUser.forEach(u -> System.out.println(u));
            	System.out.println("Inserisci l'associazione da eliminare:");
                System.out.println("Id user:");
                iduser = Integer.parseInt(getInput());
                System.out.println("inserisci id asset:");
                idasset = Integer.parseInt(getInput());
                System.out.println("inserisci la data di inizio della prenotazione che vuoi eliminare:");
                iddata = getInput();
                
                for(UserAsset ua: listUserAsset) {
                	if(iduser==ua.getIduser() && idasset==ua.getIdasset() && iddata.equals(ua.getOrainizio()))
                	if(!verificaPrenotazioni(ua.getOrainizio())) {
                		System.out.println("La data deve essere maggiore rispetto a quella odierna");
                		request = new Request();
                		request.put("choice","usersAssetsManagement");
                		
                		MainDispatcher.getInstance().callAction("UserAsset", "doControl", request);
                		
                	}
                }
                
        		request = new Request();
        		request.put("delIdUser",iduser);
        		request.put("delIdAsset",idasset);
        		request.put("delIdData", iddata);
        	    request.put("choice", "deleteUserAsset");
        	    MainDispatcher.getInstance().callAction("UserAsset", "doControl", request);
        	    System.out.println("Utente eliminato,ritorno al menu");
            	//userService.deleteUser(username);
            	break;
        	}	
    
        }
    

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
  }

    @Override
    public void submit() {
        MainDispatcher.getInstance().callAction("Home", "doControl", null);
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



/*
private boolean verificaPrenotazioni(String date) {
	
    //MyData dateNow=new MyData(LocalDateTime.now());
    if( LocalDateTime.now().toString().compareTo( date )<0 ){
    	System.out.println("<");	
    	return true;
    }
    if( LocalDateTime.now().toString().compareTo( date )==0 ){
    	System.out.println("==");	
    	return true;
    }
    if( LocalDateTime.now().toString().compareTo( date )>0 ){
    	System.out.println(">");	
    	return true;
    }
    
    return false;
}*/


