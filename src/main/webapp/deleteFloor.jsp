<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.AmebaDevices.dto.FloorDTO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Elimina un floor:</h1>
	<h2>Questi sono i floor relativi al building <%=request.getAttribute("buildingId") %></h2>
	<table>
	<%
										List<FloorDTO> floors = (List<FloorDTO>) request.getAttribute("floors");

										for (int i=0; i < floors.size(); i++) {
									%><tr>	<td><% out.println(floors.get(i).getId()); %></td>
											<td><% out.println(floors.get(i).getNomeFloor()); %></td>
											<td><% out.println(floors.get(i).getDescrizione()); %></td>
											<td><% out.println(floors.get(i).getBuilding().getId()); %></td>
									</tr>
									
	<%} %>
	</table>
	<h2>Quale floor vuoi modificare?</h2>
	<form action="delete?buildingId=<%=request.getParameter("buildingId")%>" method="post">
	<select id="id" name="floorid">
	<% for (int i=0; i < floors.size(); i++) { %>
  		<option value="<%=floors.get(i).getId()%>"><%=floors.get(i).getId()%></option>
  	<%} %>
	</select>
	<button type ="submit">Elimina</button><br>
</form>

</body>
</html>