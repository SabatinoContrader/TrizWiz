<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<!DOCTYPE html>
<html>
<head>
<link href="/resources/css/styles.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Update Item</title>
<a href="/Item/menu" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
<div class="readItem">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/edit-user.png"
			class="imgSuperUser">
			<h1>Modifica item</h1>
	</div>
	
	
	
	<div class="modifyItem">
	<h2 >Seleziona l'id dell'item da modificare</h2>
	  <form action = "/Item/update" method= "post">
		<div class="idItems"><h3>Id item:</h3>
			<div style="padding-left:2%"><select style="border-radius: 10%" name="idselected">
				<c:forEach var="item" items="${item}">
						<option value="${item.id}">${item.id}</option>
				</c:forEach>
			</select>
			</div>
			
		</div></br>
		<div class="idCustomer">
			<input type = "text" id = "value" name ="value" placeholder="Inserisci nuovo valore">
		</div></br>
		<button class="modifyButton" style="border-radius: 10%" type = "submit"> Modifica</button>
	</form>
	</div>
</body>

</html>