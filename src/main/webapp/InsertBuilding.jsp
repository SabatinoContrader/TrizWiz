<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci Building</title>
<link rel="stylesheet" href="styles.css">
<a href="CustomerHome.jsp" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>

<body>
	<div class="deleteCustomer">
		<img
			src="https://cdn4.iconfinder.com/data/icons/symbol-color-business-1/32/office_building-add-512.png"
			class="imgSuperUser">
		<h1>Crea il tuo building</h1>
	</div>
	<div>
		<form action="Building" method="get">
			<table class="insertTable">
				<tr>
					<td><h2>Indirizzo del building:</h2></td>
					<td><input type="text" id="indirizzoBuilding" name="indirizzo"
						placeholder="Inserisci indirizzo del building"></td>
				</tr>
				<tr>
					<td><h2>Interno del building:</h2></td>
					<td><input type="text" id="internoBuilding" name="interno"
						placeholder="Inserisci interno del building"></td>
				</tr>
				<tr>
					<td><h2>Città del building: </h2></td>
					<td><input type="text" id="cittàBuilding"
					name="citta" placeholder="Inserisci città del building"></td>
				</tr>
				<tr>
					<td><h2>Cap del building: </h2></td>
					<td>	<input type="text" id="capBuilding" name="cap"
					placeholder="Inserisci cap del building"></td>
				</tr>
			</table>
		</form>
			<button class="censisciButton" type="submit" value="newBuilding" name="richiesta">Crea</button>
	</div>
</body>
</html>