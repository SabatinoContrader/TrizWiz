package main.controller;

import main.MainDispatcher;
import main.model.Asset;
import main.model.BadgeReader;
import main.service.AssetService;
import main.service.BadgeReaderService;

public class BadgeReaderController implements Controller{

	private String message;
	private BadgeReaderService badgeReaderService;
	private AssetService assetService;
	
    @Override
    public void doControl(Request request) {
    	this.assetService = new AssetService();
    	this.badgeReaderService = new BadgeReaderService();
    	this.message = "";
    	String choice = request.get("choice").toString();
        if (choice != null) {
        	switch (choice) {
            case "badgesReaderManagement":
            	
            	request.put("visualizzaAssets", this.assetService.getAllAssets());
            	request.put("visualizzaBadgeReaders", this.badgeReaderService.getAllBadgeReaders());
            	MainDispatcher.getInstance().callView("BadgeReaderHome", request);
            	break;
            	
            case "insert":
            	request.put("message", this.message);
            	request.put("visualizzaAssets", this.assetService.getAllAssets());
            	request.put("visualizzaBadgeReaders", this.badgeReaderService.getAllBadgeReaders());
                MainDispatcher.getInstance().callView("InsertBadgeReader", request);
                break;
            case "update":
                MainDispatcher.getInstance().callView("UpdateBadgeReader", request);
                break;
            case "delete":
                MainDispatcher.getInstance().callView("DeleteBadgeReader", request);
                break;
            case "insertBadgeReader":
            	if (this.badgeReaderService.insertBadgeReader((BadgeReader)request.get("newBadgeReader"))) {
            		this.message = "Inserimento BadgeReader avvenuto correttamente";
            	}
            	else {
            		this.message = "Errore durante la procedura di inserimento asset";
            	}
            	request.put("message", this.message);
            	request.put("visualizzaAssets", this.assetService.getAllAssets());
            	request.put("visualizzaBadgeReaders", this.badgeReaderService.getAllBadgeReaders());
            	MainDispatcher.getInstance().callView("BadgeReaderHome", request);
            	break;
            case "deleteBadgeReader":
            	if (this.badgeReaderService.deleteBadgeReadear((Integer) request.get("delBadgeReader"))) {
            		this.message = "Cancellazione asset avvenuto correttamente";
            	}
            	else {
            		this.message = "Errore durante la procedura di cancellazione asset";
            	}
            	request.put("message", this.message);
            	request.put("visualizzaAssets", this.assetService.getAllAssets());
            	request.put("visualizzaBadgeReaders", this.badgeReaderService.getAllBadgeReaders());
            	MainDispatcher.getInstance().callView("BadgeReaderHome", request);
            	break;
            	
            	
            	
            case "updateBadgeReader":
            	if (badgeReaderService.updateBadgeReader(request)) {
            		this.message = "Aggiornamento asset avvenuto correttamente";
            	}
            	else {
            		this.message = "Errore durante la procedura di aggiornamento asset";
            	}
            	request.put("message", this.message);
            	request.put("visualizzaAssets", this.assetService.getAllAssets());
            	request.put("visualizzaBadgeReaders", this.badgeReaderService.getAllBadgeReaders());
            	MainDispatcher.getInstance().callView("BadgeReaderHome", request);
            	break;
            }
        	
        	
        	
        }
        else {
        	MainDispatcher.getInstance().callView("AssetHome", null);
        }
    }
	
}
