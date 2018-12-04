<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles.css">
<a href="ItemMenu.jsp" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
<title>Elimina Item</title>
</head>
<body>
	<div class="readCustomer">
		<img
			src="https://www.shareicon.net/data/512x512/2015/05/10/36482_delete_512x512.png"
			class="imgSuperUser">
		<h1>Elimina Item</h1>
	</div>
	<div class="itemForm">
		<form action="ItemMenu" method="POST">
			<table>
				<tr>
					<td><h2>Id:</h2></td>
					<td><input type="text" name="id" placeholder="id"></td>
				</tr>
			</table>
		</form>
		<button class="loginButton" type="submit" value="EliminaItem"
			name="mode">Elimina</button>
	</div>
</body>
</html>