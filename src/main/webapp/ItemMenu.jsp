<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.TrizWizSpring.dto.ItemDTO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Menu</title>
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
<a href="/Item/back" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>

	<h1>Seleziona l'operazione che vuoi effettuare</h1>

	
		<div class="insertDiv">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/add-user.png"
			class="imgSuperUser" > <a href="/TrizCustomer/readItem"
			class="customerLink">Inserisci nuovo item </a>
	</div>
	<div class="insertDiv">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/user.png"
			class="imgSuperUser"> <a href="/Item/read"
			class="customerLink">Visualizza gli items</a>
	</div>
	<div class="insertDiv">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/edit-user.png"
			class="imgSuperUser"> <a href="/Item/updateForm"
			class="customerLink">Modifica un item</a>
	</div>
	<div class="insertDiv">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/delete-user.png"
			class="imgSuperUser"> <a href="/Item/deleteForm"
			class="customerLink">Elimina un item</a> 
	</div> 

</body>
</html>