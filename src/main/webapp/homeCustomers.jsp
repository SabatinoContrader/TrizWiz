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
     <form action="CustomersServlet" method="post">
     <button type="submit" value="usersManagement" name="richiesta"> Inserisci</button>
     </form>
     
     <h3> Visualizza le 76 standard solutions</h3>
     <form action="BadgeServlet" method="post">
     <button type="submit" value="badgesManagement" name="richiesta"> Visualizza </button>
     </form>
     
     <h3> Cancella una standard solution</h3>
     <form action="AssegnazioneServlet" method="post">
     <button type="submit" value="assegnazioneManagement" name="richiesta"> Cancella </button>
     </form>

     <h3> Aggiorna una standard solution</h3>
     <form action="AssegnazioneServlet" method="post">
     <button type="submit" value="assegnazioneManagement" name="richiesta"> Aggiorna </button>
     </form>
</center>
</div>     
<div style="width:50%; float:left;">
<center>
		<h1 style="color:red;">Categorie</h1>
     <h3> Inserisci Categoria</h3>
     <form action="CategorieStandarServlet" method="post">
     <button type="submit" value="InserisciCat" name="richiesta"> Inserisci </button>
     </form>
     
     <h3> Visualizza le Categorie</h3>
     <form action="CategorieStandarServlet" method="post">
     <button type="submit" value="VisualizzaCat" name="richiesta"> Visualizza</button>
     </form>
     
     <h3> Cancella una Categoria</h3>
     <form action="CategorieStandarServlet" method="post">
     <button type="submit" value="CancellaCat" name="richiesta"> Cancella</button>
     </form>

     <h3> Aggiorna una Categoria</h3>
     <form action="CategorieStandarServlet" method="post">
     <button type="submit" value="AggiornaCat" name="richiesta"> Aggiorna</button>
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