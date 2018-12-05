package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.Prodotto;
import com.virtualpairprogrammers.model.Utente;
import com.virtualpairprogrammers.service.ProdottoService;
import com.virtualpairprogrammers.service.RegisterService;

import com.virtualpairprogrammers.dao.AssetDAO;
import com.virtualpairprogrammers.model.Asset;
import com.virtualpairprogrammers.model.BadgeReader;

import com.virtualpairprogrammers.model.Principio; //////////////
import com.virtualpairprogrammers.service.AssetService;
import com.virtualpairprogrammers.service.BadgeReaderService;
import com.virtualpairprogrammers.service.CrudPrincipiService;  ////////////

/**
 * Servlet implementation class PRINCIPI
 */
public class BadgeReaderServlet extends HttpServlet {
	
	private String message;
	//private BadgeReaderService badgeReaderService;
	
	//////////////////////////////////////////////////////////////////////////////////////////
	private CrudPrincipiService CrudPrincipiService;
	private List<Principio> allPrincipio;
	/////////////////////////////////////////////////////////////////////////////////////////
	
	/*private AssetService assetService;
	private List<BadgeReader> allBadgeReader;
	private List<Asset> allAssets;
	*/
    @Override
    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
    	//this.assetService = new AssetService();
    	//this.badgeReaderService = new BadgeReaderService();
    	this.CrudPrincipiService= new CrudPrincipiService();
    	this.message = "";
    	String choice = request.getParameter("richiesta");
        if (choice != null) {
        	switch (choice) {
            case "badgesReaderManagement":
            	this.allPrincipio = this.CrudPrincipiService.getAllPrincipio();
                request.setAttribute("visualizzaBadgeReaders", allPrincipio);
            	getServletContext().getRequestDispatcher("/badgeReaderHome.jsp").forward(request,response);
            	break;
            	
            	//inserimento principio			//////////////////////
            case "insert":
            	response.sendRedirect("insertBadgeReader.jsp");
            	//getServletContext().getRequestDispatcher("/inserBadgereader.jsp").forward(request,response);
                break;
                /////////////////////////////		////////////
            /*    
            case "indietro":
            	this.allBadgeReader = this.badgeReaderService.getAllBadgeReaders();
                request.setAttribute("visualizzaBadgeReaders", allBadgeReader);
            	getServletContext().getRequestDispatcher("/badgeReaderHome.jsp").forward(request,response);
            	break;
            case "indietrohome":
            	response.sendRedirect("homeAsset.jsp");
            	break;
            case "update":
            	int id=Integer.parseInt(request.getParameter("id"));
            	request.setAttribute("id1", id);
            	request.setAttribute("id", this.badgeReaderService.getBadgeReader(id));
            	this.allAssets = this.assetService.getAllAssets();
                request.setAttribute("allAssets", allAssets);
            	getServletContext().getRequestDispatcher("/updateBadgeReader.jsp").forward(request,response);
                break;
            case "delete":
            	getServletContext().getRequestDispatcher("/deleteBadgeReader.jsp").forward(request,response);
                break;
               */
            //insert principio						////////////////////////    
            case "insertBadgeReader":
            	if (request != null) {
                    int id = 0;
                    String nomePrincipio = request.getParameter("nomePrincipio").toString();
                    String nomePrincipioIta = request.getParameter("nomePrincipioIta").toString();
                    String domande = request.getParameter("domande").toString();
                    String steps = request.getParameter("steps").toString();
                    String esempi = request.getParameter("esempi").toString();
                    //int idasset = Integer.parseInt(request.getParameter("idasset").toString());
                    if (CrudPrincipiService.insertPrincipio(new Principio( id,nomePrincipio, nomePrincipioIta,domande,steps,esempi ))) {
                   	 this.allPrincipio = this.CrudPrincipiService.getAllPrincipio();
                   	 request.setAttribute("visualizzaBadgeReaders", this.allPrincipio);
                   	 getServletContext().getRequestDispatcher("/badgeReaderHome.jsp").forward(request,response);
                    } 
                    else {
                        response.sendRedirect("insertBadgeReader.jsp");
                    }
           	}
               break;
               /////////////////////////				/////////////
           
             /*
            case "deleteBadgeReader":
            	if(this.badgeReaderService.deleteBadgeReadear(Integer.parseInt(request.getParameter("delBadgeReader"))))
            		
            		this.message = "Cancellazione asset avvenuto correttamente";
            	else
            		System.out.println("no");
           // this.message = "Errore durante la procedura di cancellazione asset";
            	
            	request.setAttribute("message", this.message);
            	this.allBadgeReader = this.badgeReaderService.getAllBadgeReaders();
                request.setAttribute("visualizzaBadgeReaders", this.allBadgeReader);
            	
            	getServletContext().getRequestDispatcher("/badgeReaderHome.jsp").forward(request,response);
           break;
            	
            	
            	
            case "updateBadgeReader":
               int a=Integer.parseInt(request.getParameter("asset"));
               
               int b=Integer.parseInt(request.getParameter("Badge"));
               
               request.setAttribute("asset", a);
           	request.setAttribute("Badge", b);
                

            	if (badgeReaderService.updateBadgeReader(request)) {
            		this.message = "Aggiornamento asset avvenuto correttamente";
            	}
            	else {
            		this.message = "Errore durante la procedura di aggiornamento asset";
            	}
            	request.setAttribute("message", this.message);
            	request.setAttribute("visualizzaAssets", this.assetService.getAllAssets());
            	request.setAttribute("visualizzaBadgeReaders", this.badgeReaderService.getAllBadgeReaders());
            	getServletContext().getRequestDispatcher("/badgeReaderHome.jsp").forward(request,response);
            	break;
            */}
        	
        	
        	
        }
        else {
        	response.sendRedirect("assetHome.jsp");
        }
    }
	}
	 
	 
	 