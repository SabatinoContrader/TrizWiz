<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/resources/css/styles.css" rel="stylesheet">

<title>Visualizza Item</title>
	<a href="/Item/menu" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>

</head>
<body>

	<div class="VisualizzaItem">
		<img
			src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/add-user.png"
			class="imgSuperUser">
			
			
		<h1>ITEM PER CUSTOMER <%= request.getParameter("idCustomer")%></h1>
	</div>
	

	<div class="visualizzaItem">
		
	</div>
	<div class="readTable">
		<table class="table">
				<thead>
					<tr>
					<th>Id items</th>  
							<th>Commento</th>
			                <th>Id Customer</th>
							<!--<th>Username</th> -->
							
					</tr>
				</thead>
		
			<tbody>
					<c:forEach var="itemCustomer" items="${itemCustomer}">
						<tr>
						  <td align="center">${itemCustomer.idItems}</td> 
							<td align="center">${itemCustomer.commento}</td>
						<td align="center">	<%= request.getParameter("idCustomer")%> </td>
							
						</tr>
					</c:forEach>
				</tbody>
				 
		</table>
		</div>
		</br>
</body>