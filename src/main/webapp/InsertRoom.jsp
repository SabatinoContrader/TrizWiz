<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Inserisci i dati della room</h3>
<h1>Questa è la jsp <%=request.getParameter("floorId") %></h1>
     <form action="RoomServlet?richiesta=InsertRoom&floorId=<%=request.getAttribute("floorId")%>" method="post">

     	<h4>Nome: <input type = "text"  name ="nome" placeholder = "inserisci nome"></h4>     	

     	<h4>Descrizione: <input type = "text"  name ="description" placeholder = "inserisci la descrizione"></h4>

     	<input type="submit" value="InsertRoom" name="richiesta">

     </form>

</body>

</html>
</body>
</html>