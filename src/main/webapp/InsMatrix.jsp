<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>--------------VISUALIZZA MATRICE---------------------</h2>
     <form action = "MatrixServlet" method= "post">
     <h3>ID Parametro da migliorare: <input type = "text" name ="param1" ></h3>
     <h3>ID Parametro da non peggiorare:  <input type = "text" name ="param2" ></h3>
     <button type = "submit" value = "visualizzaMatrice" name = "richiesta">Richiedi Parametri</button><br>
</body>
</html>