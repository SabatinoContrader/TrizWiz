<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Items</title>
<link href="/resources/css/styles.css" rel="stylesheet">
	<a href="/ItemType/menu" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
<div class="readCustomer">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/notes.png"
			class="itemSizeImg">
	<h1>I tuoi Items</h1>
	
	</div>
	
<div class="itemForm">
		<table class="table">
		<thead>
		<tr>
    		<th>id</th>
    		<th>Categoria</th> 
    		<th>Marca</th>
    		<th>Modello</th>
    		<th>Descrizione</th>
  		</tr>
  		</thead>
  		<tbody>
		<c:forEach items="${items}" var="item">
			<tr>
    			<td align="center">${item.getId()}</td>      
        		<td align="center">${item.getCategoria()}</td>
        		<td align="center">${item.getMarca()}</td>
        		<td align="center">${item.getModello()}</td>
        		<td align="center">${item.getDescrizione()}</td>
    		</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>

</body>
</html>