<html>
<head>
<title>Menu Principale TRIZWIZ</title>
</head>
<body>
<center>
     <h1 style="height: auto; margin-top:40px;">------- MENU PRINCIPALE TRIZWIZ -------</h1>
     <h2>    <h2>
</center style="margin-top:50px;">
	<h1 style="height: auto; margin-left:70px;">Benvenuto/a  <%= request.getSession().getAttribute("utente")%></h1>
    <center> <h2>TOOLS:</h2></center>

<div style="height: auto; margin-left:30px; overflow: hidden">
<div style="width:50%; float:left;" >
<center>
     <h3>Contradiction matrix</h3>
     <form action="MenuServlet" method="post">
     <button type="submit" value="AssetMenu" name="richiesta">Click</button>
     </form>
</center>
</div>
<div style="width:50%; float:left;" >
<center>	
	<h3>76 standard solutions</h3>
	<form action="MenuServlet" method="post">
     <button type="submit" value="CastumersMenu" name="richiesta">Click</button>
     </form>
</center>	
</div>
</div>
<!--  
<div style="height: auto; margin-left:90px; overflow: hidden">
<div style="width:50%; float:left;" >
     <form action="MenuServlet" method="post">
     <button type="submit" value="AssetMenu" name="richiesta">Click</button>
     </form>
</div>
<div style="width:50%; float:left;" >
<form action="MenuServlet" method="post">
     <button type="submit" value="CastumersMenu" name="richiesta">Click</button>
     </form>
     
</div>     
</div> -->
     
     <!-- <h3>76 standard solutions</h3>
     <form action="MenuServlet" method="post">
     <button type="submit" value="CastumersMenu" name="richiesta">click</button>
     </form>
     
      
     <h3>3. Indietro</h3>
     <form action="MenuServlet" method="post">
     <input type="submit" value="Indietro" name="richiesta">
     </form>
<<<<<<< Updated upstream
     -->
    
       <center><h3> Logout<h3>

     <form action="LogoutServlet" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form></center>
    

</body>
</html>