<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Label</title>
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
<a href="/Label/back" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	<div class="deleteCustomer">
		<img src="https://image.flaticon.com/icons/png/512/1155/1155556.png"
			class="imgSuperUser">
		<h1>Modifica Labels</h1>
	</div>
	<div>
		<div class="thingDiv" style="margin-top: -3%">
			<table>
			<th>
			<!--	<th>idCustomer</th> -->
			<!--	<th>nome</th> -->
			<!--	<th>cognome</th> -->
			</th>
			<c:forEach var="label" items="${label}">
			<tr>
				<td align="center">${label.idLabels}</td>
				<td align="center">${label.tipologia}</td>
				<td align="center">${label.commento}</td>
			</tr>
		</c:forEach>
		</table>
			<div class="updateThing">
				<form action="/Label/update" method="post">
					<table>
						<tr>
							<td><h2>Id Label:</h2></td>
						<td><select name="idLabels">
									<c:forEach var="label" items="${label}">
										<option value="${label.idLabels}">${label.idLabels}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td><h2>Inserire Tipologia:</h2></td>
							<td><input type="text" name="tipologia"
								placeholder="Inserire tipologia "></td>
						</tr>
						<tr>
							<td><h2>Inserire commento:</h2></td>
							<td><input type="text" name="commento"
								placeholder="Inserire commento "></td>
						</tr>
					</table>
					<button class="deleteButton" type="submit">Modifica</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>