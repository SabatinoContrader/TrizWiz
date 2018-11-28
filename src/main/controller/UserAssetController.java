package main.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.format.*;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import main.MainDispatcher;
import main.model.UserAsset;
import main.service.AssetService;
import main.service.MovimentoService;
import main.service.UserAssetService;
import main.service.UserService;

public class UserAssetController implements Controller {

	private UserAssetService userAssetService;
	private AssetService assetService;
	private WritableFont wfont;
	private WritableFont wc;
	private WritableCellFormat wcfFC;
	private WritableCellFormat wC;
	private UserService userService;
	private String message;

    @Override
    public void doControl(Request request) {
    	this.userAssetService = new UserAssetService();
    	this.assetService = new AssetService();
    	this.userService = new UserService();
    	this.message = "";

    	String choice = request.get("choice").toString();
        if (choice != null) {
        	switch (choice) {
            case "usersAssetsManagement":
                request.put("visualizzaUtentiAssets", this.userAssetService.getAllUsersAssets());
        		request.put("visualizzaClienti", this.userService.getAllClientiAss());
            	MainDispatcher.getInstance().callView("UserAssetHome", request);
            	break;
            case "insert"://assegna asset ad utente
                request.put("visualizzaAssetsSenzaPrenotazioni", this.assetService.getAllAssetsN());
        		request.put("visualizzaClienti", this.userService.getAllClientiAss());
                request.put("visualizzaUtentiAssets", this.userAssetService.getAllUsersAssets());
                MainDispatcher.getInstance().callView("InsertUserAsset", request);
                break;
            case "delete":
                request.put("visualizzaUtentiAssets", this.userAssetService.getAllUsersAssets());
            	MainDispatcher.getInstance().callView("DeleteUserAsset", request);
                break;
            case "getList":
            	
            	//aggiornaPrenotazioni();
                
                request.put("mode", "getList");
                request.put("visualizzaUtentiAssets", this.userAssetService.getAllUsersAssets());
                MainDispatcher.getInstance().callView("UserAsset", request);
                break;
            case "getList2":
            	//aggiornaPrenotazioni();
                request.put("visualizzaUtentiAssets", this.userAssetService.getAllUsersAssets());
            	break;
            case "getListSenzaPrenotazioni":
                request.put("visualizzaAssetsSenzaPrenotazioni", this.assetService.getAllAssetsN());
            	break;
            case "update":
            	/*
                request.put("mode", "update");
                List<UserAsset> allUserAsset=this.userAssetService.getAllUsersAssets();
                MyData dateNow=new MyData(LocalDateTime.now());
                for(UserAsset ua: allUserAsset) {
                	if( dateNow.compareTo( new MyData(ua.getOrafine()) )>0 ){
                		this.userAssetService.deleteUserAsset(ua.getIduser(), ua.getIdasset());
                	}
                }
                */
//            	request.put("visualizzaUtentiAssets", userAssetService.getAllUsersAssets());
//            	MainDispatcher.getInstance().callView("User", request);
//              break;
            case "insertUserAsset":
            	if (this.userAssetService.insertUserAsset((UserAsset)request.get("newUserAsset"))) {
            		this.message = "Inserimento utente asset avvenuto correttamente";
            	}
            	else {
            		this.message = "Errore durante la procedura di inserimento utente asset";
            	}	
            	request.put("message", this.message);
                request.put("visualizzaUtentiAssets", this.userAssetService.getAllUsersAssets());
                request.put("visualizzaClienti", this.userService.getAllClientiAss());
            	MainDispatcher.getInstance().callView("UserAssetHome", request);
            	break;
            case "deleteUserAsset":
            	int idUser = Integer.parseInt(request.get("delIdUser").toString());
            	int idAsset = Integer.parseInt(request.get("delIdAsset").toString());
            	String idData = request.get("delIdData").toString();
            	if (this.userAssetService.deleteUserAsset(idUser, idAsset, idData)) {
            		this.message = "Cancellazione utente asset avvenuta correttamente";
            	}
            	else {
            		this.message = "Errore durante la procedura di cancellazione utente asset";
            	}	
            	request.put("message", this.message);
                request.put("visualizzaUtentiAssets", this.userAssetService.getAllUsersAssets());
                request.put("visualizzaClienti", this.userService.getAllClientiAss());
            	MainDispatcher.getInstance().callView("UserAssetHome", request);
                break;
            case "export":
            	if (writeOnExcel(request)) {
            		this.message = "Export avvenuto correttamente";
            	}
            	else {
            		this.message = "Errore durante la procedura di export";
            	}
            	request.put("message", this.message);
            	request.put("visualizzaUtentiAssets", this.userAssetService.getAllUsersAssets());
                request.put("visualizzaClienti", this.userService.getAllClientiAss());
        		MainDispatcher.getInstance().callView("UserAssetHome", request);
                break;

//            case "updateUserAsset":
//            	this.userAssetService.updateUserAsset(request);
//            	MainDispatcher.getInstance().callView("UserHome", request);
//                break;
            case "getListUsersAssets":
            	MainDispatcher.getInstance().callView("UserAssetHome", request);
                break;
        	
        	case "userAssetHome":
        		MainDispatcher.getInstance().callView("UserAssetHome", null);
        		break;
        	case "getClienti":
        		request.put("visualizzaClienti", this.userService.getAllClientiAss());
        		break;
        	}
        }
        else {
        	MainDispatcher.getInstance().callView("UserAssetHome", null);
        }
    }
    
    public boolean writeOnExcel(Request request) {
    	String par=request.get("path").toString();
    	String storico=request.get("nome").toString();
    	File f=new File(par+"\\"+storico+".xls");
    	String iduser = request.get("iduser").toString();
    	
		MovimentoService users = new MovimentoService();
		try {
	    	wfont = new WritableFont(WritableFont.createFont("Arial"), 12, WritableFont.BOLD, true,
	        UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.RED);
	    	wc = new WritableFont(WritableFont.createFont("Arial"), 10, WritableFont.NO_BOLD, false,
	    	UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
	    
	        wcfFC = new WritableCellFormat(wfont);
	        wC = new WritableCellFormat(wc);
	   	 	wC.setAlignment(Alignment.CENTRE);
	        wcfFC.setAlignment(Alignment.CENTRE);
	        
	        
			WritableWorkbook myexel = Workbook.createWorkbook(f);
			WritableSheet mysheet = myexel.createSheet("mySheet", 0);
			mysheet.setColumnView(0, 15);
			mysheet.setColumnView(1,15);
			mysheet.setColumnView(2, 20);
			mysheet.setColumnView(3,20);
			Label l=null;
			Label l2=null;
			Label l3=null;
			Label l4=null;
			
			mysheet.addCell(new Label(0,0,"ID User",wcfFC));
			mysheet.addCell(new Label(1,0,"ID Asset",wcfFC));
			mysheet.addCell(new Label(2,0,"Ora Inizio",wcfFC));
			mysheet.addCell(new Label(3,0,"Ora Fine",wcfFC));
			if (iduser == null) {
			for(int i=1; i<=users.getAllMovimenti().size(); i++) {
				for(int j=0; j<4; j++) {
					l=new Label(0,i, String.valueOf(users.getAllMovimenti().get(i-1).getIdbadgereader()),wC );
					l2=new Label(1,i, String.valueOf(users.getAllMovimenti().get(i-1).getIdbadge()),wC );
					l3=new Label(2,i, users.getAllMovimenti().get(i-1).getDatainizio(),wC);
					l4=new Label(3,i, users.getAllMovimenti().get(i-1).getDatafine(),wC);
					mysheet.addCell(l);
					mysheet.addCell(l2);
					mysheet.addCell(l3);
					mysheet.addCell(l4);
				}
			}
			}else if (iduser != null) {
				for(int i=1; i<=users.getAllUserMovimenti(iduser).size(); i++) {
					for(int j=0; j<4; j++) {
						l=new Label(0,i, String.valueOf(users.getAllUserMovimenti(iduser).get(i-1).getIdbadgereader()),wC );
						l2=new Label(1,i, String.valueOf(users.getAllUserMovimenti(iduser).get(i-1).getIdbadge()),wC );
						l3=new Label(2,i, users.getAllUserMovimenti(iduser).get(i-1).getDatainizio(),wC);
						l4=new Label(3,i, users.getAllUserMovimenti(iduser).get(i-1).getDatafine(),wC);
						mysheet.addCell(l);
						mysheet.addCell(l2);
						mysheet.addCell(l3);
						mysheet.addCell(l4);
					}
				}
			
			}
			myexel.write();	
			myexel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
		return true;
    }

	private String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
	}
    
}
