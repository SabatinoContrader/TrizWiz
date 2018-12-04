<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.virtualpairprogrammers.model.Room"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%String floorId=request.getParameter("floorId"); %>
	<h1>Questa è la jsp che ti permette di modificare una room. </h1>
	<h2>Questi sono le room relative ai floor <%=request.getAttribute("floorId") %></h2>
	<%System.out.println(floorId); %>
	<table>
	<%		List<Room> rooms = (List<Room>) request.getAttribute("rooms");

					for (int i=0; i < rooms.size(); i++) {
						%><tr>	
						<td><% out.println(rooms.get(i).getId()); %></td>
						<td><% out.println(rooms.get(i).getNomeRoom()); %></td>
						<td><% out.println(rooms.get(i).getDescrizione()); %></td>
						<td><% out.println(rooms.get(i).getIdFloor()); %></td>
						</tr>
									
	<%} %>
	</table>
	<h2>Quale room vuoi modificare?</h2>
	<form action="RoomServlet?roomid=<%= request.getParameter("roomid") %>&richiesta=sendDataForUpdate&floorId=<%=request.getParameter("floorId")%>" method="post">
	<select id="id" name="roomId">
	<% for (int i=0; i < rooms.size(); i++) { %>
  		<option value="<%=rooms.get(i).getId()%>"><%=rooms.get(i).getId()%></option>
  	<%} %>
	</select>
	<h3>Inserire nome room: <input type="text" name="roomName" placeholder="inserire nome room"></h3>
	<h3>Inserire descrizione: <input type="text" name="roomDescription" placeholder="inserire descrizione"></h3>
	<button type ="submit" value="sendDataForUpdate" name="richiesta">Modifica</button><br>
</form>
</body>
</html>