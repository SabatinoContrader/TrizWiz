package main.controller;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import main.MainDispatcher;
import main.model.Movimento;
import main.model.User;
import main.service.AssetService;
import main.service.MovimentoService;
import main.service.UserAssetService;
import main.service.UserService;

public class MovimentoController implements Controller {

	private MovimentoService movimentoService;
	private String message;
	private UserAssetService userAssetService;
	private AssetService assetService;
	private WritableFont wfont;
	private WritableFont wc;
	private WritableCellFormat wcfFC;
	private WritableCellFormat wC;
	private UserService userService;
	
    @Override
    public void doControl(Request request)  {
    	this.movimentoService = new MovimentoService();
    	this.message = "";
    	String choice = request.get("choice").toString();
        if (choice != null) {
        	switch (choice) {
            case "movimentiManagement":
            	request.put("visualizzaMovimenti", this.movimentoService.getAllMovimenti());
            	MainDispatcher.getInstance().callView("MovimentoHome", request);
            	break;
            case "insert":
            	request.put("visualizzaMovimenti", this.movimentoService.getAllMovimenti());
                MainDispatcher.getInstance().callView("InsertMovimento", request);
                break;
            case "update":
            	MainDispatcher.getInstance().callView("UpdateMovimento", request);
                break;
            case "delete":
            	request.put("visualizzaMovimenti", this.movimentoService.getAllMovimenti());
                MainDispatcher.getInstance().callView("DeleteMovimento", request);
                break;
            case "export":
            	if (writeOnExcel(request)) {
            		this.message = "Export avvenuto correttamente";
            	}
            	else {
            		this.message = "Errore durante la procedura di export";
            	}
            	request.put("message", this.message);
            	
        		MainDispatcher.getInstance().callView("MovimentiExportHome", request);
                break;
            case "insertMovimento":
            	if (this.movimentoService.insertMovimento((Movimento)request.get("newMovimento"))) {
            		this.message = "Inserimento movimento avvenuto correttamente";
            	}
            	else {
            		this.message = "Errore durante la procedura di inserimento utente";
            	}
            	request.put("message", this.message);
            	request.put("visualizzaMovimenti", this.movimentoService.getAllMovimenti());
        		MainDispatcher.getInstance().callView("MovimentoHome", request);
            	break;
            	
            case "deleteMovimento":
            	if (this.movimentoService.deleteMovimento(Integer.parseInt(request.get("delIdBadgeReader").toString()), Integer.parseInt(request.get("delIdBadge").toString()), request.get("delDatainizio").toString())) {
            		this.message = "Cancellazione movimento avvenuta correttamente";
            	}
            	else {
            		this.message = "Errore durante la procedura di cancellazione movimento";
            	}
            	request.put("message", this.message);
            	request.put("visualizzaMovimenti", this.movimentoService.getAllMovimenti());
        		MainDispatcher.getInstance().callView("MovimentoHome", request);
            	break;
//            case "updateMovimento":
//            	if (this.movimentoService.updateMovimento(request)) {
//            		this.message = "Aggiornamento movimento avvenuto correttamente";
//            	}
//            	else {
//            		this.message = "Errore durante la procedura di aggiornamento movimento";
//            	}
//            	request.put("message", this.message);
//            	request.put("visualizzaMovimenti", this.movimentoService.getAllMovimenti());
//        		MainDispatcher.getInstance().callView("MovimentoHome", request);
//            	break;
            }
        }
        else {
        	MainDispatcher.getInstance().callView("MovimentoHome", null);
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
			if (iduser.equalsIgnoreCase("")) {
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
			}else if (! iduser.equalsIgnoreCase("")) {
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

    
}
