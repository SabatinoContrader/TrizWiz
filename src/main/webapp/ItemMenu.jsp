<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.AmebaDevices.dto.ItemTypeDTO"%>
<%@page import="com.AmebaDevices.dto.ItemDTO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Room Menu</title>
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
<a href="/Room/menu" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	<h1>Room Menu</h1>
	<h2>Qui puoi personalizzare la tua room inserendo degli item scegliendoli dal nosto catalogo</h2>
<% 
		String roomId= request.getParameter("roomId");
		List <ItemTypeDTO> availables = (List <ItemTypeDTO>) request.getAttribute("availableItems");
		List <ItemDTO> yourItems = (List <ItemDTO>) request.getAttribute("yourItems");
%>
	<h2>Item Disponibili </h2>
	 	<div class="thingDiv">
	<table class="thingTable table">
	<tr>
	<th>Aggiungi</th>
	<th>Id: </th>
	<th>Categoria: </th>
	<th>Marca: </th>
	<th>Modello: </th>
	<th>Descrizione: </th>
	<% for (int i=0; i < availables.size(); i++) { %>
		<tr>
			<td align="center"><b><a href="/Item/addInRoom?roomId=<% out.println(roomId); %>&itemId=<% out.println(availables.get(i).getId()); %>">+</a></b></td>	
			<td align="center"><% out.println(availables.get(i).getId()); %></a></td>
			<td align="center"><% out.println(availables.get(i).getCategoria()); %></a></td>
			<td align="center"><% out.println(availables.get(i).getMarca()); %></a></td>
			<td align="center"><% out.println(availables.get(i).getModello()); %></a></td>
			<td align="center"><% out.println(availables.get(i).getDescrizione()); %></a></td>
		</tr>								
	<%}%>
	</table><br>
	</div>
	<h2>I tuoi item </h2>
	<div class="thingDiv">
	<table class="thingTable table">
	<tr>
	<th>Rimuovi</th>
	<th>IdInstallazione: </th>
	<th>Categoria: </th>
	<th>Marca: </th>
	<th>Modello: </th>
	<% for (int k=0; k < yourItems.size(); k++) { %>
		<tr>
			<td align="center"><b><a href="/Item/removeFromRoom?roomId=<% out.println(roomId); %>&itemId=<% out.println(yourItems.get(k).getId()); %>">-</a></b></td>		
			<td align="center"><% out.println(yourItems.get(k).getId()); %></a></td>
			<td align="center"><% out.println(yourItems.get(k).getItemType().getCategoria()); %></a></td>
			<td align="center"><% out.println(yourItems.get(k).getItemType().getMarca()); %></a></td>
			<td align="center"><% out.println(yourItems.get(k).getItemType().getModello()); %></a></td>
		</tr>								
	<%}%>
	</table>
	</div>
	
	<!-- 
		<div>
			<div class="insertDiv">
				<img src="http://www.aa24.it/wp-content/uploads/2015/03/1426101814_add-notes.png"
					class="imgThing"> <a class="customerLink"
					href="/Item/insertForm?roomId=<%=roomId%>"> Aggiungi item </a>
			</div>
		
			<div class="insertDiv">
				<img src="http://icongal.com/gallery/image/43791/edit_notes_delete.png"
					class="imgThing"> <a class="customerLink"
					href="/Item/updateForm?roomId=<%=roomId%>">Modifica item </a>
			</div>
				<div class="insertDiv">
				<img src="https://www.shareicon.net/data/512x512/2015/05/10/36482_delete_512x512.png"
					class="imgThing"> <a class="customerLink"
					href="/Item/deleteForm?roomId=<%=roomId%>"> Elimina item </a>
			</div>
				-->
	</div>

</body>
</html>