<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/resources/css/styles.css" rel="stylesheet">

<title>Triz Consultant</title>
	<a href="/UtentiLocali/goBack" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	<div class="readCustomer">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/user.png"
			class="imgSuperUser">
	<h1>Triz Consultant</h1>
	</div>
	<div class="readTable">
		<table class="table">
				<thead>
					<tr>
							<th>Id</th>
							<th>Username</th>
							<th>Password</th>
							<!--<th>Ruolo</th> -->
					</tr>
				</thead>
				<tbody>
					<c:forEach var="utentiLocali" items="${utentiLocali}">
						<tr>
							<th>${utentiLocali.id}</th>
							<td align="center">${utentiLocali.nomeLogin}</td>
							<td align="center">${utentiLocali.passwordLogin}</td>
							<!-- da stampare ruolo : per farlo trovare metodo per convertire Integer in long -->
							
						</tr>
					</c:forEach>
				</tbody>
		</table>
		</div>
		</br>
</body>
</html>