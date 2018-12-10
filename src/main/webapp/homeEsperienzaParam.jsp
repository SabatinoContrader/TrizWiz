<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Inserisci Esperienza Parametro</h3>
     <form action=ExpParametroServlet method="post">
     <button type="submit" value="InserisciEsperienza" name="richiesta">Inserisci la tua esperienza</button>
     </form>
     
     <h3>Visualizza Esperienza Parametri</h3>
     <form action=ExpParametroServlet method="post">
     <button type="submit" value="visEsperienza" name="richiesta">Visualizza le esperienze</button>
     </form>
</body>
</html>