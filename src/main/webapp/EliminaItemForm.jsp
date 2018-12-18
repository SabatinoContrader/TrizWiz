<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
<a href="/Item/menu" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
<title>Elimina Item</title>
</head>
<body>
	<div class="readCustomer">
		<img
			src="https://www.shareicon.net/data/512x512/2015/05/10/36482_delete_512x512.png"
			class="imgSuperUser">
		<h1>Elimina Item</h1>
	</div>
	<div class="itemForm">
		<form action="/Item/delete" method="POST">
			<table>
				<tr>
					<td><h2>Id:</h2></td>
					<td><input type="text" name="id" placeholder="id"></td>
				</tr>
			</table>
			<button class="loginButton" type="submit"
			name="mode">Elimina</button>
			<input type="hidden" name="roomId" value=<%=request.getParameter("roomId")%> >
		</form>
	</div>
</body>
</html>