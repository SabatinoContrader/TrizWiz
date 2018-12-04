<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">
<meta charset="ISO-8859-1">
<title>Update Customer</title>
<a href="Customer?mode=Return" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
<div class="readCustomer">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/edit-user.png"
			class="imgSuperUser">
			<h1>Modifica Customer</h1>
	</div>
	
	
	
	<div class="modifyCustomer">
	<h2 >Seleziona l'id del customer da modificare</h2>
	  <form action = "Customer" method= "post">
		<div class="idCustomer"><h3>Id Customer:</h3>
			<div style="padding-left:2%"><select style="border-radius: 10%" name="idselected">
				<c:forEach var="customer" items="${customers}">
						<option value="${customer.id}">${customer.id}</option>
				</c:forEach>
			</select>
			</div>
			
		</div></br>
		<div class="idCustomer"><h3>Cosa vuoi modificare?   </h3>&nbsp; 
			<select style="border-radius: 10%" name="selected">
  				<option value="1">Nome</option>
  				<option value="2">Cognome</option>
  				<option value="3">Data di Nascita</option>
  				<option value="4">Username</option>
 				 <option value="5">Password</option> 
			</select>
			&nbsp;&nbsp;
			<input type = "text" id = "value" name ="value" placeholder="Inserisci nuovo valore">
		</div></br>
		<button class="modifyButton" style="border-radius: 10%" type = "submit" name="mode" value="UpdateDb"> Modifica</button>
	</form>
	</div>
</body>

</html>