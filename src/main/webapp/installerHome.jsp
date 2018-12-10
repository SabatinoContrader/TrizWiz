<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.AmebaDevices.dto.BuildingDTO"%>
<%@page import="com.AmebaDevices.dto.CustomerDTO"%>


<% CustomerDTO myInfo = (CustomerDTO) request.getAttribute("installer");  %>
	

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<link href="/resources/css/styles.css" rel="stylesheet">
<jsp:include page="HeaderLogout.jsp"></jsp:include>
<meta charset="ISO-8859-1">
<title>Installer Home</title>
</head>
<body>
	<h1>Benvenuto, <%=myInfo.getUsername()%> Questi sono i buildings che devi gestire</h1>
	<div class="thingDiv" style="margin-top: 5%">
		<table>
			<th>
				<th>id</th>
				<th>indirizzo</th>
				<th>citta</th>
				<th>cap</th>
				<th>interno</th>
			</th>
			<c:forEach var="building" items="${buildings}">
			<tr>
				<td align="center"><a href="/BuildingTree/getTree?buildingId=${building.id}">${building.id}</a></td>
				<td align="center"><a href="/BuildingTree/getTree?buildingId=${building.id}">${building.address}</a></td>
				<td align="center"><a href="/BuildingTree/getTree?buildingId=${building.id}">${building.city}</a></td>
				<td align="center"><a href="/BuildingTree/getTree?buildingId=${building.id}">${building.cap}</a></td>
				<td align="center"><a href="/BuildingTree/getTree?buildingId=${building.id}">${building.interno}</a></td>
			</tr>
		</c:forEach>
		<br><br>
		</table>
		<form action ="/Installer/download" method="GET"> 
		<select style="border-radius: 10%" name="type">
  				<option value="csv">Genera CSV</option>
   				<option value="xml">Genera XML</option>		
		</select>
		<select style="border-radius: 10%" name="buildingId">
			<c:forEach var="building" items="${buildings}">
  				<option href="/Floors/menu?buildingId=${building.id}"value="${building.id}">${building.address} ${building.interno} ${building.city} ${building.cap}</option>
  			</c:forEach>
  			
  			<c:forEach var="building" items="${buildings}">
			<tr>
				<td align="center"><a style="text-decoration:none; color:white" href="/Floors/menu?buildingId=${building.id}">${building.id}</a></td>
				<td align="center"><a style="text-decoration:none; color:white" href="/Floors/menu?buildingId=${building.id}">${building.address}</a></td>
				<td align="center"><a style="text-decoration:none; color:white" href="/Floors/menu?buildingId=${building.id}">${building.city}</a></td>
				<td align="center"><a style="text-decoration:none; color:white" href="/Floors/menu?buildingId=${building.id}">${building.cap}</a></td>
				<td align="center"><a style="text-decoration:none; color:white" href="/Floors/menu?buildingId=${building.id}">${building.interno}</a></ta>
			</tr>
		</c:forEach>
		</select>
		<button type="submit"> Conferma </button>
		</form>	
		
			
		</div>
		
		
</body>
</html>