<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Parametri</title>
</head>
<body>

<h1>Menu Parametri</h1>
     
    
     
    <h3>1. VisualizzaParametri</h3>
      <form action="ParametriServlet" method="post">
     <button type="submit" value="visParametri" name="richiesta">Visualizza Parametri</button>
    </form>
    
    <h3>2. Inserisci Parametri</h3>
     <form action="ParametriServlet" method="post">
     <button type="submit" value="insert" name="richiesta"> Inserisci Parametri</button>
    </form>
     
    <h3>3. Cancella parametri</h3>
     <form action="ParametriServlet" method="post">
     <button type="submit" value="deleteParametri" name="richiesta"> Cancella Parametri</button>
    </form>
     
    <h3>4. Aggiorna parametri</h3>
     <form action="ParametriServlet" method="post">
     <button type="submit" value="updateParametri" name="richiesta"> Aggiorna Parametri</button>
    </form>
     
    <h3>5. Indietro</h3>
     <form action="MenuServlet" method="post">
     <input type="submit" value="Indietro" name="richiesta">
    </form>
        
</body>
</html>