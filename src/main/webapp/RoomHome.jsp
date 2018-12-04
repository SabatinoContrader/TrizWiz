<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RoomHome</title>
</head>
<body>
<jsp:include page="/RoomServlet">
     	<jsp:param name="richiesta" value="ReadRoom"/>
     </jsp:include>
     <h2>------- MENU ROOMS -------</h2>
	 <%String floorId= request.getParameter("floorId"); %>
	 <p>
		<ol>
  			<li> 
  				<a href="RoomServlet?richiesta=InsertForm&floorId=<%=floorId%>">
  				Inserisci room
  				</a> 
  			</li>
  			<li> 
  				<a href="RoomServlet?richiesta=update&floorId=<%=floorId%>">
  				Modifica room
  				</a>
  			</li>
  			<li>
				<a href="RoomServlet?richiesta=DeleteForm&floorId=<%=floorId%>">
  				Elimina room
  				</a>
  			</li>
		</ol> 
	</p>
<!-- 
	 <h3>1. Inserisci una room</h3>
     <form action="RoomServlet" method="get">
     <input type="submit" value="InsertForm" name="richiesta">
     </form>
     
	 <h3>2. Visualizza tutte le Room</h3>
     <form action="RoomServlet" method="get">
     <input type="submit" value="ReadRoom" name="richiesta">
     </form>

     <h3>3. Elimina una room</h3>
     <form action="RoomServlet" method="get">
     <input type="submit" value="DeleteForm" name="richiesta">
     </form>

     <h3>4. Ricerca di una room</h3>
     <form action="RoomServlet" method="get">
     <input type="submit" value="SearchForm" name="richiesta">
     </form>

     <h3>5.logout<h3>
     <form action="Logout" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form>-->
 </body>
 </html>