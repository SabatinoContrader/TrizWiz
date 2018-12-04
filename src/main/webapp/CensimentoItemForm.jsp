<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<a href="ItemMenu.jsp" class="logout">Indietro</a>
<link rel="stylesheet" href="styles.css">
<jsp:include page="HeaderLogout.jsp"></jsp:include>
<meta charset="ISO-8859-1">
<title>Censimento Item</title>

</head>
<body>
<div class="readCustomer">
		<img src="http://www.aa24.it/wp-content/uploads/2015/03/1426101814_add-notes.png"
			class="imgSuperUser">
	<h1>Item</h1>
	</div>
	<form action="ItemMenu" method="post">
		<table class="insertTable">
		<tr>
			<td> <h2>Marca: </h2></td>
			<td><input type="text" name="marca" placeholder="Inserisci Marca"></td>
		</tr>
		<tr>
			<td> <h2>Modello: </h2></td>
			<td><input type="text" name="modello" placeholder="Inserisci Modello"></td>
		</tr>	
		<tr>
			<td> <h2>Categoria: </h2></td>
			<td><input type="text" name="categoria" placeholder="Inserisci Categoria"></td>
		</tr>
		<tr>
			<td> <h2>Descrizione: </h2></td>
			<td><textarea class="textFont" rows="4" cols="50" name="descrizione" placeholder="Inserisci Descrizione"></textarea></td>
		</tr>
		</table> 
		<h2>
			<button class="censisciButton" type = "submit" value = "Censimento" name = "mode">Censisci</button>
		</h2>
		
		
	</form>
</body>
</html>