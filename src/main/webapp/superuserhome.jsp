<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">
<jsp:include page="HeaderLogout.jsp"></jsp:include>
<meta charset="ISO-8859-1">
<title>superuserhome</title>
</head>
<body>
	<h1>Seleziona l'operazione che vuoi effettuare</h1>
		<div class="menuDiv">
			<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/delete-user.png "class="imgSuperUser"> 
			<a href="GestioneCustomer" class="customerLink">
			Gestione Customer 
			</a></br>
		</div>
		<div class="menuDiv">
			<img src="https://png2.kisspng.com/show/812fa857dddd93107f5556efc9640d62/L0KzQYm3UcMxN6d2fZH0aYP2gLBuTgRma5lzh954Z4mwdcbqjPllbZJzRehuY4Tygn7wgB9vNZpoh9C2b3awebB7hgJvbaUyh9g2dHjsfrj6TgRma5lzh954Z4mwRbKAUMJmbGU4T6hrMkSxQIq5UsA3OWU2TaMCM0C0RIe3UsI4NqFzf3==/kisspng-technology-euclidean-vector-icon-icon-of-internet-of-things-technology-5a702ed4376b24.092206141517301460227.png" class="imgSuperUser"> 
			<a href="ItemMenu?mode=MainMenu" class="customerLink">
			Gestione Tipologia Item 
			</a></br>	
		</div>
		<div class="menuDiv">
			<img src="https://media.flixcar.com/f360cdn/HP-393556295-c03905319.png"class="imgSuperUser"> 
			<a href="Customer?mode=InsertForm" class="customerLink">
			Gestione Item
			</a></br>	
		</div>
		<div class="menuDiv">
			<img src="https://cdn3.iconfinder.com/data/icons/databases-2-2/512/data_cube-512.png"class="imgSuperUser"> 
			<a href="Thing?operation=home" class="customerLink">
			Gestione Thing
			</a>	
		</div>
		
		
	<!--  <div style="background-color: black" width="195">
		<img
			src="https://contrader.it/wp-content/themes/contrader-it/images/logo_white.svg"
			width="192" alt="15">
	</div>
	<h1>Seleziona l'operazione che vuoi effettuare</h1>
	<div style="display: flex; align-items: center;">
		<img src="http://simpleicon.com/wp-content/uploads/add-user.png"
			style="width: 5%; padding-right:2%;"> <a href="Customer?mode=InsertForm"
			style="font-size: x-large; text-decoration: none">Inserisci nuovo
			customer </a></br>
	</div>
	<div style="display: flex; align-items: center;">
		<img src="http://simpleicon.com/wp-content/uploads/multy-user.png"
			style="width: 5%; padding-right:2%; "> <a href="Customer?mode=Read"
			style="font-size: x-large; text-decoration: none">Visualizza i
			customers</a>
	</div>
	</br>
	<div style="display: flex; align-items: center;">
		<img src="http://cdn.onlinewebfonts.com/svg/img_244280.png"
			style="width: 5%; padding-right:2%;"> <a href="Customer?mode=UpdateForm"
			style="font-size: x-large; text-decoration: none">Modifica un
			customer</a>
	</div>
	</br>
	<div style="display: flex; align-items: center;">
		<img src="http://simpleicon.com/wp-content/uploads/remove-user.png"
			style="width: 5%; padding-right:2%;"> <a href="Customer?mode=DeleteForm"
			style="font-size: x-large; text-decoration: none">Elimina un
			customer</a> </br>
	</div>
	<jsp:include page="HeaderLogout.jsp"></jsp:include> -->
</body>
</html>