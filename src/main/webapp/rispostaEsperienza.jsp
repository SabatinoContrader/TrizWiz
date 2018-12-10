<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>


</head>
<body>
  	<h2>Sei loggato come <%= request.getSession().getAttribute("utente")%></h2> 
	
	<h2>RISPOSTA <%= request.getAttribute("rispostaInserimento")%></h2> 

	<h3>6. Indietro</h3>
     <form action="MenuServlet" method="post">
     <input type="submit" value="Indietro" name="richiesta">
     </form>
     
       <h3>7. Logout<h3>
     <form action="LogoutServlet" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form>
     
</body>
</html>