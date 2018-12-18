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

	<div class="deleteCustomer">
		<img
			src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/delete-user.png"
			class="imgSuperUser">
		<h1>Elimina Triz Customer</h1>
		</br>
	</div>
<div class="delete">
	<h2>Seleziona l'Id dell'utente da eliminare</h2>
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