<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Items</title>
<link href="/resources/css/styles.css" rel="stylesheet"> 
	<a href="/Item/menu" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
<div class="readCustomer">
		<img src="http://icongal.com/gallery/image/43791/edit_notes_delete.png"
			class="itemSizeImg">
	<h1>Modifica Items</h1>
	
	</div>	
		<form class="itemForm" action = "/Item/update" method = "POST">
		<table>
		<tr>
			<td> <h2>Id: </h2></td>
			<td> <input type = "text" name = "id"  placeholder="Inserisci id"> </td>				
		</tr>
		<tr>
			<td> <h2>ConsumoEnergetico: </h2></td>
			<td> <input type = "text" name = "consumoEnergetico" placeholder="Inserisci consumo energetico dell'item"> </td>				
		</tr>
		<tr>
			<td> <h2>Seriale: </h2></td>
			<td> <input type = "text" name = "seriale"  placeholder="Inserisci seriale"> </td>				
		</tr>
		</table>
         	<p><button class = "loginButton" type = "submit" >Modifica</button></p>
         	<input type="hidden" name="roomId" value=<%=request.getParameter("roomId")%> >
    	</form>
	
</body>
</html>