package main.service;

import main.dao.VparametriDAO;
import main.model.Parametri;
import java.util.List;

public class VparametriService {
	private VparametriDAO VparametriDAO;
	  public List<Parametri> getAllParametri () {
	        return this.VparametriDAO.getAllParametri();
	    }
	
	
	
	
	/*
    private List<Parametri> listParametri;


    public void visualizza () {
    	this.listParametri= (List<Parametri>) this.VparametriDAO.get(visualizza());
    	System.out.println();
    	System.out.println();
        System.out.println("----- LISTA Parametri -----");
        System.out.println();
        System.out.format("+----------+-----------------------+------------+-----------------+-------------------+---------+%n");
        System.out.format("| ID       | nomeParametro         | descrizione| nomeParametroIta| descrizioneIta    | icona   |%n");
        System.out.format("+----------+-----------------------+------------+-----------------+-------------------+---------+%n");
		String leftAlignFormat2 ="| %-8s | %-21s | %-10s | %-10s | %-10s |%n";
		for (Parametri report : this.listParametri) {
			int id = report.getId();
            String np = report.getnomeParametro();
			String ds = report.getdescrizione();
			String npt = report.getnomeParametroIta();
			String di = report.getdescrizioneIta();
			String ic = report.geticona();
            
            try{
            	System.out.format(leftAlignFormat2, id ,np,ds,npt,di,ic);
            }catch (Exception e) {
				// TODO: handle exception
			}
            System.out.format("+----------+-----------------------+------------+------------+------------+------------+-------------------------------+--------------------+----------------+%n");

		}

    }*/
    
}
