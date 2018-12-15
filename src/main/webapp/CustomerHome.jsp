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
				<th>idCustomer</th>
				<th>nome</th>
				<th>cognome</th>
				<th>username</th>
			
			</tr>
		</thead>
		
		<tbody>
		<c:forEach var="trizcustomer1" items="${trizcustomer1}">
			<tr>
				<td align="center"><a style="text-decoration:none; color:white" href="/Floors/menu?trizcustomer1IdCustomer=${trizcustomer1.idCustomer}">${trizcustomer1.idCustomer}</a></td>
				<td align="center"><a style="text-decoration:none; color:white" href="/Floors/menu?trizcustomer1IdCustomer=${trizcustomer1.idCustomer}">${trizcustomer1.nome}</a></td>
				<td align="center"><a style="text-decoration:none; color:white" href="/Floors/menu?trizcustomer1IdCustomer=${trizcustomer1.idCustomer}">${trizcustomer1.cognome}</a></td>
				<td align="center"><a style="text-decoration:none; color:white" href="/Floors/menu?trizcustomer1IdCustomer=${trizcustomer1.idCustomer}">${trizcustomer1.username}</a></td>
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
					href="/TrizCustomer/updateForm" class="customerLink">Modifica
					building </a>
			</div>
			<div class="insertDiv">
				<img
					src="http://icons-for-free.com/free-icons/png/512/905647.png"
					class="imgThing"> <a
					href="/TrizCustomer/deleteForm" class="customerLink">Elimina
					building </a>
			</div>
		</div>
	</div>
</body>
</html>