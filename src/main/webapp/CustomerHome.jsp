<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="HeaderLogout.jsp"></jsp:include>
<title>Customer Menu</title>
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">

</head>
<body>
  	<h1>Customer Menu</h1>
	<h2 class="things">Buildings</h2>
	<div class="thingDiv">
		<table class="thingTable table" style="margin-top:-6%;">
		<thead>
			<tr>
				<th>id</th>
				<th>indirizzo</th>
				<th>citta</th>
				<th>cap</th>
				<th>interno</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach var="building" items="${buildings}">
			<tr>
				<td align="center"><a style="text-decoration:none; color:white" href="/Floors/menu?buildingId=${building.id}">${building.id}</a></td>
				<td align="center"><a style="text-decoration:none; color:white" href="/Floors/menu?buildingId=${building.id}">${building.address}</a></td>
				<td align="center"><a style="text-decoration:none; color:white" href="/Floors/menu?buildingId=${building.id}">${building.city}</a></td>
				<td align="center"><a style="text-decoration:none; color:white" href="/Floors/menu?buildingId=${building.id}">${building.cap}</a></td>
				<td align="center"><a style="text-decoration:none; color:white" href="/Floors/menu?buildingId=${building.id}">${building.interno}</a></ta>
			</tr>
		</c:forEach>
		</tbody>
	</table>
		<div>
			<div class="insertDiv">
				<img
					src="https://cdn4.iconfinder.com/data/icons/symbol-color-business-1/32/office_building-add-512.png"
					class="imgThing"> <a
					href="/Building/insertForm" class="customerLink">Inserisci
					building </a>
			</div>
			<div class="insertDiv">
				<img
					src="https://image.flaticon.com/icons/png/512/1155/1155556.png"
					class="imgThing"> <a
					href="/Building/updateForm" class="customerLink">Modifica
					building </a>
			</div>
			<div class="insertDiv">
				<img
					src="http://icons-for-free.com/free-icons/png/512/905647.png"
					class="imgThing"> <a
					href="/Building/deleteForm" class="customerLink">Elimina
					building </a>
			</div>
		</div>
	</div>
</body>
</html>