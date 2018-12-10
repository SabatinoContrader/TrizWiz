<html>
<head>
<title>Menu Principale Matrix</title>
</head>
<body>
     <h1>Benvenuto/a <%= request.getSession().getAttribute("utente")%></h1>
     <h2>------- MENU PRINCIPALE MATRIX -------</h2>
     <h2>    <h2>
    
    <h3>1. Impostazioni parametri</h3>
     <form action="ParametriServlet" method="post">
     <button type="submit" value="vparametri" name="richiesta">Parametri</button>
     </form>
     
     <h3>2. Impostazioni principi</h3>
     <form action="PrincipiServlet" method="post">
     <button type="submit" value="vprincipi" name="richiesta">Principi</button>
     </form>
     
     
     <!-- da qui in poi cambiare i form -->
     
     <h3>3. Consulta contradictions matrix</h3>
     <form action="MatrixServlet" method="post">
     <button type="submit" value="insValoriMatrice" name="richiesta">Matrix</button>
     </form>
     
     <!--  <h3>4. Inserisci esperienza parametro</h3>
     <form action=ExpParametroServlet method="post">
     <button type="submit" value="InserisciEsperienza" name="richiesta">Ex parametro</button>
     </form>  -->
     
     <h3>4. Esperienza parametro</h3>
     <form action=ExpParametroServlet method="post">
     <button type="submit" value="EsperienzaParametro" name="richiesta">Ex parametro</button>
     
     <h3>5. Inserisci esperienza principi</h3>
     <form action="BadgeReaderServlet" method="post">
     <button type="submit" value="badgesReaderManagement" name="richiesta">Ex principi</button>
     </form>
     
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