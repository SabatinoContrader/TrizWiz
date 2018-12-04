<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>Seleziona l'id della room da modificare</h3>

	  <form action = "RoomServlet" method= "post">

		<div>Id Room:

			<select name="idselected">

				<c:forEach var="room" items="${rooms}">

						<option value="${room.id}">${room.id}</option>
				</c:forEach>
			</select>

		</div>
		
		<div>Cosa vuoi modificare?   &nbsp; 

			<select  name="campi">
  				<option value="1">Nome</option>
  				<option value="2">Descrizione</option>
			</select>
			&nbsp;&nbsp;
			<input type = "text" id = "value" name ="value" placeholder="Inserisci nuovo valore">
		</div>
		<div>
		<br>
		<button type = "submit" value="UpdateRoom" name="richiesta"> Modifica</button>
	</div>
	</form>
</body>
</html>