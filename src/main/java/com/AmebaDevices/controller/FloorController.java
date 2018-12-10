package com.AmebaDevices.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.AmebaDevices.dto.BuildingDTO;
import com.AmebaDevices.dto.FloorDTO;
import com.AmebaDevices.services.BuildingService;
import com.AmebaDevices.services.FloorService;




@Controller
@RequestMapping("/Floors")
public class FloorController {
	
	private FloorService fs;
	private BuildingService bs;
	
	@Autowired 
	public FloorController (FloorService fs, BuildingService bs) {
		this.fs = fs;
		this.bs = bs;
	}
	
	private void processRequest(String filePath, HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		        try {
		            response.setContentType("text/html;charset=UTF-8");
		            File file = new File(filePath);
		            FileInputStream inputStream = new FileInputStream(file);
		            ServletContext context = request.getServletContext();
		            String mimeType = context.getMimeType(filePath);
		            if (mimeType == null) {
		                mimeType = "application/octet-stream";
		            }
		            response.setContentType(mimeType);
		            response.setContentLength((int) file.length());
		            // forziamo il download del file
		            String headerKey = "Content-Disposition";
		            String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
		            response.setHeader(headerKey, headerValue);
		            OutputStream outputStream = response.getOutputStream();
		            byte[] buffer = new byte[4096];
		            int bytesRead = -1;
		            while ((bytesRead = inputStream.read(buffer)) != -1) {
		                outputStream.write(buffer, 0, bytesRead);
		            }
		            inputStream.close();
		            outputStream.close();
		        } catch (Exception e) {
		            //gestiamo eventuali errori come file non esistente
		        }
		    }


	
	@RequestMapping(value = "/insertForm", method = RequestMethod.GET)
	public String insertForm(HttpServletRequest request) {
		int buildingId = Integer.parseInt(request.getParameter("buildingId"));
		request.setAttribute("buildingId", String.valueOf(buildingId));
		return "newFloor";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		long buildingId = Long.parseLong(request.getParameter("buildingId"));
		request.setAttribute("buildingId", String.valueOf(buildingId));
		String name = request.getParameter("floorName");
		String description = request.getParameter("floorDescription");
		FloorDTO f = new FloorDTO();
		f.setNomeFloor(name);
		f.setDescrizione(description);
		this.fs.insertFloor(f, buildingId);
		request.setAttribute("buildingId", String.valueOf(buildingId));
		List<FloorDTO> alreadyExisting = new ArrayList<>();
		alreadyExisting = this.fs.getAllByBuilding(buildingId);
		request.setAttribute("floors", alreadyExisting);
		return "floorManager";
	}

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(HttpServletRequest request) {
		long buildingId = Long.parseLong(request.getParameter("buildingId"));
		request.setAttribute("buildingId", String.valueOf(buildingId));
		List<FloorDTO> alreadyExisting = new ArrayList<>();
		alreadyExisting = this.fs.getAllByBuilding(buildingId);
		request.setAttribute("floors", alreadyExisting);
		return "floorManager";
	}

	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm(HttpServletRequest request) {
		long buildingId = Long.parseLong(request.getParameter("buildingId"));
		request.setAttribute("buildingId", String.valueOf(buildingId));
		List<FloorDTO> alreadyExisting = new ArrayList<>();
		alreadyExisting = fs.getAllByBuilding(buildingId);
		request.setAttribute("floors", alreadyExisting);
		request.setAttribute("buildingId", buildingId);
		return "updateFloor";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		String newName = request.getParameter("floorName");
		String newDescription = request.getParameter("floorDescription");
		String buildingid = (String) request.getParameter("buildingId");
		String floorId = request.getParameter("floorid");
		System.out.println(floorId + " "+newName+" "+newDescription+" "+buildingid);
		FloorDTO newFloor = new FloorDTO();
		newFloor.setId(Integer.parseInt(floorId));
		newFloor.setNomeFloor(newName);
		newFloor.setDescrizione(newDescription);
		fs.update(newFloor, Long.parseLong(buildingid));
		long buildingId = Long.parseLong(request.getParameter("buildingId"));
		request.setAttribute("buildingId", String.valueOf(buildingId));
		List<FloorDTO> alreadyExisting = new ArrayList<>();
		alreadyExisting = fs.getAllByBuilding(buildingId);
		request.setAttribute("floors", alreadyExisting);
		return "floorManager";
	}

	@RequestMapping(value = "/deleteForm", method = RequestMethod.GET)
	public String deleteForm(HttpServletRequest request) {
		int buildingId = Integer.parseInt(request.getParameter("buildingId"));
		request.setAttribute("buildingId", String.valueOf(buildingId));
		List<FloorDTO> alreadyExisting = new ArrayList<>();
		alreadyExisting = fs.getAllByBuilding(buildingId);
		request.setAttribute("floors", alreadyExisting);
		return "deleteFloor";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("floorid"));
		fs.deleteById(id);
		
		int buildingId = Integer.parseInt(request.getParameter("buildingId"));
		request.setAttribute("buildingId", String.valueOf(buildingId));
		List<FloorDTO> alreadyExisting = new ArrayList<>();
		alreadyExisting = fs.getAllByBuilding(buildingId);
		request.setAttribute("floors", alreadyExisting);
		return "floorManager";
	}
	
	
	
	@RequestMapping (value = "/download", method = RequestMethod.GET)
	public String download(HttpServletRequest request, HttpServletResponse response) {
    	Long buildingId = Long.parseLong(request.getParameter("buildingId"));
    	BuildingDTO current = bs.findByPrimaryKey(buildingId);
		String type =  request.getParameter("type");
		switch (type) {
		case "xml":
			//xml 
			System.out.println("entro");
			Document doc = new Document();
			doc.setRootElement(bs.getElement(current));
			XMLOutputter x = new XMLOutputter();
			x.setFormat(Format.getPrettyFormat());
			try {
				File file = new File(current.getAddress()+" interno "+current.getInterno()+".xml");
				System.out.println(file.getAbsolutePath());
				FileWriter fw = new FileWriter(file);
				x.output(doc, fw);
				processRequest(file.getAbsolutePath(), request, response);
	           
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "csv":
			try {
				processRequest(bs.buildCSV(current), request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		return "floorManager";
	}

	
}
