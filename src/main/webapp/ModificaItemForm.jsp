<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Items</title>
<link rel="stylesheet" href="styles.css">
	<a href="ItemMenu.jsp" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
<div class="readCustomer">
		<img src="http://icongal.com/gallery/image/43791/edit_notes_delete.png"
			class="itemSizeImg">
	<h1>Modifica Items</h1>
	
	</div>	
		<form class="itemForm" action = "ItemMenu" method = "POST">
		<table>
		<tr>
			<td> <h2>Id: </h2></td>
			<td> <input type = "text" name = "id"  placeholder="Inserisci id"> </td>				
		</tr>
		<tr>
			<td> <h2>Marca: </h2></td>
			<td> <input type = "text" name = "marca" placeholder="Inserisci marca"> </td>				
		</tr>
		<tr>
			<td> <h2>Modello: </h2></td>
			<td> <input type = "text" name = "modello"  placeholder="Inserisci modello"> </td>				
		</tr>
		<tr>
			<td> <h2>Categoria: </h2></td>
			<td> <input type = "text" name = "categoria"  placeholder="Inserisci categoria"> </td>				
		</tr>
		<tr>
			<td> <h2>Descrizione: </h2></td>
			<td>  <textarea class="textFont" rows="4" cols="50" name="descrizione" placeholder="Inserisci descrizione"></textarea> </td>				
		</tr>
		</table>
         	<p><button class = "loginButton" type = "submit" value = "Modifica" name = "mode">Modifica</button></p>
    	</form>
	
</body>
</html>