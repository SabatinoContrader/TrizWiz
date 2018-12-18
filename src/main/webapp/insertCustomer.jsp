<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<link href="/resources/css/styles.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert Triz Consultant</title>
	<a href="/Customer/goBack" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	
	<div class="insertCustomer">
		<img
			src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/add-user.png"
			class="imgSuperUser">
		<h1>Inserisci il tuo Triz Consultant</h1>
	</div>
	<form class="customerForm" action="/UtentiLocali/insert" method="post">
		<table class="insertTable">
			<tr>
				<td><h2>Username:</h2></td>
				<td><input type="text" class="form-control" id="username" name="username"
					placeholder="Username"></td>
			</tr>
			<tr>
				<td><h2>Password:</h2></td>
				<td><input type="password" class="form-control" id="password" name="password"
					placeholder="Inserisci Password"></td>
			</tr>
		</table>

		<button type="submit" class="registerButton">Registra</button>

	</form>

</body>
</html>