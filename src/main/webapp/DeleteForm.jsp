<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.AmebaDevices.dto.RoomDTO"%>


<!DOCTYPE html>
<html>
<link href="/resources/css/styles.css" rel="stylesheet">

<head>
<meta charset="ISO-8859-1">
<title>Delete room</title>
</head>
<body>
	<h1>Elimina una room:</h1>
	<h2>Queste sono le room relative al floor <%=request.getAttribute("floorId") %></h2>
	<table>
	<%
										List<RoomDTO> rooms = (List<RoomDTO>) request.getAttribute("rooms");

										for (int i=0; i < rooms.size(); i++) {
									%><tr>	<td><% out.println(rooms.get(i).getId()); %></td>
											<td><% out.println(rooms.get(i).getNomeRoom()); %></td>
											<td><% out.println(rooms.get(i).getDescrizione()); %></td>
											<td><% out.println(rooms.get(i).getFloor().getId()); %></td>
									</tr>
									
	<%} %>
	</table>
	<h2>Quale room vuoi eliminare?</h2>
	<form action="/Room/delete?floorId=<%=request.getParameter("floorId")%>" method="post">
	<select id="id" name="roomid">
	<% for (int i=0; i < rooms.size(); i++) { %>
  		<option value="<%=rooms.get(i).getId()%>"><%=rooms.get(i).getId()%></option>
  	<%} %>
	</select>
	<button type ="submit">Elimina</button><br>
</form>

</body>
</html>