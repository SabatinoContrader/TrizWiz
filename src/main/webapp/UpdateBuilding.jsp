<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Building</title>
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
<a href="/Building/goBack" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>

	<div class="deleteCustomer">
		<img src="https://image.flaticon.com/icons/png/512/1155/1155556.png"
			class="imgSuperUser">
		<h1>Modifica il tuo building</h1>
	</div>
	<div>
		<div class="thingDiv" style="margin-top: -3%">
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
			<div class="updateThing">
				<form action="update" method="post">
					<table>
						<tr>
							<td><h2>Id Building:</h2></td>
							<td><select name="idselected">
									<c:forEach var="building" items="${buildings}">
										<option value="${building.id}">${building.id}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td><h2>Inserire indirizzo building:</h2></td>
							<td><input type="text" name="newindirizzo"
								placeholder="inserire indirizzo building"></td>
						</tr>
						<tr>
							<td><h2>Inserire interno building:</h2></td>
							<td><input type="text" name="newinterno"
								placeholder="inserire interno"></td>
						</tr>
						<tr>
							<td><h2>Inserire citta building:</h2></td>
							<td><input type="text" name="newcitta"
								placeholder="inserire citta"></td>
						</tr>
						<tr>
							<td><h2>Inserire cap building:</h2></td>
							<td><input type="text" name="newcap"
								placeholder="inserire cap"></td>
						</tr>

					</table>
					<button class="deleteButton" type="submit">Modifica</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>