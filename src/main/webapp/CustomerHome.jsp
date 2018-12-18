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
  	<h1>Triz Customer Menu</h1>
<!--	<h2 class="things">Buildings</h2>-->
	<div class="thingDiv" style="text-align: center">
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
			<td align="center"><a style="text-decoration:none; color:white" href="/Floors/menu?trizcustomer1IdCustomer=${trizcustomer1.idCustomer}">${trizcustomer1.username.nomeLogin}</a></td>
					</tr>
		</c:forEach>
		</tbody>
	</table>
		<div>
			<div class="insertDiv">
				 <a
					href="/Building/insertForm" class="customerLink">Inserisci
					Triz Customer </a>
			</div>
			<div class="insertDiv">
				 <a
					href="/TrizCustomer/updateForm" class="customerLink">Modifica
					Triz Customer </a>
			</div>
			<div class="insertDiv">
				 <a
					href="/TrizCustomer/deleteForm" class="customerLink">Elimina
					Triz Customer </a>
			</div>
		</div>
	</div>
</body>
</html>