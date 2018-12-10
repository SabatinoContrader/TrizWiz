<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="/resources/css/styles.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Elimina Installer</title>
<link rel="stylesheet" href="styles.css">
<a href="/Installer/goBack" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	<div class="deleteCustomer">
		<img
			src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/delete-user.png"
			class="imgSuperUser">
		<h1>Elimina Installer</h1>
		</br>
	</div>
<div class="delete">
	<h2>Seleziona l'id dell'installer da eliminare</h2>
	<form action="/Installer/delete" method="post">
		<div  class="idCustomer"><h2>
			Id Installer: </h2>
			<div style="padding-left:7%"><select name="idselected">
				<c:forEach var="installer" items="${installers}">
					<option value="${installer.id}">${installer.id}</option>
				</c:forEach>
			</select>
			</div>
		</div>

		<button class="deleteButton" type="submit">Elimina</button>
	</form>
	</div>
</body>

</html>