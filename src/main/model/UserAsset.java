package main.model;

public class UserAsset {

	private int idasset;
	private int iduser;
	private String orainizio;
	private String orafine;
	
    public UserAsset(int iduser,int idasset, String orainizio, String orafine) {
    	this.iduser = iduser;
    	this.idasset = idasset;
    	this.orainizio = orainizio;
        this.orafine = orafine;
    }
    
    public int getIduser() {
    	return iduser;
    	
    }
    public void setIduser(int iduser) {
    this.iduser=iduser;
    
    }
    public int getIdasset() {
    	return idasset;
    	
    }
    public void setIdasset(int idasset) {
    this.idasset=idasset;
    
    }
    public String getOrainizio() {
        return orainizio;
    }

    public void setOrainizio(String orainizio) {
        this.orainizio = orainizio;
    }

    public String getOrafine() {
        return orafine;
    }

    public void setOrafine(String orafine) {
        this.orafine = orafine;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Gomma gomma = (Gomma) o;
//
//        if (Double.compare(gomma.price, price) != 0) return false;
//        if (model != null ? !model.equals(gomma.model) : gomma.model != null) return false;
//        return manufacturer != null ? manufacturer.equals(gomma.manufacturer) : gomma.manufacturer == null;
//    }

//  @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        result = model != null ? model.hashCode() : 0;
//        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
//        temp = Double.doubleToLongBits(price);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        return result;
//    }

    @Override
    public String toString() {
        return "\nIduser:" + iduser + "\nIdasset: " + idasset + "\nOrainizio: " + orainizio + "\nOrafine: " + orafine ;
    }
}
