<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.virtualpairprogrammers.model.Floor"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Floors</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>

	<table class="thingTable table" style="margin-top:-15%;">
	<tr><th>Id: </th>
	<th>Nome: </th>
	<th>Descrizione: </th>
	<th>IdBuilding: </th></tr>
	<% 
										List<Floor> floors = (List<Floor>) request.getAttribute("floors");

										for (int i=0; i < floors.size(); i++) {
									%><tr>	<td align="center"><a style="color:white; text-decoration:none" href="RoomServlet?richiesta=home&floorId=<% out.println(floors.get(i).getId()); %>"><% out.println(floors.get(i).getId()); %></a></td>
											<td align="center"><a style="color:white; text-decoration:none" href="RoomServlet?richiesta=home&floorId=<% out.println(floors.get(i).getId()); %>"><% out.println(floors.get(i).getNomeFloor()); %></a></td>
											<td align="center"><a style="color:white; text-decoration:none" href="RoomServlet?richiesta=home&floorId=<% out.println(floors.get(i).getId()); %>"><% out.println(floors.get(i).getDescrizione()); %></a></td>
											<td align="center"><a style="color:white; text-decoration:none" href="RoomServlet?richiesta=home&floorId=<% out.println(floors.get(i).getId()); %>"><% out.println(floors.get(i).getIdBuilding()); %></a></td>
									</tr>
									
	<%} %>
	</table>
</body>
</html>