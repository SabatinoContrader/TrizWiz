<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/resources/css/styles.css" rel="stylesheet">

<title>Customers</title>
	<a href="/Customer/goBack" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	<div class="readCustomer">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/user.png"
			class="imgSuperUser">
	<h1>Customers</h1>
	</div>
	<div class="readTable">
		<table class="table">
				<thead>
					<tr>
							<th>Id</th>
							<th>Nome</th>
							<th>Cognome</th>
							<th>Data Di Nascita</th>
							<th>Username</th>
							<th>Password</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="customer" items="${customers}">
						<tr>
							<th>${customer.id}</th>
							<td align="center">${customer.nome}</td>
							<td align="center">${customer.cognome}</td>
							<td align="center">${customer.dataNascita}</td>
							<td align="center">${customer.username}</td>
							<td align="center">${customer.password}</td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
		</div>
		</br>
</body>
</html>