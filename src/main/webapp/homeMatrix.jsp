<html>
<head>
<title>Menu Principale Matrix</title>
</head>
<body>
     <h1>Benvenuto/a <%= request.getSession().getAttribute("utente")%></h1>
     <h2>------- MENU PRINCIPALE MATRIX -------</h2>
     <h2>    <h2>
<!--  
     <h3>1. Assets</h3>
     <form action="AssetServlet" method="post">
     <button type="submit" value="assetsManagement" name="richiesta">Asset</button>
     </form>
     
     <h3>2. Badge Readers</h3>
     <form action="BadgeReaderServlet" method="post">
     <button type="submit" value="badgesReaderManagement" name="richiesta">Badge Reader</button>
     </form>
    -->
    <center>
    <h3> Inserisci parametro</h3>
     <form action="AssetServlet" method="post">
     <button type="submit" value="assetsManagement" name="richiesta">Ins parametro</button>
     </form>
     
     <h3> Visualizza parametri</h3>
     <form action="AssetServlet" method="post">
     <button type="submit" value="badgesReaderManagement" name="richiesta">Visualizza</button>
     </form>
     <h2>---------</h2>
     <h3> Inserisci Principio</h3>
     <form action="MenuMatrixServlet" method="post">
     <button type="submit" value="principio" name="richiesta">Ins principio</button>
     </form>
     
     <h3> Visualizza principi</h3>
     <form action="BadgeReaderServlet" method="post">
     <button type="submit" value="badgesReaderManagement" name="richiesta">Visualizza</button>
     </form>
    
     </center>
    
    
    <h3>1. Impostazioni parametri</h3>
     <form action="MenuMatrixServlet" method="post"><!-- AssetServlet -->
     <button type="submit" value="parametri" name="richiesta">Parametri</button>
     </form>
     
     <h3>2. Impostazioni principi</h3>
     <form action="MenuMatrixServlet" method="post"><!--BadgeReaderServlet-->
     <button type="submit" value="principi" name="richiesta">Principi</button>
     </form>
     
     
     <!-- da qui in poi cambiare i form -->
     
     <h3>3. Consulta contradictions matrix</h3>
     <form action="MenuMatrixServlet" method="post">
     <button type="submit" value="matrix" name="richiesta">Matrix</button>
     </form>
     
     <h3>4. Inserisci esperienza parametro</h3>
     <form action="MenuMatrixServlet" method="post">
     <button type="submit" value="expar" name="richiesta">Ex parametro</button>
     </form>
     
     
     <h3>5. Inserisci esperienza principi</h3>
     <form action="MenuMatrixServlet" method="post">
     <button type="submit" value="expri" name="richiesta">Ex principi</button>
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