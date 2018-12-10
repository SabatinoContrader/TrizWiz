<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="/resources/css/styles.css" rel="stylesheet">
<jsp:include page="HeaderLogout.jsp"></jsp:include>
<meta charset="ISO-8859-1">
<title>Associazione Buildings</title>
		<a href="/Installer/goBack" class="logout">Indietro</a>
</head>
<body>
<h3>Associazione Buildings</h3><form action="/Installer/associazioneMenu" method="POST">
	<div class="idCustomer"><h3>Installatore:</h3>
	<div style="padding-left:2%"><select style="border-radius: 10%" name="idselected">
			<c:forEach var="installer" items="${installers}">
					<option value="${installer.id}">${installer.nome} ${installer.cognome}</option>			
			</c:forEach>
				</select>
				<br>
				</div></div>
	<c:forEach var="building" items="${buildings}">
		<input type="checkbox" name="${building.id}" value="${building.id}">
		${building.address} ${building.interno} ${building.city} ${building.cap}<br>
	</c:forEach>
	<button type="submit"> Conferma </button>
	</form>
</body>