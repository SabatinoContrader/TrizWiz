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
	  <form action = "/Item/updateItem" method= "post">
		<div class="idItem"><h3>Id item:</h3>
			<div style="padding-left:2%"><select style="border-radius: 10%" name="idItem">
				<c:forEach var="itemCustomer" items="${itemCustomer}">
						<option value="${itemCustomer.idItems}">${itemCustomer.idItems}</option>
				</c:forEach>
			</select>
			</div>
							<div class="commento"><h2>Commento item:</h2>
				<input type="text" class="form-control" id="commento" name="commento"
					placeholder="Inserisci commento"></div>
					
					
		</div></br>
			
		<button class="modifyButton" style="border-radius: 10%" type = "submit"> Modifica</button>
		
	</form>
	</div>
</body>

</html>