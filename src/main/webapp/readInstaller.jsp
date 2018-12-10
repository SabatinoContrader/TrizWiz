<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/resources/css/styles.css" rel="stylesheet">

<title>Installer</title>
	<a href="/Installer/goBack" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	<div class="readCustomer">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/user.png"
			class="imgSuperUser">
	<h1>Installers</h1>
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
					<c:forEach var="installer" items="${installers}">
						<tr>
							<th>${installer.id}</th>
							<td align="center">${installer.nome}</td>
							<td align="center">${installer.cognome}</td>
							<td align="center">${installer.dataNascita}</td>
							<td align="center">${installer.username}</td>
							<td align="center">${installer.password}</td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
		</div>
		</br>
</body>
</html>