package com.AmebaDevices.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.AmebaDevices.dto.BuildingDTO;
import com.AmebaDevices.dto.CustomerDTO;
import com.AmebaDevices.services.BuildingService;
import com.AmebaDevices.services.CustomerService;

@Controller
@RequestMapping("/Installer")
public class InstallerController {
	
	
	
	private CustomerService customerService;
	private BuildingService buildingService;

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


	
	
	@Autowired
	public InstallerController(CustomerService customerService, BuildingService buildingService) {
		this.buildingService = buildingService;
		this.customerService = customerService;
	}

	@RequestMapping(value = "/insertForm", method = RequestMethod.GET)
	public String insertForm(HttpServletRequest request) {
		return "insertInstaller";
	}

	@RequestMapping(value = "/goBackSuper", method = RequestMethod.GET)
	public String goBackSuper(HttpServletRequest request) {
		return "superuserhome";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		CustomerDTO customer = new CustomerDTO();
		customer.setNome(request.getParameter("nome"));
		customer.setCognome(request.getParameter("cognome"));
		customer.setDataNascita(request.getParameter("dataDiNascita").toString());
		customer.setEmail(request.getParameter("email"));
		customer.setUsername(request.getParameter("username"));
		customer.setPassword(request.getParameter("password"));
		customer.setUserRole(3);
		customerService.insertCustomer(customer);
		return "InstallerMenu";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(HttpServletRequest request, Model model) {
		List<CustomerDTO> installers = customerService.readInstallers();
		model.addAttribute("installers", installers);
		return "readInstaller";
	}

	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm(HttpServletRequest request) {
		List<CustomerDTO> installers = customerService.readInstallers();
		request.setAttribute("customers", installers);
		return "UpdateInstaller";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("idselected"));
		long l = id;
		CustomerDTO newcustomer = customerService.searchCustomer(l);
		switch (Integer.parseInt(request.getParameter("selected"))) {
		case 1:
			newcustomer.setNome(request.getParameter("value"));
			break;
		case 2:
			newcustomer.setCognome(request.getParameter("value"));
			break;
		case 3:
			newcustomer.setDataNascita(request.getParameter("value"));
			break;
		case 4:
			newcustomer.setUsername(request.getParameter("value"));
			break;
		case 5:
			newcustomer.setPassword(request.getParameter("value"));
			break;
		default:
			break;
		}
		customerService.updateCustomer(newcustomer);
		return "InstallerMenu";
	}

	@RequestMapping(value = "/associazioneMenu", method = RequestMethod.POST)
	public String updateAssociations(HttpServletRequest request) {
		List<BuildingDTO> buildings = buildingService.findAll();
		for (int i = 0; i < buildings.size(); i++) {
			String s1 = (String) request.getParameter(String.valueOf(buildings.get(i).getId()));
			if (s1 != null) {
				long idselected = Long.parseLong(request.getParameter("idselected"));
				System.out.println("id selected: " + idselected);
				CustomerDTO c = customerService.searchCustomer(idselected);
				buildings.get(i).setInstaller(c);
				buildingService.update(buildings.get(i));
			}
		}

		return "InstallerMenu";
	}

	@RequestMapping(value = "/deleteForm", method = RequestMethod.GET)
	public String deleteForm(HttpServletRequest request) {
		List<CustomerDTO> installers = customerService.readInstallers();
		request.setAttribute("installers", installers);
		return "deleteInstaller";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		int idDelete = Integer.parseInt(request.getParameter("idselected"));
		long l = idDelete;
		customerService.deleteCustomer(l);
		return "InstallerMenu";
	}

	@RequestMapping(value = "/goBack", method = RequestMethod.GET)
	public String goBack(HttpServletRequest request) {
		return "InstallerMenu";
	}

	@RequestMapping(value = "/associazioneBuildings", method = RequestMethod.GET)
	public String associaBuildings(HttpServletRequest request) {
		List<BuildingDTO> buildings = buildingService.findAll();
		for (int i = 0; i < buildings.size(); i++) {
			if (buildings.get(i).getInstaller() != null) {
				buildings.remove(i);
				i--;
			}
		}
		List<CustomerDTO> installers = customerService.readInstallers();
		request.setAttribute("buildings", buildings);
		System.out.println(buildings.size());
		request.setAttribute("installers", installers);
		return "associazioneBuildings";
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void customerControl(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void customer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
	}
	
	@RequestMapping (value = "/download", method = RequestMethod.GET)
	public String download(HttpServletRequest request, HttpServletResponse response) {
    	Long buildingId = Long.parseLong(request.getParameter("buildingId"));
    	BuildingDTO current = buildingService.findByPrimaryKey(buildingId);
		String type =  request.getParameter("type");
		switch (type) {
		case "xml":
			//xml 
			System.out.println("entro");
			Document doc = new Document();
			doc.setRootElement(buildingService.getElement(current));
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
				processRequest(buildingService.buildCSV(current), request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		List <BuildingDTO> buildings = buildingService.findByInstaller((String) request.getSession().getAttribute("username"));
		CustomerDTO cDTO = customerService.findByUsername((String) request.getSession().getAttribute("username"));
		request.setAttribute("installer", cDTO);
		request.setAttribute("buildings", buildings);
		return "installerHome";
	}
	
	@RequestMapping(value = "fileGenerator", method = RequestMethod.POST)
	public String fileGenerator(HttpServletRequest request) {
		long myId = Long.parseLong(request.getParameter("idInstaller"));
		List<BuildingDTO> myBuildings = buildingService.findAll();
		for (int i=0; i < myBuildings.size() ; i++) {
			if (myBuildings.get(i).getInstaller().getId() != myId) {
				myBuildings.remove(i);
				i--;
			}
		}
		request.setAttribute("idInstaller", myId);
		request.setAttribute("myBuildings", myBuildings);
		return "scegliBuilding";
		
	}
}
