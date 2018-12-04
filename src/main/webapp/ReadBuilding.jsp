<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
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
				<td align="center"><a style="text-decoration:none; color:white" href="Floor?operation=home&buildingId=${building.buildingId}">${building.buildingId}</a></td>
				<td align="center"><a style="text-decoration:none; color:white" href="Floor?operation=home&buildingId=${building.buildingId}">${building.indirizzo}</a></td>
				<td align="center"><a style="text-decoration:none; color:white" href="Floor?operation=home&buildingId=${building.buildingId}">${building.citta}</a></td>
				<td align="center"><a style="text-decoration:none; color:white" href="Floor?operation=home&buildingId=${building.buildingId}">${building.cap}</a></td>
				<td align="center"><a style="text-decoration:none; color:white" href="Floor?operation=home&buildingId=${building.buildingId}">${building.interno}</a></ta>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</body>
</html>