<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.AmebaDevices.dto.ItemTypeDTO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Room Menu</title>
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
<a href="/Installer/goBackSuper" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	<h1>Catalogo degli item</h1>
	<h2 class="things">ItemType </h2>
	 	<div class="thingDiv">
	<table class="thingTable table" style="margin-top:-15%;">
	<tr><th>Id: </th>
	<th>Categoria: </th>
	<th>Descrizione: </th>
	<th>Marca: </th>
	<th>Modello:</th></tr>
	<% List <ItemTypeDTO> item = (List <ItemTypeDTO>) request.getAttribute("items"); for (int i=0; i < item.size(); i++) { %>
		<tr>	<td align="center"><a style="color:white; text-decoration:none" href="/Item/menu"><% out.println(item.get(i).getId()); %></a></td>
							<td align="center"><a style="color:white; text-decoration:none"><% out.println (item.get(i).getCategoria());%></a></td>
							<td align="center"><a style="color:white; text-decoration:none"><% out.println (item.get(i).getDescrizione()); %></a></td>
							<td align="center"><a style="color:white; text-decoration:none"> <% out.println (item.get(i).getMarca()); %></a></td>
							<td align="center"><a style="color:white; text-decoration:none"> <% out.println (item.get(i).getModello()); %></a></td>
		</tr>								
	<%}%>
	</table>
	
		<div>
			<div class="insertDiv">
				<img src="http://www.aa24.it/wp-content/uploads/2015/03/1426101814_add-notes.png"
					class="imgThing"> <a class="customerLink"
					href="/ItemType/insertForm"> Censimento item </a>
			</div>
		<div class="insertDiv">
				<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/notes.png"
					class="imgThing"> <a class="customerLink"
					href="/ItemType/read">Visualizza item </a>
			</div>
			<div class="insertDiv">
				<img src="http://icongal.com/gallery/image/43791/edit_notes_delete.png"
					class="imgThing"> <a class="customerLink"
					href="/ItemType/updateForm">Modifica item </a>
			</div>
				<div class="insertDiv">
				<img src="https://www.shareicon.net/data/512x512/2015/05/10/36482_delete_512x512.png"
					class="imgThing"> <a class="customerLink"
					href="/ItemType/deleteForm"> Elimina item </a>
			</div>
				
		</div>
	</div>

</body>
</html>