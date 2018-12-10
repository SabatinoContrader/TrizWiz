<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elimina Building</title>
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
<a href="/Building/goBack" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>

	<div class="deleteCustomer">
		<img src="http://icons-for-free.com/free-icons/png/512/905647.png"
			class="imgThing">
		<h1>Elimina Building</h1>
	</div>
	<div>
		<div class="thingDiv" style="margin-top: 5%">
		<table>
			<th>
				<th>id</th>
				<th>indirizzo</th>
				<th>citta</th>
				<th>cap</th>
				<th>interno</th>
			</th>
			<c:forEach var="building" items="${buildings}">
			<tr>
				<td align="center">${building.id}</td>
				<td align="center">${building.address}</td>
				<td align="center">${building.city}</td>
				<td align="center">${building.cap}</td>
				<td align="center">${building.interno}</td>
			</tr>
		</c:forEach>
		</table>
			<div class="deleteBuilding" style="margin-top: -6%">
				<form action="delete" method="post">
					<table>
						<tr>
							<td><h2 style="display:block">Id Building:</h2></td>
							<td><select name="idselected">
									<c:forEach var="building" items="${buildings}">
										<option value="${building.id}">${building.id}</option>
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