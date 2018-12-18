<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elimina Triz Customer</title>
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
<a href="/Building/menu" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>

	<div class=<"deleteCustomer">
		<img src="http://icons-for-free.com/free-icons/png/512/905647.png"
			class="imgThing">
		<h1>Elimina Triz Customer</h1>
	</div>
	<div>
		<div class="thingDiv" style="margin-top: 5%">
		<table>
			<th>
			<th>idCustomer</th>
				<th>nome</th>
				<th>cognome</th>
				<th>username</th> 
			</th>
			<c:forEach var="trizcustomer1" items="${trizcustomer1}">
			<tr>
				<td align="center">${trizcustomer.idCustomer}</td>
				<td align="center">${trizcustomer.nome}</td>
				<td align="center">${trizcustomer.cognome}</td>
				<!--<td align="center">${trizcustomer.username}</td>-->
	
			</tr>
		</c:forEach>
		</table>
			<div class="deleteBuilding" style="margin-top: -5%">
				<form action="delete" method="post">
					<<table>

						<tr>

							<td><h2>Id Triz Customer:</h2></td>

						<td><select name="idselected">

									<c:forEach var="trizcustomer1" items="${trizcustomer1}">

										<option value="${trizcustomer1.idCustomer}">${trizcustomer1.idCustomer}</option>

									</c:forEach>

							</select></td>

						</tr>
					</table>
					<button class="deleteButton" type="submit">Elimina</button>
					<br>
				</form>
			</div>
		</div>
	</div>
</body>
</html>