<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<link href="/resources/css/styles.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert Item</title>
	<a href="/Item/menu" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	
	<div class="insertItem">
		<img
			src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/add-user.png"
			class="imgSuperUser">
		<h1>Inserisci item</h1>
	</div>
	<form class="insertForm" action="/Item/insert" method="post">
		<table class="insertTable">
			<tr>
				<td><h2>Nome item:</h2></td>
				<td><input type="text" class="form-control" id="commento" name="commento"
					placeholder="Inserisci item"></td>
			</tr>
		</table>

		<button type="submit" class="registerButton">Invia</button>

	</form>

</body>
</html>