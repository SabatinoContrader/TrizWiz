<html>
<head>
<title>76 Standard Solutions</title>
</head>
<body>
<center>
     <h1>Benvenuto <%= request.getSession().getAttribute("utente")%></h1>
     <h2>------- MENU 76 Standard Solutions -------</h2>
     <h2>    <h2>
</center>
<div style="height: auto; overflow: hidden">

<div style="width:50%; float:left;" >
<center>
		<h1 style="color:blue;">Standard</h1>
     <h3> Inserisci una standard solution</h3>
     <form action="StandardServlet" method="post">
     <button type="submit" value="inserisciStandard" name="richiesta"> Inserisci</button>
     </form>
     
     <h3> Visualizza le standard solutions</h3>
     <form action="StandardServlet" method="post">
     <button type="submit" value="visualizzaStandard" name="richiesta"> Visualizza </button>
     </form>
     
     <h3> Cancella una standard solution</h3>
     <form action="StandardServlet" method="post">
     <button type="submit" value="cancellaStandard" name="richiesta"> Cancella </button>
     </form>

     <h3> Aggiorna una standard solution</h3>
     <form action="StandardServlet" method="post">
     <button type="submit" value="aggiornaStandard" name="richiesta"> Aggiorna </button>
     </form>
</center>
</div>     
<div style="width:50%; float:left;">
<center>
		<h1 style="color:red;">Categorie</h1>
		
     <h3> Inserisci Categoria</h3>
     <form action="CategorieStandarServlet" method="post">
     <button type="submit" value="inserisciCategoria" name="richiesta"> Inserisci </button>
     </form>
     
     <h3> Visualizza le Categorie</h3>
     <form action="CategorieStandarServlet" method="post">
     <button type="submit" value="VisualizzaCat" name="richiesta"> Visualizza</button>
     </form>
     
     <h3> Cancella una Categoria</h3>
     <form action="CategorieStandarServlet" method="post">
     <button type="submit" value="delete" name="richiesta"> Cancella</button>
     </form>

     <h3> Aggiorna una Categoria</h3>
     <form action="CategorieStandarServlet" method="post">
     <button type="submit" value="aggiornaCat" name="richiesta"> Aggiorna</button>
     </form>
</center>
</div>
</div>

<center>

     <h3> Indietro</h3>
     <form action="CustomersServlet" method="post">
     <input type="submit" value="indietro" name="richiesta">
     </form>
     
       <h3>logout<h3>
     <form action="LogoutServlet" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form>
</center>
</body>
</html>