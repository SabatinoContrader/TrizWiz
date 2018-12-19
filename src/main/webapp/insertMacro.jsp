<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<link href="/resources/css/styles.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert Triz Consultant</title>
	<a href="/MacroMenu/menu" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	
	<div class="insertTrizCustomer">
		<img
			src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/add-user.png"
			class="imgSuperUser">
		<h1>Inserisci la tua Macrofase</h1>
	</div>
	<form class="customerForm" action="/TrizCustomer/insert" method="post">
		<table class="insertTable">
			
			<tr>
				<td><h2>Tipologia:</h2></td>
				<td><input class="form-control" id="tipologia" name="tipologia"
					placeholder="Inserisci tipologia"></td>
			</tr>
			
			
		</table>

		<button type="submit" class="registerButton">Registra</button>
	</form>

</body>
</html>