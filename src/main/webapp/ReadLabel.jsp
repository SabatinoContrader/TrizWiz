<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/resources/css/styles.css" rel="stylesheet">

<title>Visualizza label</title>
	<a href="/Label/menu" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	<div class="ReadItem">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/user.png"
			class="imgSuperUser">
	<h1>Tabella label</h1>
	</div>
	<div class="readCustomer">
		<table class="table">
				<thead>
					<tr>
							<th>Id Labels</th>
							<th>tipologia</th>
							<th>Commento</th>
							
							
					</tr>
				</thead>
				<tbody>
					<c:forEach var="label" items="${label}">
						<tr>
							<th>${label.idLabels}</th>
							<td align="center">${label.tipologia}</td>
							<td align="center">${label.commento}</td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
		</div>
		</br>
</body>
</html>