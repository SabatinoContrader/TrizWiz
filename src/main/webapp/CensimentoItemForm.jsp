<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<a href="/Item/menu" class="logout">Indietro</a>
<link href="/resources/css/styles.css" rel="stylesheet">
<jsp:include page="HeaderLogout.jsp"></jsp:include>
<meta charset="ISO-8859-1">
<title>Censimento Item</title>

</head>
<body>
<div class="readCustomer">
		<img src="http://www.aa24.it/wp-content/uploads/2015/03/1426101814_add-notes.png"
			class="imgSuperUser">
	<h1>Item </h1>
	</div>
	<%String roomId= request.getParameter("roomId"); %>
	<form action="/Item/insert?roomId=<%=roomId %>" method="post">
		<table class="insertTable">
		<tr>
			<td> <h2>ConsumoEnergetico: </h2></td>
			<td><input type="text" name="consumoEnergetico" placeholder="Inserisci il consumo energetico dell'item"></td>
		</tr>
		<tr>
			<td> <h2>Seriale: </h2></td>
			<td><input type="text" name="seriale" placeholder="Inserisci seriale"></td>
		</tr>	
	
		</table> 
		<h2>
		
			<button class="censisciButton" type = "submit" >Censisci</button>
		</h2>
		
		<input type="hidden" name="roomId" value=<%=request.getParameter("roomId")%> >
	</form>
</body>
</html>