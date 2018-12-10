<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<link href="/resources/css/styles.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Installer Home</title>
<a href="/Installer/goBackSuper" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	<h1>Seleziona l'operazione che vuoi effettuare</h1>
	<div class="insertDiv">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/add-user.png"
			class="imgSuperUser" > <a href="/Installer/insertForm"
			class="customerLink">Inserisci nuovo
			Installer </a>
	</div>
	<div class="insertDiv">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/user.png"
			class="imgSuperUser"> <a href="/Installer/read"
			class="customerLink">Visualizza Installer</a>
	</div>
	<div class="insertDiv">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/edit-user.png"
			class="imgSuperUser"> <a href="/Installer/updateForm"
			class="customerLink">Modifica un
			Installer</a>
	</div>
	<div class="insertDiv">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/delete-user.png"
			class="imgSuperUser"> <a href="/Installer/deleteForm"
			class="customerLink">Elimina un
			Installer</a> 
	</div> 
	<div class="insertDiv">
		<img src="https://www.ccv.eu/ch-it/wp-content/uploads/sites/15/2018/03/Connect-logo-gross.png"
			class="imgSuperUser" > <a href="/Installer/associazioneBuildings"
			class="customerLink">Assegna i buildings </a>
	</div>
	<div class="insertDiv">
		<img src="https://www.ccv.eu/ch-it/wp-content/uploads/sites/15/2018/03/Connect-logo-gross.png"
			class="imgSuperUser" > <a href="/Installer/fileGenerator
			class="customerLink">Genera CSV/XML </a>
	</div>
</body>
</html>
