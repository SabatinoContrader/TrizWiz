<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">
<meta charset="ISO-8859-1">
<title>Customer Home</title>
<a href="superuserhome.jsp" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	<h1>Seleziona l'operazione che vuoi effettuare</h1>
	<div class="insertDiv">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/add-user.png"
			class="imgSuperUser" > <a href="Customer?mode=InsertForm"
			class="customerLink">Inserisci nuovo
			customer </a>
	</div>
	<div class="insertDiv">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/user.png"
			class="imgSuperUser"> <a href="Customer?mode=Read"
			class="customerLink">Visualizza i
			customers</a>
	</div>
	<div class="insertDiv">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/edit-user.png"
			class="imgSuperUser"> <a href="Customer?mode=UpdateForm"
			class="customerLink">Modifica un
			customer</a>
	</div>
	<div class="insertDiv">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/delete-user.png"
			class="imgSuperUser"> <a href="Customer?mode=DeleteForm"
			class="customerLink">Elimina un
			customer</a> 
	</div> 
</body>
</html>
