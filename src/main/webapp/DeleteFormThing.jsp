<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles.css">
<a href="thingManager.jsp" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
<title>Elimina Thing</title>
</head>
<body>
	<div class="deleteCustomer">
		<img
			src="https://cdn4.iconfinder.com/data/icons/logistic-delivery-20/40/Remove_box_cancel_delete_delivery-512.png"
			class="imgThing">
		<h1>Elimina Thing</h1>
	</div>
	<div class="delete">
		<form action="Thing">
			<table >
			<tr><td><h2>
					Id Thing</h2></td>
			<td><input type="text" name="id_thing"></td>
			</tr>
				
		</table>
				<input hidden type="submit" value="DeleteThing" name="operation">
				<button class="deleteButton" type="submit" value="DeleteThing" name="operation">DeleteThing</button>
		</form>
	</div>
</body>
</html>