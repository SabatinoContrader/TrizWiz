<html>
<head>
<title>Menu Principale Trader</title>
</head>
<body>
     <h1>Benvenuto <%= request.getSession().getAttribute("utente")%></h1>
     <h2>------- MENU TRADERS PLATFORM -------</h2>
     <h2>    <h2>

     <h3>1. Visualizza tutti i Prodotti</h3>
     <form action="ProdottoServlet" method="post">
     <input type="submit" value="ViewListProduct" name="richiesta">
     </form>

     <h3>2. Elimina un prodotto</h3>
     <a href="deleteProdotto.jsp">Elimina Prodotto</a>

     <h3>3. Ricerca un prodotto</h3>
     <form action="" method="post">
     <input type="submit" value="SearchProduct" name="richiesta">
     </form>

     <h3>4.logout<h3>
     <form action="LogoutServlet" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form>

</body>
</html>