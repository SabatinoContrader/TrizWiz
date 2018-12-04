<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">
<meta charset="ISO-8859-1">
<title>Elimina Customer</title>
<link rel="stylesheet" href="styles.css">
<a href="Customer?mode=Return" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	<div class="deleteCustomer">
		<img
			src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/delete-user.png"
			class="imgSuperUser">
		<h1>Elimina Customer</h1>
		</br>
	</div>
<div class="delete">
	<h2>Seleziona l'id del customer da eliminare</h2>
	<form action="Customer" method="post">
		<div  class="idCustomer"><h2>
			Id Customer: </h2>
			<div style="padding-left:7%"><select name="idselected">
				<c:forEach var="customer" items="${customers}">
					<option value="${customer.id}">${customer.id}</option>
				</c:forEach>
			</select>
			</div>
		</div>

		<button class="deleteButton" type="submit" name="mode" value="DeleteDb">Elimina</button>
	</form>
	</div>
</body>

</html>