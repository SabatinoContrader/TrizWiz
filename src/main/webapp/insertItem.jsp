	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/resources/css/styles.css" rel="stylesheet">

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
				<td><h2>idCustomer:</h2></td>
				<td><input class="form-control" id="idCustomer" name="idCustomer"
					placeholder="Inserisci idCustomer"></td>
			</tr>
			<tr>
				<td><h2>Nome item:</h2></td>
				<td><input type="text" class="form-control" id="commento" name="commento"
					placeholder="Inserisci item"></td>
			</tr>
		</table>
		<button type="submit" class="registerButton">Invia</button>
	</form>
	

	<div class="readCustomer">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/user.png"
			class="imgSuperUser">
	<h1>Triz Customer</h1>
	</div>
	<div class="readTable">
		<table class="table">
				<thead>
					<tr>
					<th>IdCustomer</th>  
							<th>Nome</th>
			                <th>Cognome</th>
							<!--<th>Username</th> -->
							
					</tr>
				</thead>
				<tbody>
					<c:forEach var="trizcustomer" items="${trizcustomer}">
						<tr>
						  <td align="center">${trizcustomer.idCustomer}</td> 
							<td align="center">${trizcustomer.nome}</td>
							<td align="center">${trizcustomer.cognome}</td>
						<!-- <td align="center">${trizcustomer.username}</td> -->
						</tr>
					</c:forEach>
				</tbody>
		</table>
		</div>
		</br>
</body>
