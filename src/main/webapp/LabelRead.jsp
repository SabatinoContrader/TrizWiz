	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/resources/css/styles.css" rel="stylesheet">

<title>Insert Item</title>
	<a href="/Label/menu" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>

	<div class="InsVisItem">
		<img
			src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/add-user.png"
			class="imgSuperUser">
		<h1>Inserisci customer per visualizzare gli items associati</h1>
	</div>
	<form class="insCustItem" action="/Label/read" method="post">
		<table class="insertTable">
			<tr>
				<td><h2>id Items:</h2></td>
				<td><input class="form-control" id="idItems" name="idItems"
					placeholder="Inserisci idItems"></td>
			</tr>
		</table>
		<button type="submit" class="registerButton">Invia Richiesta</button>
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
					<th>Id Labels</th>  
							<th>tipologia</th>
			                <th>commento</th>
							<!--<th>Username</th> -->
							
					</tr>
				</thead>
				<tbody>
					<c:forEach var="label" items="${label}">
						<tr>
						 <th>${label.idLabels}</th>
							<td align="center">${label.tipologia}</td>
							<td align="center">${label.commento}</td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
		</div>
		</br>
</body>