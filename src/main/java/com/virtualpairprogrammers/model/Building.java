package com.virtualpairprogrammers.model;


import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.jdom2.Attribute;
import org.jdom2.Element;

import com.virtualpairprogrammers.service.FloorService;
import com.virtualpairprogrammers.service.RoomService;



public class Building implements Buildable {
	
	private int buildingId;
	private String indirizzo;
	private String citta;
	private String cap;
	private String interno;
	
	// in futuro all'interno di questa classe si prevede di inserire la lista di item
	// associati al building stesso
	
	
	public int getBuildingId() {
		return buildingId;
	}
	
	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String getCitta() {
		return citta;
	}
	
	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	public String getCap() {
		return cap;
	}
	
	public void setCap(String cap) {
		this.cap = cap;
	}
	
	public Building(int buildingId, String indirizzo, String citta, String cap,String interno) {
		this.buildingId = buildingId;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.cap = cap;
		this.interno=interno;
	}
	public Building(String indirizzo, String citta, String cap, String interno) {
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.cap = cap;
		this.interno=interno;
	}
	public Building() {
	}
	
	public void setInterno(String interno) {
		this.interno = interno;
	}

	public String getInterno() {
		// TODO Auto-generated method stub
		return this.interno;
	}

	@Override
	public String getId() {
		return String.valueOf(this.buildingId);
	}

	@Override
	public Element getElement() {
		Element toReturn =new Element(this.getClass().getSimpleName().toLowerCase());
		toReturn.setAttribute(new Attribute("id", this.getId()));
		toReturn.addContent(new Element("indirizzo").setText(this.getIndirizzo()));
		toReturn.addContent(new Element("interno").setText(this.getInterno()));
		toReturn.addContent(new Element("citta").setText(this.getCitta()));
		toReturn.addContent(new Element("cap").setText(this.getCap()));
		Element floorsFather = new Element("floors");
		Element floorsElement;
		FloorService fs = new FloorService();
		if (this.buildingId != 0) {
		List <Floor> floors = fs.getAllByBuilding(this.buildingId);
		for (int i=0 ; i < floors.size(); i++) {
			floorsElement = floors.get(i).getElement();
			floorsFather.addContent(floorsElement);
		} 
		
		toReturn.addContent(floorsFather);
		}
		return toReturn;
		
	}
	
	public String buildCSV() {
		String [] header = {"edificio","interno","citta","cap","floor","", "room", "item"};
		// la struttura del file è fissa. Abbiamo 8 colonne diverse. La prima contiene l'indirizzo dell'edificio
		// la seconda colonna è relativa all'interno
		// la terza contiene la città dell'edificio
		// la quarta contiene il cap
		// La quinta e sesta colonna del file contengono i dati relativi al floor
		// la quinta contiene il nome del floor e la sesta la sua descrizione
		// La settima colonna contiene il nome della room
		// L'ottava (ed eventuali successive) contengono le info sugli item
		// si è pensato per ragioni di ottimizzazione, di "scrivere" le info solo nel momento di cambiamento
		// rispetto alle precedenti (es info sul floor solo nella riga relativa alla prima room di quel floor)
		BufferedWriter bw;
		CSVPrinter csvPrinter = null;
		String path = new File(this.indirizzo + " interno "+this.interno+".csv").getAbsolutePath();
		try {
			bw = Files.newBufferedWriter(Paths.get(path));
			csvPrinter = new CSVPrinter(bw, CSVFormat.DEFAULT.withHeader(header)); 
			csvPrinter.flush();
			
			  	String [] row = new String [8];
			  	row [0] = this.getIndirizzo();
			  	row [1] = this.getInterno();
			  	row [2] = this.getCitta();
			  	row [3] = this.getCap();
				FloorService fs = new FloorService();
				List <Floor> myFloors = fs.getAllByBuilding(this.buildingId);
				for (int i=0 ; i < myFloors.size(); i++) {
					row [4] = myFloors.get(i).getNomeFloor();
					row [5] = myFloors.get(i).getDescrizione();
					RoomService rs = new RoomService();
					List <Room> myRooms = rs.getAllByFloor(Integer.parseInt(myFloors.get(i).getId()));
					for (int k=0 ; k < myRooms.size() ; k++) {
						row[6] = myRooms.get(k).getNomeRoom();
						csvPrinter.printRecord(row);
						csvPrinter.flush();
						row = new String[8];
				//		ItemService is = new ItemService();
				//		List<Item> myItems = is.getAllByRoom(Integer.parseInt(myRooms.get(k).getId()));
						// for sugli item
							// inserimento di dati nel csv
					
						// dato che non abbiamo gli items, stampiamo a livello di rooms				
					}
					if (myRooms.size() == 0){
						// Stampo la riga delle cose relative a building e floor
						csvPrinter.printRecord(row);
						csvPrinter.flush();
						row = new String[8];
					}
				}
				if (myFloors.size() == 0) {
					// Stampo la riga delle cose relative solamente al building
					csvPrinter.printRecord(row);
					csvPrinter.flush();
					row = new String[8];
				}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	
}
