<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MENU' PRINCIPI</title>
</head>
<body>


<h1> Menu Principi </h1>
     
     <form action="PrincipiServlet" method="post"> 
     
    <h3>1. Visualizza Principi</h3>
      <form action="PrincipiServlet" method="post">
     <button type="submit" value="visualizzaPrincipi" name="richiesta">Visualizza</button>
     </form>
    
     <h3>2. Inserisci Principi</h3>
     <form action="PrincipiServlet" method="post">
     <button type="submit" value="insert" name="richiesta">Ins principio</button>
     </form>
     
     <h3>3. Cancella Principi</h3>
     <form action="PrincipiServlet" method="post">
     <button type="submit" value="delete" name="richiesta">Cancella</button>
     </form>
     
     <h3>4. Aggiorna Principi</h3>
     <form action="PrincipiServlet" method="post">
     <button type="submit" value="aggiornaPrincipi" name="richiesta"> Aggiorna Principi</button>
     
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