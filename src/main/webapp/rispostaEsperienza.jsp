<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>


</head>
<body>
  	<h2>Sei loggato come <%= request.getSession().getAttribute("utente")%></h2> 
	
	<h2>RISPOSTA <%= request.getAttribute("rispostaInserimento")%></h2> 

<!--  <h1>INSERIMENTO RIUSCITO</h1> -->
</body>
</html>