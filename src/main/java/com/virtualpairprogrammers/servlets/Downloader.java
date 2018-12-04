package com.virtualpairprogrammers.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.virtualpairprogrammers.model.Building;
import com.virtualpairprogrammers.service.BuildingService;

public class Downloader extends HttpServlet {

    protected void processRequest(String filePath, HttpServletResponse response) 
      throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            File file = new File(filePath);
            FileInputStream inputStream = new FileInputStream(file);
            ServletContext context = getServletContext();
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
    	
    	int buildingId = Integer.parseInt(request.getParameter("buildingId"));
		String type =  request.getParameter("type");
		System.out.println("Sto generando "+type+" relativo al building "+buildingId);
		Building b = new Building();
		BuildingService bs = new BuildingService();
		b = bs.findByPrimaryKey(buildingId);
		switch (type) {
		case "xml":
			//xml 
			System.out.println("entro");
			Document doc = new Document();
			System.out.println(b.getIndirizzo());
			doc.setRootElement(b.getElement());
			XMLOutputter x = new XMLOutputter();
			x.setFormat(Format.getPrettyFormat());
			try {
				File file = new File(b.getIndirizzo()+" interno "+b.getInterno()+".xml");
				System.out.println(file.getAbsolutePath());
				FileWriter fw = new FileWriter(file);
				x.output(doc, fw);
				processRequest(file.getAbsolutePath(), response);
	           
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "csv":
			processRequest(b.buildCSV(), response);
			break;
		}
    	
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		doGet(request,response);
    }
    
}