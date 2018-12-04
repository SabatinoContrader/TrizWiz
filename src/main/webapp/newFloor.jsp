<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Questa è la jsp che ti permette di creare un nuovo floor <%=request.getAttribute("buildingId") %></h1>
	<form action="Floor?operation=sendDataForInsert&buildingId=<%=request.getParameter("buildingId")%>" method="post">
		<h3>Inserire nome floor: <input type="text" name="floorName" placeholder="inserire nome floor"></h3>
		<h3>Inserire descrizione: <input type="text" name="floorDescription" placeholder="inserire descrizione"></h3>
		<button type ="submit" value="sendDataForInsert" name="operation">Crea</button><br>
	</form>
</body>
</html>