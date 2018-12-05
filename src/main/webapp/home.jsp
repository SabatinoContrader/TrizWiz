<html>
<head>
<title>Menu Principale TRIZWIZ</title>
</head>
<body>
<center>
     <h1>Benvenuto/a  <%= request.getSession().getAttribute("utente")%></h1>
     <h1>------- MENU PRINCIPALE TRIZWIZ -------</h1>
     <h2>    <h2>
</center>

     <h2>TOOLS:</h2>
     
     <h3>1. Contradiction matrix</h3>
     <form action="MenuServlet" method="post">
     <button type="submit" value="AssetMenu" name="richiesta">Click</button>
     </form>
     
     
     <h3>2. 76 standard solutions</h3>
     <form action="MenuServlet" method="post">
     <button type="submit" value="CastumersMenu" name="richiesta">click</button>
     </form>
     
     <!-- 
     <h3>3. Indietro</h3>
     <form action="MenuServlet" method="post">
     <input type="submit" value="Indietro" name="richiesta">
     </form>
     -->
       <h3>4. Logout<h3>
     <form action="LogoutServlet" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form>
    

</body>
</html>