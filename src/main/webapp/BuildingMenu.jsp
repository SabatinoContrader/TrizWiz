<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p> 
	   	<h2>------- MENU BUILDING -------</h2>
	</p>
	<p>
		<ol>
  			<li> 
  				<a href="Building?richiesta=InserisciBuilding">
  				Inserisci building
  				</a> 
  			</li>
  			<li>
  				<a href="Building?richiesta=VisualizzaBuildings">
  				Visualizza buildings
  				</a>
  			</li>
  			<li> 
  				<a href="Building?richiesta=ModificaBuilding">
  				Modifica building
  				</a>
  			</li>
  			<li>
				<a href="Building?richiesta=EliminaBuilding">
  				Elimina building
  				</a>
  			</li>
  			<li>
				<a href="Building?richiesta=EliminaBuilding">
  				Elimina building
  				</a>
  			</li>
  			
		</ol> 
	</p>

<!-- 
 <h1>Benvenuto <%= request.getSession().getAttribute("utente")%></h1>
     <h2>------- MENU BUILDING PLATFORM -------</h2>
     <h2>    <h2>
     
     <h3>1. Inserisci building</h3>
     <form action="ProdottoServlet" method="post">
     <input type="submit" value="ViewListProduct" name="richiesta">
     </form>

     <h3>2. Visualizza buildings</h3>
     <form action="ProdottoServlet" method="post">
     <input type="submit" value="ViewListProduct" name="richiesta">
     </form>

     <h3>3. Modifica building</h3>
     <form action="" method="post">
     <input type="submit" value="SearchProduct" name="richiesta">
     </form>

     <h3>4. Elimina building</h3>
     <a href="deletebuilding.jsp">Elimina Prodotto</a>
     
     
     <h3>5.logout<h3>
     <form action="LogoutServlet" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form>   -->
</body>
</html>