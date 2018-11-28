package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.controller.Request;
import main.model.Asset;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssetDAO {

	String param="";
	
    private final String QUERY_ALL = "select * from asset";
    private final String QUERY_INSERT = "insert into asset (tipo,prezzo,descrizione) values (?,?,?)";
    private final String QUERY_DEL = "delete from asset where idasset = ?";
    private final String QUERY_ALLUSERASSN = "select b.idasset,tipo,prezzo,descrizione from userasset as o right join asset as b on o.idasset=b.idasset where o.idasset is null";

    public AssetDAO() {

    }

    public List<Asset> getAllAssets () {
        List<Asset> assets = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
        	   int id = resultSet.getInt("idasset");
        	   String tipo = resultSet.getString("tipo");
        	   double prezzo = resultSet.getDouble("prezzo");
               String descrizione = resultSet.getString("descrizione");
               assets.add(new Asset(id,tipo,prezzo,descrizione));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return assets;
    }
    public List<Asset> getAllAssetsN () {
        List<Asset> assets = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALLUSERASSN);
           while (resultSet.next()) {
        	   int id = resultSet.getInt("idasset");
        	   String tipo = resultSet.getString("tipo");
        	   double prezzo = resultSet.getDouble("prezzo");
               String descrizione = resultSet.getString("descrizione");
               assets.add(new Asset(id,tipo,prezzo,descrizione));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return assets;
    }
    public boolean insertAsset(Asset asset) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, asset.getTipo());
            preparedStatement.setDouble(2, asset.getPrezzo());
            preparedStatement.setString(3, asset.getDescrizione());
            preparedStatement.execute();
            return true;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    public boolean DeleteAsset(int idasset) {
    	Connection connection = ConnectionSingleton.getInstance();
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DEL);
            preparedStatement.setInt(1,idasset);
            preparedStatement.execute();
            return true;
    }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }	
    }
    
    public boolean UpdateAsset(Request request) {
    	 Connection connection = ConnectionSingleton.getInstance();
         try {
         	 param=(String)request.get("campo");
         	 PreparedStatement preparedStatement = connection.prepareStatement("update asset set "+param+"=? where idasset=?");
             preparedStatement.setString(1, (String)request.get("newData"));
             preparedStatement.setInt(2, (Integer)request.get("idAsset"));
             preparedStatement.execute();
             return true;
         }
         catch (SQLException e) {
             GestoreEccezioni.getInstance().gestisciEccezione(e);
             return false;
         }
    	
    }
}
