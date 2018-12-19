<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link href="/resources/css/styles.css" rel="stylesheet">
<jsp:include page="HeaderLogout.jsp"></jsp:include>
<meta charset="ISO-8859-1">
<title>Triz Consultant Menu</title>
</head>
<body>
	<h1>Seleziona l'operazione che vuoi effettuare</h1>
		<div class="menuDiv">
			<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/delete-user.png "class="imgSuperUser"> 
			<a href="/Macro/menu" class="customerLink">
			Gestione MacroFase 
			</a></br>
		</div>
		<div class="menuDiv">
			<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/delete-user.png "class="imgSuperUser"> 
			<a href="/Item/menu" class="customerLink">
			Gestione Fase
			</a></br>
		</div>
		<div class="menuDiv">
			<img src="https://cdn3.iconfinder.com/data/icons/databases-2-2/512/data_cube-512.png"class="imgSuperUser"> 
			<a href="/Label/menu" class="customerLink">
			Gestione Tool
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
			style="width: 5%; padding-right:2%;"> <a href="Custumer?mode=InsertForm"
			style="font-size: x-large; text-decoration: none">Inserisci nuova Macrofase
			customer </a></br>
	</div>
	<div style="display: flex; align-items: center;">
		<img src="http://simpleicon.com/wp-content/uploads/multy-user.png"
			style="width: 5%; padding-right:2%; "> <a href="Customer?mode=Read"
			style="font-size: x-large; text-decoration: none">Visualizza una Macrofase</a>
	</div>
	</br>
	<div style="display: flex; align-items: center;">
		<img src="http://cdn.onlinewebfonts.com/svg/img_244280.png"
			style="width: 5%; padding-right:2%;"> <a href="Customer?mode=UpdateForm"
			style="font-size: x-large; text-decoration: none">Modifica una Macrofase
			</a>
	</div>
	</br>
	<div style="display: flex; align-items: center;">
		<img src="http://simpleicon.com/wp-content/uploads/remove-user.png"
			style="width: 5%; padding-right:2%;"> <a href="Customer?mode=DeleteForm"
			style="font-size: x-large; text-decoration: none">Elimina una
			Macrofase</a> </br>
	</div>
	<jsp:include page="HeaderLogout.jsp"></jsp:include> -->
</body>
</html>