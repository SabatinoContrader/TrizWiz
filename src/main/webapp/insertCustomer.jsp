<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">
<meta charset="ISO-8859-1">
<title>Insert Customer</title>
	<a href="Customer?mode=Return" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	
	<div class="insertCustomer">
		<img
			src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/add-user.png"
			class="imgSuperUser">
		<h1>Inserisci il tuo Customer</h1>
	</div>
	<form class="customerForm" action="Customer" method="post">
		<table class="insertTable">
			<tr>
				<td><h2>Nome:</h2></td>
				<td><input type="text" class="form-control" id="nome"
					name="nome" placeholder="Inserisci Nome"></td>
			</tr>
			<tr>
				<td><h2>Cognome:</h2></td>
				<td><input type="text" class="form-control" id="cognome" name="cognome"
					placeholder="Inserisci Cognome"></td>
			</tr>
			<tr>
				<td><h2>Data di Nascita:</h2></td>
				<td><input type="date" class="form-control" id="dataDiNascita" name="dataDiNascita"
					placeholder="Inserisci Data di Nascita"></td>
			</tr>
			<tr>
				<td><h2>Email:</h2></td>
				<td><input type="text" class="form-control" id="email" name="email"
					placeholder="Inserisci Email"></td>
			</tr>
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

		<button name="mode" value="InsertDb" type="submit" class="registerButton">Registra</button>

	</form>

</body>
</html>