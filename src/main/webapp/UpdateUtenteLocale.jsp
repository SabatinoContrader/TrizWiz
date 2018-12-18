<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<!DOCTYPE html>
<html>
<head>
<link href="/resources/css/styles.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Update Triz Consultant</title>
<a href="/Customer/goBack" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
<div class="readCustomer">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/edit-user.png"
			class="imgSuperUser">
			<h1>Modifica Triz Consultant</h1>
	</div>
	
	
	
	<div class="modifyCustomer">
	<h2 >Seleziona l'username del Triz Consultant da modificare</h2>
	  <form action = "/UtentiLocali/update" method= "post">
		<div class="idCustomer"><h3>Id Triz Consultant:</h3>
			<div style="padding-left:2%"><select style="border-radius: 10%" name="idselected">
				<c:forEach var="utentiLocali" items="${utentiLocali}">
						<option value="${utentiLocali.nomeLogin}">${utentiLocali.nomeLogin}</option>
				</c:forEach>
			</select>
			</div>
			
		</div></br>
		<div class="idCustomer"><h3> Modifica la password dell'utente selezionato </h3>&nbsp; 
			<select style="border-radius: 10%" name="selected">
			
  				 <!-- <option value="1">Username</option> -->
 				 <option value="1">Password</option> 
			</select>
			&nbsp;&nbsp;
			<input type = "text" id = "value" name ="value" placeholder="Inserisci nuovo valore">
		</div></br>
		<button class="modifyButton" style="border-radius: 10%" type = "submit"> Modifica</button>
	</form>
	</div>
</body>

</html>