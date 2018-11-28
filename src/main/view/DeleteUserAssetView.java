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

public class DeleteUserAssetView implements View{

    private Request request;
    private int iduser;
    private int idasset;
    private String iddata;
    private List<UserAsset> listUserAsset;

    public DeleteUserAssetView () {

    }

    @Override
    public void showResults(Request request) {
       this.request = request;
       this.listUserAsset = (List<UserAsset>) request.get("visualizzaUtentiAssets");
    }

    @Override
    public void showOptions() {    	
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
        
        this.request = new Request();
        this.request.put("delIdUser",iduser);
        this.request.put("delIdAsset",idasset);
        this.request.put("delIdData", iddata);
        this.request.put("choice", "deleteUserAsset");
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
