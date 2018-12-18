<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/resources/css/styles.css" rel="stylesheet">

<title>Visualizza items</title>
	<a href="/Item/menu" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	<div class="ReadItem">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/user.png"
			class="imgSuperUser">
	<h1>Tabella items</h1>
	</div>
	<div class="ReadTable">
		<table class="table">
				<thead>
					<tr>
							<th>Id</th>
							<th>Item</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="items" items="${Item}">
						<tr>
						
							<td align="center">${Item.idItems}</td>
							<td align="center">${Item.commento}</td>
							
						</tr>
					</c:forEach>
				</tbody>
		</table>
		</div>
		</br>
</body>
</html>