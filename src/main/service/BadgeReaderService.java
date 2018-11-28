package main.service;

import java.util.List;

import main.controller.Request;
import main.dao.AssetDAO;
import main.dao.BadgeReaderDAO;
import main.model.Asset;
import main.model.BadgeReader;

public class BadgeReaderService {

	private BadgeReaderDAO badgeReaderDAO;

    public BadgeReaderService() {
        this.badgeReaderDAO = new BadgeReaderDAO();
    }

    public List<BadgeReader> getAllBadgeReaders () {
        return this.badgeReaderDAO.getAllBadgeReaders();
    }
    
    public List<BadgeReader> getAllBadgeReadersIdAsset (int idAsset) {
        return this.badgeReaderDAO.getAllBadgeReadersIdAsset(idAsset);
    }

    public boolean insertBadgeReader (BadgeReader badgeReader) {
        return this.badgeReaderDAO.insertBadgeReader(badgeReader);
    }
    public boolean deleteBadgeReadear (int idBadgeReader) {
    	return this.badgeReaderDAO.deleteBadgeReadear(idBadgeReader);
    }
    
    public boolean updateBadgeReader(Request request) {
    	return this.badgeReaderDAO.updateBadgeReader(request);
    }
	
}
