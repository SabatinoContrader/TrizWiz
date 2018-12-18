<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="/resources/css/styles.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Elimina item</title>
<link rel="stylesheet" href="styles.css">
<a href="/Item/menu" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	<div class="deleteItem">
		<img
			src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/delete-user.png"
			class="imgSuperUser">
		<h1>Elimina Item</h1>
		</br>
	</div>
<div class="delete">
	<h2>Seleziona id item da eliminare</h2>
	<form action="/Item/delete" method="post">
		<div  class="idItems"><h2>
			Id item: </h2>
			<div style="padding-left:7%"><select name="idselected">
				<c:forEach var="item" items="${item}">
					<option value="${item.idItems}">${item.idItems}</option>
				</c:forEach>
			</select>
			</div>
		</div>

		<button class="deleteButton" type="submit">Elimina</button>
	</form>
	</div>
</body>

</html>