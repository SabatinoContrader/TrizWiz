package main.service;

import main.dao.BadgeDAO;
//import main.dao.BadgereaderDAO;
import main.dao.MovimentoDAO;
import main.model.Badge;
import main.model.Movimento;

import java.util.List;

public class MovimentoService {

    private MovimentoDAO movimentoDAO;
	private Object badgeDAO;
	private Object badgereaderDAO;

    public MovimentoService() {
        this.movimentoDAO = new MovimentoDAO();
    }
    public List<Badge> getAllBadges () {
        return ((BadgeDAO) this.badgeDAO).getAllBadges();
    }
    public List<Movimento> getAllMovimenti () {
        return this.movimentoDAO.getAllMovimenti();
    }
    public List<Movimento> getAllUserMovimenti (String iduser) {
        return this.movimentoDAO.getAllUserMovimenti(iduser);
    }
  /*  public List<BadgeReader> getAllBadgeReaders () {
        return (((BadgeReaderDAO) this.badgeReaderDAO).getBadgeReaders());
    }
*/
    public boolean insertMovimento (Movimento movimento) {
        return this.movimentoDAO.insertMovimento(movimento);
    }
    
    public boolean deleteMovimento (int idBadgeReader, int idBadge, String datainizio) {
        return this.movimentoDAO.deleteMovimento(idBadgeReader, idBadge, datainizio);
    }
    
    public boolean updateMovimento (int idBadgeReader, int idBadge, String dataInizio, String dataFine) {
    	return this.movimentoDAO.udpateMovimento(idBadgeReader, idBadge, dataInizio, dataFine);
    }
    
}
