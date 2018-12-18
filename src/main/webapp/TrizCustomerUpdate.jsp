<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Modifica Triz Customer</title>

<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">

<a href="/TrizCustomer/goBack" class="logout">Indietro</a>

<jsp:include page="HeaderLogout.jsp"></jsp:include>

</head>

<body>



	<div class="deleteCustomer">

		<img src="https://image.flaticon.com/icons/png/512/1155/1155556.png"

			class="imgSuperUser">

		<h1>Modifica il tuo Triz Customer</h1>

	</div>

	<div>

		<div class="thingDiv" style="margin-top: -3%">

			<table>

			<th>

			<!--	<th>idCustomer</th> -->

			<!--	<th>nome</th> -->

			<!--	<th>cognome</th> -->

				

			</th>

			<c:forEach var="trizcustomer1" items="${trizcustomer1}">

			<tr>

				<td align="center">${trizcustomer.idCustomer}</td>

				<td align="center">${trizcustomer.nome}</td>

				<td align="center">${trizcustomer.cognome}</td>


			</tr>

		</c:forEach>

		</table>

			<div class="updateThing">

				<form action="update" method="post">

					<table>

						<tr>

							<td><h2>Id Triz Customer:</h2></td>

						<td><select name="idselected">

									<c:forEach var="trizcustomer1" items="${trizcustomer1}">

										<option value="${trizcustomer1.idCustomer}">${trizcustomer1.idCustomer}</option>

									</c:forEach>

							</select></td>

						</tr>

						<tr>

							<td><h2>Inserire nome:</h2></td>

							<td><input type="text" name="nome"

								placeholder="Inserire nome "></td>

						</tr>

						<tr>

							<td><h2>Inserire cognome:</h2></td>

							<td><input type="text" name="cognome"

								placeholder="Inserire cognome "></td>

						</tr>

						

					</table>

					<button class="deleteButton" type="submit">Modifica</button>

				</form>

			</div>

		</div>

	</div>

</body>

</html>