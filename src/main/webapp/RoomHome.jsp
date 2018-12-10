<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.AmebaDevices.dto.RoomDTO"%>
<!DOCTYPE html>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Floor Home</title>
</head>
<body>
     <h1>------- FLOOR MENU del floor <%=request.getParameter("floorId")%> -------</h1>
     <h2>Le tue rooms</h2>
		<table class="table">
					<tr>
							<th>Id</th>
							<th>Nome</th>
							<th>Descrizione</th>
							<th>IdFloor</th>
					</tr>
					<% 
					List <RoomDTO> rooms = (List <RoomDTO>) request.getAttribute("rooms");
					for (int i=0 ; i < rooms.size(); i++) { %>
						<tr>
							<td align="center"><a style="color:blue; text-decoration:none" href="/Item/menu?roomId=<% out.println(rooms.get(i).getId()); %>"><% out.println(rooms.get(i).getId()); %></a></td>
							<td align="center"><a style="color:blue; text-decoration:none"href="/Item/menu?roomId=<% out.println(rooms.get(i).getId()); %>"><% out.println (rooms.get(i).getNomeRoom());%></a></td>
							<td align="center"><a style="color:blue; text-decoration:none"href="/Item/menu?roomId=<% out.println(rooms.get(i).getId()); %>"><% out.println (rooms.get(i).getDescrizione()); %></a></td>
							<td align="center"><a style="color:blue; text-decoration:none"href="/Item/menu?roomId=<% out.println(rooms.get(i).getId()); %>"> <% out.println (rooms.get(i).getFloor().getId()); %></a></td>
						</tr>
		<% }%>
		</table>	
	 <%String floorId= request.getParameter("floorId"); %>
	 <p>
		<ol>
  			<li> 
  				<a href="insertForm?floorId=<%=floorId%>">
  				Inserisci room
  				</a> 
  			</li>
  			<li> 
  				<a href="updateForm?floorId=<%=floorId%>">
  				Modifica room
  				</a>
  			</li>
  			<li>
				<a href="deleteForm?floorId=<%=floorId%>">
  				Elimina room
  				</a>
  			</li>
		</ol> 
	</p>
 </body>
 </html>