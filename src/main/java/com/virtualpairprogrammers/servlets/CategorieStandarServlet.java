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

import com.virtualpairprogrammers.model.CategorieStandard; //////////////
import com.virtualpairprogrammers.service.AssetService;
import com.virtualpairprogrammers.service.BadgeReaderService;
import com.virtualpairprogrammers.service.CrudCategorieStandardService;  ////////////

/**
 * Servlet implementation class categorie standard
 */
public class CategorieStandarServlet extends HttpServlet {
	
	private String message;
	
	//////////////////////////////////////////////////////////////////////////////////////////
	private CrudCategorieStandardService CrudCategorieStandardService;
	private List<CategorieStandard> allCategorieStandard;
	/////////////////////////////////////////////////////////////////////////////////////////
	@Override
    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
    	//this.assetService = new AssetService();
    	//this.badgeReaderService = new BadgeReaderService();
    	this.CrudCategorieStandardService= new CrudCategorieStandardService();
    	this.message = "";
    	String choice = request.getParameter("richiesta");
        if (choice != null) {
        	switch (choice) {
        	
            case "VisualizzaCat":
            	this.allCategorieStandard = this.CrudCategorieStandardService.getAllCategorieStandard();
                request.setAttribute("visualizzaCategorieStandard", allCategorieStandard);
            	getServletContext().getRequestDispatcher("/CategorieStandardSelect.jsp").forward(request,response);
            	break;
            	
            case "vprincipi":

        		//response.sendRedirect("homePrincipi.jsp");

        		getServletContext().getRequestDispatcher("/homePrincipi.jsp").forward(request,response);

        		break;
            	
            	
            case "inserisciCategoria":

            	//response.sendRedirect("insertBadgeReader.jsp");

            	getServletContext().getRequestDispatcher("/insertCategoria.jsp").forward(request,response);

                break;

                

            case "insert":
             if (request != null) {

                    int id = 0;

                    String nome = request.getParameter("nome").toString();

                    String nomeIng = request.getParameter("nomeIng").toString();

                    //int categoria = Integer.parseInt(request.getParameter("categoria").toString());

                    //int idasset = Integer.parseInt(request.getParameter("idasset").toString());

                    if (CrudCategorieStandardService.insertCategorieStandard(new CategorieStandard( id,nome, nomeIng))) {

                   	 this.allCategorieStandard = this.CrudCategorieStandardService.getAllCategorieStandard();

                   	 request.setAttribute("visualizzaCategorieStandard", this.allCategorieStandard);

                   	 getServletContext().getRequestDispatcher("/inserisciCat.jsp").forward(request,response);

                    } 

                    else {

                        response.sendRedirect("insertBadgeReader.jsp");

                    }

           	}

               break;
                
            case "Indietro":
            	//getServletContext().getRequestDispatcher("/homeAsset.jsp").forward(request,response);
                
            	response.sendRedirect("homeCustomers.jsp");
            	//getServletContext().getRequestDispatcher("/inserBadgereader.jsp").forward(request,response);
                break;    
                
           
                
                /////////////////////////////		////////////
            case "delete":
            	this.allCategorieStandard = this.CrudCategorieStandardService.getAllCategorieStandard();
                request.setAttribute("visualizzaCategorieStandard", allCategorieStandard);
            	getServletContext().getRequestDispatcher("/deliteCategoria.jsp").forward(request,response);
            break;
            
            	
           
            case "deleteID":
            	if(this.CrudCategorieStandardService.deleteCategorieStandard(Integer.parseInt(request.getParameter("id")))){
            		this.allCategorieStandard = this.CrudCategorieStandardService.getAllCategorieStandard();
                    request.setAttribute("visualizzaCategorieStandard", allCategorieStandard);
                	getServletContext().getRequestDispatcher ("/deliteCategoria.jsp").forward(request,response);}
            	else {
            		response.sendRedirect("home.jsp");
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
            	
            	*/
            	
            case "aggiornaID":

    	    	if (request != null) {

    	    		int id = Integer.parseInt(request.getParameter("id").toString());

                    String nome = request.getParameter("nome").toString();

                    String nomeIng = request.getParameter("nomeIng").toString();

                  //  int categoria = Integer.parseInt(request.getParameter("categoria").toString());


                    if (CrudCategorieStandardService.updateCategorieStandard(new CategorieStandard( id,nome,nomeIng ))) {

                   	 this.allCategorieStandard = this.CrudCategorieStandardService.getAllCategorieStandard();

                   	 request.setAttribute("visualizzaCategorieStandard", this.allCategorieStandard);

                   	 getServletContext().getRequestDispatcher("/inserisciCat.jsp").forward(request,response);

                    } 

                    else {

                        response.sendRedirect("insertBadgeReader.jsp");

                    }

           	}	

             break;

           	

    	    

    	    case "aggiornaCat": //da implementare

    	    	this.allCategorieStandard = this.CrudCategorieStandardService.getAllCategorieStandard();

                request.setAttribute("visualizzaCategorieStandard", allCategorieStandard);

            	getServletContext().getRequestDispatcher("/AggiornaCategoria.jsp").forward(request,response);

            break;
        	
        	
        }/*
        else {
        	response.sendRedirect("assetHome.jsp");
        	*/
        }
    
	}
	}
	 
	 
	 