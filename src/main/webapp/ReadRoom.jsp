<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1" %>
<%@ page import="com.virtualpairprogrammers.model.Room"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Rooms</title>
<% List<Room> rooms = (List<Room>) request.getAttribute("rooms");%>
</head>

<body>

	<h2>Rooms</h2>

		<table class="table">

			

					<tr>

							<th>Id</th>

							<th>Nome</th>

							<th>Descrizione</th>

							<th>IdFloor</th>

					

					</tr>

				

				

					<%for (Room room : rooms) { %>

						<tr>
						
							<td align="center"> <%=room.getId() %>
							
							<td align="center"><%=room.getNomeRoom()%></td>

							<td align="center"><%=room.getDescrizione() %>

							<td align="center"> <%=room.getIdFloor() %>

					

						</tr>
	
		
		<% }%>
		</table>
		


</body>