<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<link href="/resources/css/styles.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert Label</title>
	<a href="/Label/menu" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	
	<div class="insertLabel">
		<img
			src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/add-user.png"
			class="imgSuperUser">
		<h1>Inserisci label</h1>
	</div>
	<form class="insertForm" action="/Label/insert" method="post">
		<table class="insertTable">
			<tr>
				<td><h2>Nome label:</h2></td>
				<td><input type="text" class="form-control" id="nome" name="nome"
					placeholder="Inserisci label"></td>
			</tr>
		</table>

		<button type="submit" class="registerButton">Invia</button>

	</form>

</body>
</html>